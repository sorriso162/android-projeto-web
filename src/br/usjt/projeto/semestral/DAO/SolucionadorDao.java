package br.usjt.projeto.semestral.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.projeto.semestral.Model.Administrador;
import br.usjt.projeto.semestral.Model.Solucionador;
import br.usjt.projeto.semestral.Model.Usuario;


@Repository
public class SolucionadorDao {
	@PersistenceContext
	EntityManager manager;

	public void incluirSolucionador(Solucionador usuario)
	{
		usuario.setTipo("solucionador");
		manager.persist(usuario);
	}
	/**
	 * 
	 * @param usuario
	 */
	public void atualizaSolucionador(Solucionador usuario)
	{
		manager.merge(usuario);
	}
	/**
	 * 
	 * @param usuario
	 */
	public void excluiSolucionador(Solucionador usuario)
	{
		manager.remove(manager.find(Solucionador.class, usuario.getId()));
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Solucionador selecionarSolucionador(int id)
	{
		return manager.find(Solucionador.class, id);
	}
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Solucionador> listarSolucionador()
	{
		return manager.createQuery("select l from Solucionador l").getResultList();
		
	}

	public Solucionador selecionarSolucionadorPorCpf(Solucionador solucionador)
	{
		String sqlSelect = "select u from Solucionador u where u.cpf = :cpf";
		Query query = manager.createQuery(sqlSelect);
		query.setParameter("cpf", solucionador.getCpf());
		Object lista = query.getSingleResult();
		System.out.println(lista);
		return (Solucionador) lista;
	}
	
	public boolean ValidaUsuario(Solucionador usuario)
	{
		String sqlSelect = "select u from Solucionador u where u.cpf = :cpf and u.senha = :senha";
		Query query = manager.createQuery(sqlSelect);
		query.setParameter("cpf", usuario.getCpf());
		query.setParameter("senha", usuario.getSenha());
		
		@SuppressWarnings("unchecked")
		List<Solucionador> result = query.getResultList();
		return (result != null && result.size()== 1);
	}	
	public List<Solucionador> procuraSolucionadorPorChave(String chave)
	{
		System.out.println(chave);
		String sqlSelect = "select u from Solucionador u where u.nome like :chave or u.cpf like :chave or u.id like :chave";
		Query query = manager.createQuery(sqlSelect);
		query.setParameter("chave", "%"+chave+"%");
		List<Solucionador> lista = query.getResultList();
		System.out.println(lista);
		return  lista;
	}
}
