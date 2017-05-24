package br.usjt.projeto.semestral.Service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.projeto.semestral.DAO.AdministradorDao;
import br.usjt.projeto.semestral.Model.Administrador;

@Service
public class AdministradorService implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private AdministradorDao dao;
@Autowired
public AdministradorService(AdministradorDao dao)
{
	this.dao = dao;
}

public Administrador selecionaAdm(Administrador adm)
{
	return dao.selecionarAdministrador(adm.getId());
}

public boolean login(Administrador adm)
{
	return dao.ValidaUsuario(adm);
}

public Administrador buscaPorCpf(Administrador adm)
{
	return dao.selecionarAdministradorPorCpf(adm);
}
}
