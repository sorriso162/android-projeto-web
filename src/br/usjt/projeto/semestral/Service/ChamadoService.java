package br.usjt.projeto.semestral.Service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.usjt.projeto.semestral.DAO.ChamadoDao;
import br.usjt.projeto.semestral.Model.Chamado;
/**
 * 
 * @author Bruni
 *
 */
@Service
public class ChamadoService {

	private ChamadoDao dao;
	@Autowired
	/**
	 * 
	 * @param dao
	 */
	public ChamadoService(ChamadoDao dao)
	{
		this.dao = dao;
	}
	/**
	 * 
	 * @param chamado
	 */
	public void criarChamado(Chamado chamado)
	{
		dao.criarChamado(chamado);
	}
	/**
	 * 
	 * @param chamado
	 */
	public void removeChamado(Chamado chamado)
	{
		dao.excluirChamado(chamado);
	}
	/**
	 * 
	 * @param chamado
	 */
	public void atualizaChamado(Chamado chamado)
	{
		dao.atualizarChamado(chamado);
	}
	/**
	 * 
	 * @param chamado
	 * @return
	 */
	public Chamado selecionaChamado(Chamado chamado)
	{
		return dao.selecionarChamado(chamado.getId());
	}
	/**
	 * 
	 * @return
	 */
	public List<Chamado> selecionaTodosOsChamados()
	{
		return dao.SelecionarTodosChamados();
	} 
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<Chamado> selecionaChamadosAbertos() throws SQLException, IOException
	{
		return dao.selecionarTodosOsChamadosEmAberto();
	}
	
	private String montaURL()
	{
		String url = "http://localhost:8080/SistemaChamado/rest/chamados/3";
	
		return url;
		
	}
	@Transactional
	public Chamado buscaRest()
	{
		RestTemplate template =  new RestTemplate();
		Chamado resultado  = template.getForObject(montaURL(), Chamado.class);
		resultado.setId(resultado.getId()+1);
		resultado.setDataInicio(new Date(System.currentTimeMillis()));
		System.out.println(resultado);
		
		criarChamado(resultado);
		return resultado;
	}
	
	
	
	
}
