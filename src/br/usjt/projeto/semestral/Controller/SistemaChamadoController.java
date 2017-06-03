package br.usjt.projeto.semestral.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.projeto.semestral.Model.Chamado;
import br.usjt.projeto.semestral.Model.ChamadoView;
import br.usjt.projeto.semestral.Model.MeusChamados;
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
	//parte DO administrador Com usuario ******************************************************************************
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
			usuario.setTipo("usuario");
			System.out.println(usuario.toString());
			us.criarUsuario(usuario);
			return "redirect:lista_de_usuarios";
		}
		
		@RequestMapping("cria_usuario")
		public String criaUsuario()
		{
			return "criarUsuario";
		}
		/**
		 * 
		 * @param usuario
		 * @return
		 * @throws IOException
		 * @throws SQLException 
		 */
		//administrador apaga usuario   ------------------------------------------------------------------------------
		@RequestMapping("excluir_usuario")
		public String apagarUsuario(Usuario usuario) throws IOException, SQLException
		{
			List<MeusChamados> lista = cs.meusChamados(usuario);
			if(lista.size() == 0){
			us.removerUsuario(usuario);
			return "redirect:lista_de_usuarios";
			}else{
				return"erroDeleteUsuario";
			}
			}
		/**
		 * 
		 * @param usuario
		 * @return
		 * @throws IOException
		 */
		@RequestMapping("usuarioView")
		public String informacaoUsuario(Usuario usuario,HttpSession session) throws IOException
		{
			session.setAttribute("view", us.selecionarusuario(usuario));
			return "redirect:usuario_View";
			
		}
		@RequestMapping("usuario_View")
		public String usuerView(){
			return "UsuarioView";
		}
		
		//administrador lista todos os usuarios------------------------------------------------------------------------------
		@RequestMapping("lista_de_usuarios")
		public String listarUsuarios(HttpSession session) throws IOException
		{
			
			System.out.println("Todos Os usuairos:  "+ us.selecionarTodosOsUsuarios());
			session.setAttribute("listaDeUsuairos", us.selecionarTodosOsUsuarios());
			return "ListaDeUsuario";
		}
		@RequestMapping("pesquisar_usuario")
		public String pesquisaUsuario(String chave, HttpSession session)
		{
			session.setAttribute("listaDeUsuairos", us.buscaChave(chave));
			return "ListaDeUsuario";
		}
		//administrador atualizar usuario      ------------------------------------------------------------------------------
		@RequestMapping("atualizar_usuario")
		public String atualizaUsuario(Usuario usuario) throws IOException
		{
			us.atualizarUsuario(usuario);
			return "usuario_informacao";
		}
		//parte DO administrador Com Solucionador ******************************************************************************
	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	//administrador cria solucionador  ------------------------------------------------------------------------------
	@RequestMapping("criar_solucionador")
	public String criarSolucionador( Solucionador usuario) throws IOException
	{
		
		ss.criarSolucionador(usuario);
		return "redirect:lista_solucionador";
	}
	
	@RequestMapping("cria_solucionador")
	public String criaSolucionador()
	{
		return "criaSolucionador";
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
	
	
	
	//administrador seleciona solucionador ------------------------------------------------------------------------------
	@RequestMapping("solucionadorView")
	public String selecionarSolucionador(Solucionador usuario, HttpSession session) throws IOException
	{
		System.out.println("Solucionador: "+ ss.selecionarusuario(usuario));
		session.setAttribute("view", ss.selecionarusuario(usuario));
		
		return "redirect:solucionador_informacao";
	}
	@RequestMapping("solucionador_informacao")
	public String solucionadorView()
	{
		return "SolucionadorView";
	}
	
	//administrador lista solucionadores
	@RequestMapping("lista_solucionador")
	public String listarSolucionadores(HttpSession session) throws IOException
	{
		System.out.println(ss.selecionarTodosOsUsuarios());
		session.setAttribute("listaDeSolucionadores", ss.selecionarTodosOsUsuarios());
		return "redirect:todos_os_solucionadores";
	}
	@RequestMapping("todos_os_solucionadores")
	public String todosSolucionadores()
	{
		return"ListaDeSolucionadores";
	}
	 @RequestMapping("pesquisar_solucionador")
	 public String pesquisaSolucionador(String chave, HttpSession session)
	 {
		 session.setAttribute("listaDeSolucionadores", ss.buscaChave(chave));
		 return "ListaDeSolucionadores";
	 }
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
	 * @throws SQLException 
	 */
	@RequestMapping("fazer_chamado")
	public String fazerChamadoView()
	{
		return "NovaChamada";
	}
	@RequestMapping("insere_erro_modal")
	public String insereErro()
	{
		return "ModalErroIsereFinalDeSemana";
	}
	@RequestMapping("criar_chamado")
	public String criarChamado(Chamado chamado) throws IOException, SQLException, ParseException
	{
		
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7){
			return"redirect:insere_erro_modal";
		}else{
		System.out.println("criando chamado"+chamado.toString());
		cs.criarChamado(chamado);
		return "redirect:fazer_chamado";
		}
	}
	@RequestMapping("usuario_foi_inserido")
	public String usuarioInserido()
	{
		return "ModalUsuarioInserido";
	}
	/**
	 * 
	 * @param chamado
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 */
	@RequestMapping("atualizar_chamado")
	public String atualizarChamado(Chamado chamado) throws SQLException, IOException
	{
		Chamado chamado1 = new Chamado();
		chamado1.setId(chamado.getId());
		chamado1 = cs.selecionaChamado(chamado1);
		

		if(chamado.getDescricao() != null)
		{
			chamado1.setDescricao(chamado.getDescricao());
			cs.atualizaChamado(chamado1);
			
		}
		if(chamado.getIdSolucionador()!= null)
		{
			chamado1.setIdSolucionador(chamado.getIdSolucionador());
			cs.atualizaChamado(chamado1);
		}
		if(chamado.getStatus().equals("fechado"))
		{
			chamado1.setStatus(chamado.getStatus());
			SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			 Calendar cal = Calendar.getInstance();
			 System.out.println(a.format(cal.getTime()));
			 String dataFormatada = (a.format(cal.getTime()));
			chamado1.setDateFim(dataFormatada);
			cs.atualizaChamado(chamado1);

		}
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
	 * @throws IOException 
	 */
	@RequestMapping("todos_os_chamados")
	public String todosOsChamados()
	{
		return "listaDeChamados";
	}
	@RequestMapping("lista_chamado")
	public String listarChamados(HttpSession session) throws IOException
	{
		System.out.println("sessao"+cs.selecionaTodosOsChamados());
		session.setAttribute("todosChamados",cs.selecionaTodosOsChamados());
		return "redirect:todos_os_chamados";
	}
	@RequestMapping("chamado_view")
	public String meuChamadoView()
	{
		return "ChamadoView";
	}
	@RequestMapping("pesquisar_chamados")
	public String buscaChamadoChave(String chave, HttpSession session) throws IOException
	{
		session.setAttribute("view", cs.buscaPorChave(chave));
		return "ChamadoView";
	}
	@RequestMapping("chamadoView")
	public String chamadoView( ChamadoView chamado,HttpSession session) throws SQLException, IOException
	{
		System.out.println(chamado.toString());
		System.out.println(cs.chamadoView(chamado));
		session.setAttribute("view", cs.chamadoView(chamado));
		return "redirect:chamado_view";
	}
	
}
