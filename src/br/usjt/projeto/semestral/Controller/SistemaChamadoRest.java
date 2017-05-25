package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
import br.usjt.projeto.semestral.Model.ListaDeChamados;
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
	public @ResponseBody List<ListaDeChamados> listagemAberta() throws IOException, SQLException {
		List<ListaDeChamados> lista = null;
		System.out.println("entrou aqui");
		lista = cs.selecionaChamadosAbertos();
		return lista;
	}
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
	@RequestMapping(method=RequestMethod.POST, value="rest/criar")
	public void InsereChamado(@RequestBody Chamado chamado) throws IOException, SQLException, ParseException {
		
		cs.criarChamado(chamado);
	}
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
	@RequestMapping(method=RequestMethod.POST, value="rest/user")
	public Usuario selecionaChamado(@RequestBody Usuario usuario) throws IOException
	{		
		System.out.println(usuario.toString());
		if(us.validarUsuario(usuario))
		{
			return us.buscaCpf(usuario);
		}else{
		System.out.println("nao existe");
		return null;
		}
	}
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
	@RequestMapping(method=RequestMethod.POST, value="rest/update")
	public void atualiza(@RequestBody Chamado chamado) throws IOException
	{		System.out.println("chegou aqui1");
		cs.atualizaChamado(chamado);  
	}
	
	
	

}
