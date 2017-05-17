package br.usjt.projeto.semestral.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.projeto.semestral.DAO.UsuarioDao;
import br.usjt.projeto.semestral.Model.Usuario;
/**
 * 
 * @author Bruni
 *
 */
@Service
public class UsuarioService {

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
}
