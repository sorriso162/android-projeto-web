package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Service.ChamadoService;
@Transactional
@RestController
public class SistemaChamadoRest {
	
	private ChamadoService cs;
	@Autowired
	public SistemaChamadoRest(ChamadoService cs)
	{
		this.cs = cs;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="rest/chamados")
	public @ResponseBody List<Chamado> listagem() throws IOException {
		List<Chamado> lista = null;
		lista = cs.selecionaTodosOsChamados();
		return lista;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="rest/chamados/{id}")
	public @ResponseBody Chamado selecionaChamado(@PathVariable("id") int id)
	{
		Chamado chamado = new Chamado();
		chamado.setId(id);
		 return cs.selecionaChamado(chamado);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="rest/removeChamados/{id}")
	public  @ResponseBody Chamado apagaChamado(@PathVariable("id") int id)
	{
		Chamado chamado = new Chamado();
		chamado.setId(id);
		 cs.removeChamado(chamado);
		return null;
	}

}
