package br.usjt.projeto.semestral.Service;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.projeto.semestral.DAO.ChamadoDao;
import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ChamadoView;
import br.usjt.projeto.semestral.Model.MeusChamados;
import br.usjt.projeto.semestral.Model.Solucionador;
import br.usjt.projeto.semestral.Model.TodosOsChamados;
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
	 * @throws ParseException 
	 */
	public void criarChamado(Chamado chamado) throws SQLException, IOException, ParseException
	{
		SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 System.out.println(a.format(cal.getTime()));
		 String dataFormatada = (a.format(cal.getTime()));
		 
		 
		chamado.setDataInicio(dataFormatada);
		chamado.setStatus("aberto");
		System.out.println(chamado.toString());
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
	public ChamadoView selecionaChamadoView(ChamadoView chamado)
	{
		return dao.selecionarChamadoView(chamado.getId());
	}
	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<TodosOsChamados> selecionaTodosOsChamados() throws IOException
	{
		return dao.SelecionarTodosChamados();
	} 
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<TodosOsChamados> selecionaChamadosAbertos() throws SQLException, IOException
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
	public List<TodosOsChamados> buscaPorChave(String chave) throws IOException
	{
		return dao.SelecionarChamadosPorChave(chave);
	}
	
	public List<TodosOsChamados> SelecionarTodosChamadosDoSolucionador(Chamado solucionador) throws IOException
	{
		return dao.SelecionarTodosChamadosDoSolucionador(solucionador);
	}
	public List<TodosOsChamados> selecionaHistorico(Chamado chamado) throws SQLException, IOException
	{
		return dao.selecionarTodosOsChamadosFechados(chamado);
	}
	
}
