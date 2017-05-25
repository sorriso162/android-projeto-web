package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.projeto.semestral.Model.Administrador;
import br.usjt.projeto.semestral.Model.ListaDeChamados;
import br.usjt.projeto.semestral.Model.Solucionador;
import br.usjt.projeto.semestral.Model.Usuario;
import br.usjt.projeto.semestral.Service.AdministradorService;
import br.usjt.projeto.semestral.Service.ChamadoService;
import br.usjt.projeto.semestral.Service.SolucionadorService;
import br.usjt.projeto.semestral.Service.UsuarioService;
/**
 * 
 * @author Bruni
 *
 */
@Transactional
@Controller
public class SistemaChamadoLoginController {

	private UsuarioService us;
	private ChamadoService cs;
	private SolucionadorService ss;
	private AdministradorService as;
	/**
	 * 
	 * @param us
	 */
	@Autowired
	public SistemaChamadoLoginController(UsuarioService us,ChamadoService cs,SolucionadorService ss,AdministradorService as)
	{
		this.us = us;
		this.cs = cs;
		this.ss = ss;
		this.as = as;
	}
	/**
	 * 
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	@Transactional
	@RequestMapping("/")
	String index() 
	{	
		return "login";
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("login")
	String loginForm()
	{
		return "login";
	}
	@RequestMapping("pagina_inicial")
	public String inicial()
	{
		return "Inicio";
	}
	@RequestMapping("usuario_menu")
	String usuarioMenu( HttpSession session, Usuario usuario) throws SQLException, IOException
	{
		System.out.println("usuario"+usuario.toString());
		session.setAttribute("meusChamados", cs.meusChamados(usuario));
		return "usuarioMenu";
	}
	/**
	 * 
	 * @param usuario
	 * @param session
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws SQLException 
	 */
	@RequestMapping("fazer_login")
	public String fazerLogin(Usuario usuario,Solucionador solucionador,Administrador adm, HttpSession session, Model model) throws IOException, SQLException
	{
		System.out.println(usuario.toString());
	if(us.validarUsuario(usuario))
	{
		System.out.println("Entrou aqui");
		Usuario usuario1 = new Usuario();
		usuario1 = us.buscaCpf(usuario);
		session.setAttribute("usuario",usuario1);
		
		
		return "redirect:pagina_inicial";
		
	}else if(as.login(adm)){
			Administrador adm1 = new Administrador();
			adm1 = as.buscaPorCpf(adm);
			session.setAttribute("usuario", adm1);
			return "redirect:pagina_inicial";
			}else{
				System.out.println("usuario e senha invalidos");
				return "redirect:login";
			}
	}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
}
