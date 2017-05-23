package br.usjt.projeto.semestral.DAO;




import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ListaDeChamados;

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
	 */
	
	public void criarChamado(Chamado chamado) throws SQLException
	{
		
		
		String query = "INSERT INTO chamado (descricao,dataFim,dateInicio,status,tipo,idUsuario) VALUES(?,?,?,?,?,?)";
		chamado.setDataInicio(new Date(System.currentTimeMillis()));
<<<<<<< HEAD
		chamado.setIdSolucionador(0);
		System.out.println(chamado.toString());
		manager.persist(chamado);
=======
		try(PreparedStatement pst = conn.prepareStatement(query);
				)
		{
			pst.setString(1, chamado.getDescricao());
			pst.setDate(2, chamado.getDateFim());
			pst.setDate(3, chamado.getDataInicio());
			pst.setString(4, chamado.getStatus());
			pst.setString(5, chamado.getTipo());
			pst.setInt(6, chamado.getIdUsuario());
			pst.executeUpdate();
		}
>>>>>>> 042cde7b10cc1b3a948710f76d571c7cd42aa3a8
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
		String query = "Select c.id, c.descricao, c.dateInicio,c.dataFim, c.status, u.nome"
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
						chamado1.setDateInicio(rs.getDate("c.dateInicio"));
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
	
}
