package br.usjt.projeto.semestral.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.projeto.semestral.Model.Usuario;
/**
 * 
 * @author Bruni
 *
 */
@Repository
public class UsuarioDao {
	
	@PersistenceContext
	EntityManager manager;
	
	/**
	 * 
	 * @param usuario
	 */
	public void incluirUsuario(Usuario usuario)
	{
		manager.persist(usuario);
	}
	/**
	 * 
	 * @param usuario
	 */
	public void atualizaUsuario(Usuario usuario)
	{
		manager.merge(usuario);
	}
	/**
	 * 
	 * @param usuario
	 */
	public void excluiUsuario(Usuario usuario)
	{
		manager.remove(manager.find(Usuario.class, usuario.getId()));
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Usuario selecionarUsuario(int id)
	{
		return manager.find(Usuario.class, id);
	}
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public Usuario selecionarUsuarioPorCpf(Usuario usuario)
	{
		String sqlSelect = "select u from Usuario u where u.cpf = :cpf";
		Query query = manager.createQuery(sqlSelect);
		query.setParameter("cpf", usuario.getCpf());
		Object lista = query.getSingleResult();
	
		return (Usuario) lista;
	}
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios()
	{
		return manager.createQuery("select l from usuario l").getResultList();
		
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean ValidaUsuario(Usuario usuario)
	{
		String sqlSelect = "select u from Usuario u where u.cpf = :cpf and u.senha  = :senha";
		Query query = manager.createQuery(sqlSelect);
		query.setParameter("cpf", usuario.getCpf());
		query.setParameter("senha", usuario.getSenha());
		
		@SuppressWarnings("unchecked")
		List<Usuario> result = query.getResultList();
		return (result != null && result.size()== 1);
	}	
}
