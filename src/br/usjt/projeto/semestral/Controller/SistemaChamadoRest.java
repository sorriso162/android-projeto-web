package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.Usuario;
import br.usjt.projeto.semestral.Service.ChamadoService;
import br.usjt.projeto.semestral.Service.UsuarioService;
@Transactional
@RestController
public class SistemaChamadoRest {
	
	private ChamadoService cs;
	private UsuarioService us;
	@Autowired
	public SistemaChamadoRest(ChamadoService cs,UsuarioService us)
	{
		this.cs = cs;
		this.us = us;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="rest/chamados")
	public @ResponseBody List<Chamado> listagem() throws IOException {
		List<Chamado> lista = null;
		lista = cs.selecionaTodosOsChamados();
		return lista;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="rest/chamados/user")
	public Usuario selecionaChamado( @RequestBody Usuario usuario) throws IOException
	{
		

		if(us.validarUsuario(usuario))
		{
			return us.buscaCpf(usuario);
		}else{
		
		
		return null;}
		
		  
	}
	@RequestMapping(method=RequestMethod.POST, value="rest/chamados/login")
	public Usuario login(@RequestBody Usuario usuario) throws IOException
	{
		us.validarUsuario(usuario);
		Usuario usuario1 = usuario;
		
		
		return usuario1;
	}
	
	

}
