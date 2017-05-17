package br.usjt.projeto.semestral.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.projeto.semestral.Model.Administrador;

@Repository
public class AdministradorDao {
	@PersistenceContext
	EntityManager manager;
	
	
	public Administrador selecionarAdministrador(int id)
	{
		return manager.find(Administrador.class, id);
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean ValidaUsuario(Administrador adm)
	{
		String sqlSelect = "select u from Administrador u where u.cpf = :cpf  u.senha = :senha";
		Query query = manager.createQuery(sqlSelect);
		query.setParameter("cpf", adm.getCpf());
		query.setParameter("senha", adm.getSenha());
		
		@SuppressWarnings("unchecked")
		List<Administrador> result = query.getResultList();
		return (result != null && result.size()== 1);
	}	
}
