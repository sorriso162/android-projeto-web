package br.usjt.projeto.semestral.DAO;




import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ChamadoView;
import br.usjt.projeto.semestral.Model.ListaDeChamados;
import br.usjt.projeto.semestral.Model.MeusChamados;
import br.usjt.projeto.semestral.Model.Usuario;

@Repository
public class ChamadoDao {
Connection conn;
	
@PersistenceContext
EntityManager manager;
	
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
	 */
	
	public void criarChamado(Chamado chamado) throws SQLException, IOException
	{
		
		String query = "INSERT INTO chamado (descricao,dataFim,dataInicio,status,tipo,idUsuario) VALUES(?,?,?,?,?,?)";
		chamado.setDataInicio(new Date(System.currentTimeMillis()));
		chamado.setStatus("aberto");
		chamado.setIdSolucionador(1);
		System.out.println("vai inserir"+chamado.toString());
		manager.persist(chamado);
		
		try(PreparedStatement pst = conn.prepareStatement(query);)
		{
			pst.setString(1, chamado.getDescricao());
			pst.setDate(2, chamado.getDateFim());
			pst.setDate(3, chamado.getDataInicio());
			pst.setString(4, chamado.getStatus());
			pst.setString(5, chamado.getTipo());
			pst.setInt(6, chamado.getIdUsuario());
			pst.executeUpdate();
			System.out.println("inseriu");
		}catch(SQLException e){
			e.printStackTrace();
			throw new IOException(e);
				}
		
	}
	/**
	 * 
	 * @param chamado
	 * @throws IOException 
	 */
	public void atualizarChamado(Chamado chamado) throws IOException
	{
		System.out.println("chegou aqui2");
		if(chamado.getTipo() == "fechado"){
			String query = "UPDATE FROM chamado (DateFim) values (?)";
			chamado.setDateFim(new Date(System.currentTimeMillis()));
			try(PreparedStatement pst = conn.prepareStatement(query);)
				{
				System.out.println("chegou aqui3");
					pst.setDate(1, chamado.getDateFim());
					pst.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
					throw new IOException(e);
						}
		}
			
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
	
	public ChamadoView selecionaMeuChamado(ChamadoView chamado) throws SQLException, IOException
	{
		
		ChamadoView chamado1  = new ChamadoView();;
		String sqlSelect = "SELECT c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,u.nome,s.nome  FROM chamado c INNER JOIN usuario u on c.idUsuario = u.id "
				+ "LEFT JOIN solucionador s on s.idSolucionador = c.idSolucionador WHERE c.id = '"+chamado.getId()+"'";
		try(PreparedStatement pst = conn.prepareStatement(sqlSelect);
				ResultSet result = pst.executeQuery();)
		{
			if(result.first())
			{
				
				chamado1.setId(result.getInt("id"));
				chamado1.setDataFim(result.getDate("dataFim"));
				chamado1.setDateInicio(result.getDate("dataInicio"));
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
	 */
	@SuppressWarnings("unchecked")
	public List<Chamado> SelecionarTodosChamados()
	{
		return manager.createQuery("select c from Chamado c").getResultList();
	}
	
	public List<ListaDeChamados> selecionarTodosOsChamadosEmAberto() throws SQLException, IOException
	{
		System.out.println("entrou aqui2");
		ListaDeChamados chamado = new ListaDeChamados();
		chamado.setStatus("aberto");
		String query = "Select c.id, c.descricao, c.dataInicio,c.dataFim, c.status, u.nome"
				+ " from chamado c Inner Join usuario u on c.idUsuario = u.id"
				+ "   where status = 'aberto'";
		ArrayList<ListaDeChamados> lista = new ArrayList<>();
		ListaDeChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{	
						System.out.println("entrou aqui3");
						chamado1 = new ListaDeChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDateInicio(rs.getDate("c.dataInicio"));
						chamado1.setDataFim(rs.getDate("c.dataFim"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setUsuario(rs.getString("u.nome"));
						
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
	public List<MeusChamados> meusChamados(Usuario usuario) throws SQLException, IOException
	{
		System.out.println("entrou aqui2");
		MeusChamados chamado = new MeusChamados();
		chamado.setIdUsuario(usuario.getId());
		String query = "Select c.id, c.descricao, c.tipo, c.dataInicio,c.dataFim, c.status, u.nome, c.idUsuario"
				+ " from chamado c Inner Join usuario u on c.idUsuario = u.id inner join solucionador s on s.idSolucionador = c.idSolucionador"
				+ "   where c.idUsuario = '"+usuario.getId()+"'";
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
						chamado1.setDateInicio(rs.getDate("c.dataInicio"));
						chamado1.setDataFim(rs.getDate("c.dataFim"));
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
