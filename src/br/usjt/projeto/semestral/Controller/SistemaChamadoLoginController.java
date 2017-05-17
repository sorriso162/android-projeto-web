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
	String index() throws SQLException, IOException
	{
		List<ListaDeChamados> listadeChamados = cs.selecionaChamadosAbertos();
		for(int i = 0 ; i < listadeChamados.size(); i++ ){
		System.out.print(listadeChamados.get(i).toString());}
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
	public String fazerLogin(Usuario usuario,Solucionador solucionador,Administrador adm, HttpSession session, Model model) throws IOException
	{
	if(us.validarUsuario(usuario))
	{
		session.setAttribute("usuario",us.selecionarusuario(usuario));
		System.out.println(usuario);
		
		return "redirect:usuario_menu";
		
		}else if(ss.validarUsuario(solucionador))
		{
			session.setAttribute("solucionador", ss.selecionarusuario(solucionador));
			System.out.println(usuario);
		}else if(as.login(adm))
		{
			session.setAttribute("adm", as.selecionaAdm(adm));
			System.out.println(adm);
		}else
		{
			return "redrect:login_form";
		}
	return "redrect:login_form";
	}
	
	
}
