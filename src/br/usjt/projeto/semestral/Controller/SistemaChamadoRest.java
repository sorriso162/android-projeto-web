package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ChamadoView;
import br.usjt.projeto.semestral.Model.ListaDeChamados;
import br.usjt.projeto.semestral.Model.TodosOsChamados;
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
	@RequestMapping(method=RequestMethod.GET, value="rest/um/{chave}")
	public @ResponseBody ChamadoView MostraChamadoPorId(@PathVariable int chave) throws IOException, SQLException {
		System.out.println(chave);
		ChamadoView chamado = new ChamadoView();
		chamado.setId(chave);
		System.out.print(cs.selecionaChamadoView(chamado));
		return cs.selecionaChamadoView(chamado);
	}
	@SuppressWarnings("unchecked")
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
	@RequestMapping(method=RequestMethod.GET, value="rest/lista")
	public @ResponseBody List<TodosOsChamados> listagemAberta() throws IOException, SQLException {
		List<TodosOsChamados> lista = null;
		System.out.println("entrou aqui");
		lista = cs.selecionaChamadosAbertos();
		return lista;
	}
	@SuppressWarnings("unchecked")
	@Consumes("Content-Type: application/json")
	@Produces("Content-Type: application/json")
	@RequestMapping(method=RequestMethod.GET, value="rest/lista/{chave}")
	public List<TodosOsChamados> TodosOsChamadosPorChave(@PathVariable String chave) throws IOException, SQLException {
		List<TodosOsChamados> lista = null;
		System.out.println(chave);
		lista = cs.buscaPorChave(chave);
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
	{		System.out.println("atualiza rest");
	Chamado chamado1 = new Chamado();
	chamado1.setId(chamado.getId());
	chamado1 = cs.selecionaChamado(chamado1);
	
	if(chamado.getDescricao() != null)
	{
		chamado1.setDescricao(chamado.getDescricao());
		cs.atualizaChamado(chamado1);
		
	}
	if(chamado.getIdSolucionador()!= null)
	{
		chamado1.setIdSolucionador(chamado.getIdSolucionador());
		cs.atualizaChamado(chamado1);
	}
	if(chamado.getStatus() != null)
	{
		if(chamado.getStatus().equals("fechado")){
		chamado1.setStatus(chamado.getStatus());
		SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 System.out.println(a.format(cal.getTime()));
		 String dataFormatada = (a.format(cal.getTime()));
		chamado1.setDateFim(dataFormatada);
		}
		chamado1.setStatus(chamado.getStatus());
		cs.atualizaChamado(chamado1);

	}
	}
	
	
	

}
