package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.Usuario;
import br.usjt.projeto.semestral.Service.ChamadoService;
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
	/**
	 * 
	 * @param us
	 */
	@Autowired
	public SistemaChamadoLoginController(UsuarioService us,ChamadoService cs)
	{
		this.us = us;
		this.cs = cs;
	}
	/**
	 * 
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	@Transactional
	@RequestMapping("/")
	String index() throws SQLException, IOException
	{
		Chamado chamado ;
		chamado  =  cs.buscaRest();
	return "a" ;
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("login_form")
	String loginForm()
	{
		return "login_form";
	}
	/**
	 * 
	 * @param usuario
	 * @param session
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("fazer_login")
	public String fazerLogin(Usuario usuario,HttpSession session, Model model) throws IOException
	{
	if(us.validarUsuario(usuario))
	{
		session.setAttribute("logado",us.selecionarusuario(usuario));
		System.out.println(usuario);
		if(usuario.getTipo() == "usuario"){
			return "redirect:usuario_menu";
		}else if(usuario.getTipo() == "administrador")
		{
			return "redirect:administrador_menu";
		}else if(usuario.getTipo() == "suporte")
		{
			return "redirect:suporte_menu";
		}
	}
	return "redirct:login_form";
	}
	
	
}
