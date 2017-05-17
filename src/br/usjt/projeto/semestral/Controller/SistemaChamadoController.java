package br.usjt.projeto.semestral.Controller;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.Usuario;
import br.usjt.projeto.semestral.Service.ChamadoService;
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
	/**
	 * 
	 * @param us
	 * @param cs
	 */
	@Autowired
	public SistemaChamadoController (UsuarioService us, ChamadoService cs)
	{
		this.cs = cs;
		this.us = us;
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
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
	@RequestMapping("selecionar_usuario")
	public String selecionarUsuario(Usuario usuario) throws IOException
	{
		us.selecionarusuario(usuario);
		return "usuario_informacao";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("lista_de_usuarios")
	public String listarUsuarios(Usuario usuario) throws IOException
	{
		us.selecionarTodosOsUsuarios(usuario);
		return "todos_os_usuarios";
	}
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("atualizar_usuario")
	public String atualizaUsuario(Usuario usuario) throws IOException
	{
		us.atualizarUsuario(usuario);
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
