package br.usjt.projeto.semestral.Service;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.projeto.semestral.DAO.ChamadoDao;
import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ListaDeChamados;

/**
 * 
 * 
 * @author Bruni
 * @param <Usuario>
 *
 */
@Service
public class ChamadoService<Usuario> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public List<ListaDeChamados> selecionaChamadosAbertos() throws SQLException, IOException
	{
		return dao.selecionarTodosOsChamadosEmAberto();
	}
	
	
	
	
	
	
}
