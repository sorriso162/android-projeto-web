package br.usjt.projeto.semestral.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.projeto.semestral.DAO.SolucionadorDao;
import br.usjt.projeto.semestral.Model.Administrador;
import br.usjt.projeto.semestral.Model.Solucionador;


@Service
public class SolucionadorService implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private SolucionadorDao dao;
@Autowired
public SolucionadorService(SolucionadorDao dao)
{
	this.dao = dao;
}

/**
 * 
 * @param usuario
 * @throws IOException
 */
public void criarSolucionador(Solucionador usuario) throws IOException
{
	dao.incluirSolucionador(usuario);
}
/**
 * 
 * @param usuario
 * @throws IOException
 */
public void removerSolucionador(Solucionador usuario) throws IOException
{
	dao.excluiSolucionador(usuario);
}
/**
 * 
 * @param usuario
 * @throws IOException
 */
public void atualizarSolucionador(Solucionador usuario) throws IOException
{
	dao.atualizaSolucionador(usuario);
}
/**
 * 
 * @param usuario
 * @return
 * @throws IOException
 */
public List<Solucionador> selecionarTodosOsUsuarios() throws IOException
{
	return dao.listarSolucionador();
}
/**
 * 
 * @param usuario
 * @return
 * @throws IOException
 */
public Solucionador selecionarusuario(Solucionador usuario) throws IOException
{
	return dao.selecionarSolucionador(usuario.getId());
}
/**
 * 
 * @param usuario
 * @return
 * @throws IOException
 */
public boolean validarUsuario(Solucionador usuario) throws IOException
{
 	return dao.ValidaUsuario(usuario);
	
}
public Solucionador buscaPorCpf(Solucionador solucionador)
{
	return dao.selecionarSolucionadorPorCpf(solucionador);
}

public List<Solucionador> buscaChave(String chave)
{
	return dao.procuraSolucionadorPorChave(chave);
}
}
