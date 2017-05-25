package br.usjt.projeto.semestral.DAO;




import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import br.usjt.projeto.semestral.Model.TodosOsChamados;
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
		String sqlInsert = " insert into chamado (idUsuario,id,descricao,dataInicio,dataFim,tipo,status) values(?,?,?,?,?,?,?)";
		try(PreparedStatement stm = conn.prepareStatement(sqlInsert);)
		{
			stm.setInt(1, chamado.getIdUsuario());
			stm.setInt(2, chamado.getId());
			stm.setString(3, chamado.getDescricao());
			stm.setString(4, chamado.getDataInicio());
			stm.setString(5, chamado.getDateFim());
			stm.setString(6, chamado.getTipo());
			stm.setString(7, chamado.getStatus());
			stm.executeUpdate();
		}	catch(SQLException e){
			e.printStackTrace();
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
			chamado.setDateFim(""+new Date(System.currentTimeMillis()));
			try(PreparedStatement pst = conn.prepareStatement(query);)
				{
				System.out.println("chegou aqui3");
					pst.setString(1, chamado.getDateFim());
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
		String sqlSelect = "SELECT c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,u.nome,s.nome  FROM chamado c INNER JOIN usuario u on c.idUsuario = u.idUsuario "
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
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public List<TodosOsChamados> SelecionarTodosChamados() throws IOException
	{
		TodosOsChamados chamado = new TodosOsChamados();
		
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
	
	public List<ListaDeChamados> selecionarTodosOsChamadosEmAberto() throws SQLException, IOException
	{
		
		ListaDeChamados chamado = new ListaDeChamados();
		chamado.setStatus("aberto");
		String query = "Select c.id, c.descricao, c.dataInicio,c.dataFim, c.status, u.nome"
				+ " from chamado c Inner Join usuario u on c.idUsuario = u.idUsuario"
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
		System.out.println(usuario.toString());
		MeusChamados chamado = new MeusChamados();
		chamado.setIdUsuario(usuario.getId());
		String query = "Select c.id, c.descricao, c.tipo, c.dataInicio,c.dataFim, c.status, u.nome, c.idUsuario"
				+ " from chamado c Inner Join usuario u on c.idUsuario = u.idUsuario  left join solucionador s on s.idSolucionador = c.idSolucionador"
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
