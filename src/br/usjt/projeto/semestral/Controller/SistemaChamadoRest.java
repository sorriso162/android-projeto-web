package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

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
	@SuppressWarnings("unchecked")
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
	@RequestMapping(method=RequestMethod.POST, value="rest/lista")
	public @ResponseBody List<Chamado> listagemAberta() throws IOException, SQLException {
		List<Chamado> lista = null;
		System.out.println("entrou aqui");
		lista = cs.selecionaChamadosAbertos();
		return lista;
	}
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
<<<<<<< HEAD
	@RequestMapping(method=RequestMethod.POST, value="rest/chamados/user")
	public Usuario LoginUsuario(@RequestBody Usuario usuario) throws IOException
=======
	@RequestMapping(method=RequestMethod.POST, value="rest/criar")
	public void InsereChamado(@RequestBody Chamado chamado) throws IOException, SQLException {
		
		cs.criarChamado(chamado);
	}
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
	@RequestMapping(method=RequestMethod.POST, value="rest/user")
	public Usuario selecionaChamado(@RequestBody Usuario usuario) throws IOException
>>>>>>> 042cde7b10cc1b3a948710f76d571c7cd42aa3a8
	{		
		System.out.println(usuario.toString());
		if(us.validarUsuario(usuario))
		{
			return us.buscaCpf(usuario);
		}else{
		System.out.println("nao existe");
		
		return null;}
		
		  
	}
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
<<<<<<< HEAD
	@RequestMapping(method=RequestMethod.POST, value="rest/chamados/criarChamado")
	public void inserirChamado(@RequestBody Chamado chamado) throws IOException
	{		
		System.out.println(chamado.toString());
		cs.criarChamado(chamado);
			  
	}
	
=======
	@RequestMapping(method=RequestMethod.POST, value="rest/update")
	public void atualiza(@RequestBody Chamado chamado) throws IOException
	{		System.out.println("chegou aqui1");
		
		cs.atualizaChamado(chamado);
		  
	}
	
	
	
>>>>>>> 042cde7b10cc1b3a948710f76d571c7cd42aa3a8

}
