package br.usjt.projeto.semestral.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.usjt.projeto.semestral.DAO.UsuarioDao;
import br.usjt.projeto.semestral.Model.Usuario;
/**
 * 
 * @author Bruni
 *
 */
@Service
public class UsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDao dao;
	/**
	 * 
	 * @param dao
	 */
	@Autowired
	public UsuarioService(UsuarioDao dao)
	{
		this.dao = dao;
	}
	/**
	 * 
	 * @param usuario
	 * @throws IOException
	 */
	public void criarUsuario(Usuario usuario) throws IOException
	{
		dao.incluirUsuario(usuario);
	}
	/**
	 * 
	 * @param usuario
	 * @throws IOException
	 */
	public void removerUsuario(Usuario usuario) throws IOException
	{
		dao.excluiUsuario(usuario);
	}
	/**
	 * 
	 * @param usuario
	 * @throws IOException
	 */
	public void atualizarUsuario(Usuario usuario) throws IOException
	{
		dao.atualizaUsuario(usuario);
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	public List<Usuario> selecionarTodosOsUsuarios() throws IOException
	{
		return dao.listarUsuarios();
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	public Usuario selecionarusuario(Usuario usuario) throws IOException
	{
		return dao.selecionarUsuario(usuario.getId());
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	public boolean validarUsuario(Usuario usuario) throws IOException
	{
	 	return dao.ValidaUsuario(usuario);
		
	}
	public Usuario buscaCpf(Usuario usuario )throws IOException
	{
		return dao.selecionarUsuarioPorCpf(usuario);
	}
	
	
	
	public Usuario buscaRest (Usuario usuario) throws IOException
	{
		Gson gson = new Gson();
		 
		// converte objetos Java para JSON e retorna JSON como String
		String json = gson.toJson(usuario);
		try{
		String l  = "http://localhost:8080/SistemaChamado/rest";
		URL url = new URL(l);
		 HttpURLConnection conn  = (HttpURLConnection) url.openConnection();
		 
		 conn.setDoOutput(true);
		 conn.setRequestProperty("Content-Type", "application/json");
		 conn.setConnectTimeout(5000);
		 conn.setReadTimeout(5000);
         OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
         out.write(json);
         System.out.println("A url"+out);
         out.close();
		 try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
     catch (Exception e) {
       e.printStackTrace();
    }
} catch (Exception e1) {
	 e1.printStackTrace();
}
		return usuario;	
	}
	
}
