package br.usjt.projeto.semestral.DAO;




import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ChamadoView;
import br.usjt.projeto.semestral.Model.MeusChamados;
import br.usjt.projeto.semestral.Model.Solucionador;
import br.usjt.projeto.semestral.Model.TodosOsChamados;
import br.usjt.projeto.semestral.Model.Usuario;

@Repository
public class ChamadoDao {
Connection conn;
	
@PersistenceContext
EntityManager manager;
	/**
	 * 
	 * @param ds
	 * @throws IOException
	 */
	@Autowired
	public ChamadoDao(DataSource ds) throws IOException{
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
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
		manager.persist(chamado);
	}
	
	/**
	 * 
	 * @param chamado
	 * @throws IOException 
	 */
	public void atualizarChamado(Chamado chamado) throws IOException
	{
		System.out.println("atualizou" + chamado.toString());	
		manager.merge(chamado);
	}
			
		
	/**
	 * 
	 * @param chamado
	 */
	public void excluirChamado(Chamado chamado)
	{
		manager.remove(manager.find(Chamado.class, chamado.getId()));
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Chamado selecionarChamado(int id)
	{	
		
		Boolean estado = false;
		Chamado chamado = manager.find(Chamado.class, id);
		if(chamado.getStatus().equals("aberto"))
		{
			estado = true;
		}
		if(estado = true)
		{
			return chamado;
		}	else	{
						return null;
					}
			
	}
	/**
	 * 
	 * @param i
	 * @return
	 */
	public ChamadoView selecionarChamadoView(int i)
	{	
		ChamadoView chamado1  = new ChamadoView();
		Boolean estado = false;
		String sqlSelect = "SELECT c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,u.nome,s.nome  FROM chamado c INNER JOIN usuario u on c.idUsuario = u.idUsuario "
				+ "LEFT JOIN solucionador s on s.idSolucionador = c.idSolucionador WHERE c.id = '"+i+"'";
		try(PreparedStatement pst = conn.prepareStatement(sqlSelect);
				ResultSet result = pst.executeQuery();)
		{
			if(result.first())
			{
				
				chamado1.setId(result.getInt("id"));
				chamado1.setDataFim(result.getString("dataFim"));
				chamado1.setDateInicio(result.getString("dataInicio"));
				chamado1.setDescricao(result.getString("descricao"));
				chamado1.setNomeSolucionador(result.getString("s.nome"));
				chamado1.setNomeUsuario(result.getString("u.nome"));
				chamado1.setTipo(result.getString("tipo"));
				chamado1.setStatus(result.getString("status"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			
	}
	
		if(chamado1.getStatus().equals("aberto"))
		{
			estado = true;
		}
		if(estado = true)
		{
			return chamado1;
		}	else	{
						return null;
					}
			
	}
	/**
	 * 
	 * @param chamado
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	
	public ChamadoView selecionaMeuChamado(ChamadoView chamado) throws SQLException, IOException
	{
		
		ChamadoView chamado1  = new ChamadoView();;
		String sqlSelect = "SELECT c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,u.nome,s.nome  FROM chamado c INNER JOIN usuario u on c.idUsuario = u.idUsuario "
				+ "LEFT JOIN solucionador s on s.idSolucionador = c.idSolucionador WHERE c.id = '"+chamado.getId()+"'";
		try(PreparedStatement pst = conn.prepareStatement(sqlSelect);
				ResultSet result = pst.executeQuery();)
		{
			if(result.first())
			{
				
				chamado1.setId(result.getInt("id"));
				chamado1.setDataFim(result.getString("dataFim"));
				chamado1.setDateInicio(result.getString("dataInicio"));
				chamado1.setDescricao(result.getString("descricao"));
				chamado1.setNomeSolucionador(result.getString("s.nome"));
				chamado1.setNomeUsuario(result.getString("u.nome"));
				chamado1.setTipo(result.getString("tipo"));
				chamado1.setStatus(result.getString("status"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new IOException(e);
		}
		return chamado1;
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<TodosOsChamados> SelecionarTodosChamados() throws IOException
	{
		String query = " select c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,s.nome,u.nome from chamado c "
				+ "inner join usuario u on c.idUsuario = u.idUsuario "
				+ "left join solucionador s on c.idSolucionador = s.idSolucionador";
		ArrayList<TodosOsChamados> lista = new ArrayList<>();
		TodosOsChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{	
						System.out.println("entrou aqui3");
						chamado1 = new TodosOsChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDataFim(rs.getString("c.dataFim"));
						chamado1.setDateInicio(rs.getString("c.dataInicio"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setTipo(rs.getString("c.tipo"));
						chamado1.setNomeSolucionador(rs.getString("s.nome"));
						chamado1.setNomeUsuario(rs.getString("u.nome"));
						lista.add(chamado1);
						}
						
				}catch(SQLException e)
					{
						e.printStackTrace();
						throw new IOException(e);
					}
		return lista;
	}
	/**
	 * 
	 * @param solucionador
	 * @return
	 * @throws IOException
	 */
	public List<TodosOsChamados> SelecionarTodosChamadosDoSolucionador(Chamado solucionador) throws IOException
	{
		String query = " select c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,s.nome,u.nome from chamado c "
				+ "inner join usuario u on c.idUsuario = u.idUsuario "
				+ "left join solucionador s on c.idSolucionador = s.idSolucionador where s.idSolucionador = '"+solucionador.getIdSolucionador().getId()+"' and c.status = 'Em processo'";
		ArrayList<TodosOsChamados> lista = new ArrayList<>();
		TodosOsChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{	
						System.out.println("entrou aqui3");
						chamado1 = new TodosOsChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDataFim(rs.getString("c.dataFim"));
						chamado1.setDateInicio(rs.getString("c.dataInicio"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setTipo(rs.getString("c.tipo"));
						chamado1.setNomeSolucionador(rs.getString("s.nome"));
						chamado1.setNomeUsuario(rs.getString("u.nome"));
						lista.add(chamado1);
						}
						
				}catch(SQLException e)
					{
						e.printStackTrace();
						throw new IOException(e);
					}
		return lista;
	}
	
	/**
	 * 
	 * @param chave
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<TodosOsChamados> SelecionarChamadosPorChave(String chave) throws IOException
	{
		String query = " select c.id, c.descricao, c.dataFim, c.dataInicio, c.status, c.tipo,s.nome, u.nome from chamado c "
				+ "inner join usuario u on c.idUsuario = u.idUsuario "
				+ "left join solucionador s on c.idSolucionador = s.idSolucionador where  c.id like '%"+chave+"%' or u.nome like '%"+chave+"%' or s.nome like '%"+chave+"%' or c.status like '%"+chave+"'";
		ArrayList<TodosOsChamados> lista = new ArrayList<>();
		TodosOsChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{	
						
						System.out.println("Entrou aqui chave");
						chamado1 = new TodosOsChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDataFim(rs.getString("c.dataFim"));
						chamado1.setDateInicio(rs.getString("c.dataInicio"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setTipo(rs.getString("c.tipo"));
						chamado1.setNomeSolucionador(rs.getString("s.nome"));
						chamado1.setNomeUsuario(""+rs.getString("u.nome"));
						lista.add(chamado1);
						}
						
				}catch(SQLException e)
					{
						e.printStackTrace();
						throw new IOException(e);
					}
		return lista;
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<TodosOsChamados> selecionarTodosOsChamadosEmAberto() throws SQLException, IOException
	{
		
		TodosOsChamados chamado = new TodosOsChamados();
		chamado.setStatus("aberto");
		String query = "select c.id, c.descricao, c.dataFim, c.dataInicio, c.status, c.tipo, s.nome, u.nome from chamado c "
				+ "inner join usuario u on c.idUsuario = u.idUsuario "
				+ "left join solucionador s on c.idSolucionador = s.idSolucionador where status = 'aberto'";
		ArrayList<TodosOsChamados> lista = new ArrayList<>();
		TodosOsChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{	
						System.out.println("entrou aqui3");
						chamado1 = new TodosOsChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDataFim(rs.getString("c.dataFim"));
						chamado1.setDateInicio(rs.getString("c.dataInicio"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setTipo(rs.getString("c.tipo"));
						chamado1.setNomeSolucionador(rs.getString("s.nome"));
						chamado1.setNomeUsuario(rs.getString("u.nome"));
						if(chamado1.getStatus().equals(chamado.getStatus())){
						lista.add(chamado1);
						}
						}
				}catch(SQLException e)
					{
						e.printStackTrace();
						throw new IOException(e);
					}
		return lista;
	}
	/**
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<TodosOsChamados> selecionarTodosOsChamadosFechados(Chamado c) throws SQLException, IOException
	{
		
		
		TodosOsChamados chamado = new TodosOsChamados();
		chamado.setStatus("aberto");
		String query = "select c.id, c.descricao, c.dataFim, c.dataInicio, c.status, c.tipo, s.nome, u.nome from chamado c "
				+ "inner join usuario u on c.idUsuario = u.idUsuario "
				+ "left join solucionador s on c.idSolucionador = s.idSolucionador where s.idSolucionador = '"+c.getIdSolucionador().getId()+"' and c.status = 'fechado'";
		ArrayList<TodosOsChamados> lista = new ArrayList<>();
		TodosOsChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{	
						System.out.println("entrou aqui3");
						chamado1 = new TodosOsChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDataFim(rs.getString("c.dataFim"));
						chamado1.setDateInicio(rs.getString("c.dataInicio"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setTipo(rs.getString("c.tipo"));
						chamado1.setNomeSolucionador(rs.getString("s.nome"));
						chamado1.setNomeUsuario(rs.getString("u.nome"));
						
						lista.add(chamado1);
						
						}
				}catch(SQLException e)
					{
						e.printStackTrace();
						throw new IOException(e);
					}
		return lista;
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<MeusChamados> meusChamados(Usuario usuario) throws SQLException, IOException
	{
		MeusChamados chamado = new MeusChamados();
		chamado.setIdUsuario(usuario.getId());
		String query = "Select c.id, c.descricao, c.tipo, c.dataInicio,c.dataFim, c.status, u.nome, c.idUsuario"
				+ " from chamado c Inner Join usuario u on c.idUsuario = u.idUsuario  left join solucionador s on s.idSolucionador = c.idSolucionador"
				+ "   where c.idUsuario = '"+usuario.getId()+"' order by status";
		ArrayList<MeusChamados> lista = new ArrayList<>();
		MeusChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{	
						System.out.println("entrou no laço");
						chamado1 = new MeusChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDateInicio(rs.getString("c.dataInicio"));
						chamado1.setDataFim(rs.getString("c.dataFim"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setUsuario(rs.getString("u.nome"));
						chamado1.setIdUsuario(rs.getInt("c.idUsuario"));
						chamado1.setTipo(rs.getString("c.tipo"));
						System.out.println(chamado1.toString());
						lista.add(chamado1);
						
						}
				}catch(SQLException e)
					{
						e.printStackTrace();
						throw new IOException(e);
					}
		return lista;
	}
	
}
