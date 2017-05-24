package br.usjt.projeto.semestral.Service;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.projeto.semestral.DAO.ChamadoDao;
import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ChamadoView;
import br.usjt.projeto.semestral.Model.ListaDeChamados;
import br.usjt.projeto.semestral.Model.MeusChamados;
import br.usjt.projeto.semestral.Model.Usuario;

/**
 * 
 * 
 * @author Bruni
 * @param <Usuario>
 *
 */
@Service
public class ChamadoService implements Serializable{
	
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
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void criarChamado(Chamado chamado) throws SQLException, IOException
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
	 * @throws IOException 
	 */
	public void atualizaChamado(Chamado chamado) throws IOException
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
	public List<MeusChamados> meusChamados(Usuario usuario) throws SQLException, IOException
	{
		return dao.meusChamados(usuario);
	}
	
	public ChamadoView chamadoView(ChamadoView chamado) throws SQLException, IOException
	{
		return dao.selecionaMeuChamado(chamado);
	}
	
	
	
}
