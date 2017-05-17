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
	
	public List<Chamado> selecionarTodosOsChamadosEmAberto() throws SQLException, IOException
	{
		Chamado chamado = new Chamado();
		chamado.setStatus("aberto");
		String query = "Select c.id, c.descricao, c.dataInicio, c.status, u.nome from chamado c Inner Join usuario u where status = 'aberto'";
		ArrayList<Chamado> lista = new ArrayList<>();
		Chamado chamado1;
		
		try(PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();)
				{
					while(rs.next())
					{
						
						chamado1 = new Chamado();
						chamado1.setId(rs.getInt("id"));
						chamado1.setDescricao(rs.getString("descricao"));
						chamado1.setDataInicio(rs.getDate("dataInicio"));
						chamado.setStatus(rs.getString("status"));
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
