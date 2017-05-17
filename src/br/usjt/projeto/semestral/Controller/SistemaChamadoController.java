package br.usjt.projeto.semestral.Controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.Solucionador;
import br.usjt.projeto.semestral.Model.Usuario;
import br.usjt.projeto.semestral.Service.AdministradorService;
import br.usjt.projeto.semestral.Service.ChamadoService;
import br.usjt.projeto.semestral.Service.SolucionadorService;
import br.usjt.projeto.semestral.Service.UsuarioService;
/**
 * 
 * @author Bruni
 *
 */
@Transactional
@Controller
public class SistemaChamadoController {

	private ChamadoService cs;
	private UsuarioService us;
	private SolucionadorService ss;
	private AdministradorService as;
	/**
	 * 
	 * @param us
	 * @param cs
	 */
	@Autowired
	public SistemaChamadoController (UsuarioService us, ChamadoService cs,SolucionadorService ss,AdministradorService as)
	{
		this.cs = cs;
		this.us = us;
		this.ss = ss;
		this.as = as;
	}
	//parte DO administrador ******************************************************************************
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador criar usuario      ------------------------------------------------------------------------------
	@RequestMapping("criar_usuario")
	public String criarUsuario(Usuario usuario) throws IOException
	{
		
		us.criarUsuario(usuario);
		return "lista_de_usuarios";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador cria solucionador  ------------------------------------------------------------------------------
	@RequestMapping("criar_solucionador")
	public String criarSolucionador(Solucionador usuario) throws IOException
	{
		
		ss.criarSolucionador(usuario);
		return "lista_de_solucionador";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador apaga usuario   ------------------------------------------------------------------------------
	@RequestMapping("apagar_usuario")
	public String apagarUsuario(Usuario usuario) throws IOException
	{
		us.removerUsuario(usuario);
		return "lista_de_usuario";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador apaga solucionador ------------------------------------------------------------------------------
	@RequestMapping("apagar_solucionador")
	public String apagarSolucionador(Solucionador usuario) throws IOException
	{
		ss.removerSolucionador(usuario);
		return "lista_de_solucionador";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	// administrador seleciona usuario  ------------------------------------------------------------------------------
	@RequestMapping("selecionar_usuario")
	public String selecionarUsuario(Usuario usuario,HttpSession session) throws IOException
	{
		System.out.println(us.selecionarusuario(usuario));
		session.setAttribute("Verusuario", us.selecionarusuario(usuario));
		return "usuario_informacao";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador seleciona solucionador ------------------------------------------------------------------------------
	@RequestMapping("selecionar_solucionador")
	public String selecionarSolucionador(Solucionador usuario, HttpSession session) throws IOException
	{
		System.out.println("Solucionador: "+ ss.selecionarusuario(usuario));
		session.setAttribute("Versolucionador", ss.selecionarusuario(usuario));
		
		return "solucionador_informacao";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador lista todos os usuarios------------------------------------------------------------------------------
	@RequestMapping("lista_de_usuarios")
	public String listarUsuarios(HttpSession session) throws IOException
	{
		
		System.out.println("Todos Os usuairos:  "+ us.selecionarTodosOsUsuarios());
		session.setAttribute("listaDeUsuairos", us.selecionarTodosOsUsuarios());
		return "todos_os_usuarios";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador lista solucionadores
	@RequestMapping("lista_de_solucionadores")
	public String listarSolucionadores(HttpSession session) throws IOException
	{
		System.out.println(ss.selecionarTodosOsUsuarios());
		session.setAttribute("listDeSolucionadores", ss.selecionarTodosOsUsuarios());
		return "todos_os_solucionadores";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador atualizar usuario      ------------------------------------------------------------------------------
	@RequestMapping("atualizar_usuario")
	public String atualizaUsuario(Usuario usuario) throws IOException
	{
		us.atualizarUsuario(usuario);
		return "usuario_informacao";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("atualizar_solucionador")
	public String atualizaSolucionador(Solucionador usuario) throws IOException
	{
		ss.atualizarSolucionador(usuario);
		return "usuario_informacao";
	}
	// ----------------------DAQUI PARA BAIXO E A PARTE DO CHAMADO---------------------------------
	/**
	 * 
	 * @param chamado
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("criar_chamado")
	public String criarChamado(Chamado chamado) throws IOException
	{
		cs.criarChamado(chamado);
		return "meus_chamados";
	}
	/**
	 * 
	 * @param chamado
	 * @return
	 */
	@RequestMapping("atualizar_chamado")
	public String atualizarChamado(Chamado chamado)
	{
		cs.criarChamado(chamado);
		return "chamado_informacao";
	}
	/**
	 * 
	 * @param chamado
	 * @return
	 */
	@RequestMapping("excluir_chamado")
	public String excluirChamado(Chamado chamado)
	{
		cs.removeChamado(chamado);
		return "lista_de_chamados";
	}
	/**
	 * 
	 * @param chamado
	 * @return
	 */
	@RequestMapping("selecionar_chamado")
	public String selecionarChamado(Chamado chamado)
	{
		cs.selecionaChamado(chamado);
		return "chamado_informacao";
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("listar_chamados")
	public String listarChamados()
	{
		cs.selecionaTodosOsChamados();
		return "todos_os_chamados";
	}
}