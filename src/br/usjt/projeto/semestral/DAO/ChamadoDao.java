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
	 */
	public void criarChamado(Chamado chamado)
	{
		chamado.setDataInicio(new Date(System.currentTimeMillis()));
		chamado.setIdSolucionador(0);
		System.out.println(chamado.toString());
		manager.persist(chamado);
	}
	/**
	 * 
	 * @param chamado
	 */
	public void atualizarChamado(Chamado chamado)
	{
		if(chamado.getTipo() == "fechado"){
			
			chamado.setDateFim(new Date(System.currentTimeMillis()));
			manager.merge(chamado);
			}else
				{
					manager.merge(manager.find(Chamado.class, chamado.getId()));
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
		ListaDeChamados chamado = new ListaDeChamados();
		chamado.setStatus("aberto");
		String query = "Select c.id, c.descricao, c.dateInicio,c.dataFim, c.status, u.nome,s.nome"
				+ " from chamado c Inner Join usuario u on c.idUsuario = u.id"
				+ " inner join solucionador s on c.idSolucionador = s.id"
				+ "   where status = 'aberto'";
		ArrayList<ListaDeChamados> lista = new ArrayList<>();
		ListaDeChamados chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{
						
						chamado1 = new ListaDeChamados();
						chamado1.setId(rs.getInt("c.id"));
						chamado1.setDescricao(rs.getString("c.descricao"));
						chamado1.setDateInicio(rs.getDate("c.dateInicio"));
						chamado1.setDataFim(rs.getDate("c.dataFim"));
						chamado1.setStatus(rs.getString("c.status"));
						chamado1.setUsuario(rs.getString("u.nome"));
						chamado1.setSolucionador(rs.getString("s.nome"));
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
