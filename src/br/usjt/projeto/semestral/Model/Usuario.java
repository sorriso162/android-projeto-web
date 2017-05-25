package br.usjt.projeto.semestral.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author Bruni
 *
 */
@Entity
public class Usuario 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nome;
	private String cpf;
	private String tipo;
	private String senha;
	
	/**
	 * 
	 * @return
	 */
	public int getId() 
	{
		return idUsuario;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) 
	{
		this.idUsuario = id;
	}
	/**
	 * 
	 * @return
	 */
	public String getNome() 
	{
		return nome;
	}
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	/**
	 * 
	 * @return
	 */
	public String getCpf() 
	{
		return cpf;
	}
	/**
	 * 
	 * @param cpf
	 */
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	/**
	 * 
	 * @return
	 */
	public String getTipo() 
	{
		return tipo;
	}
	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	/**
	 * 
	 * @return
	 */
	public String getSenha()
	{
		return senha;
	}
	/**
	 * 
	 * @param senha
	 */
	public void setSenha(String senha)
	{
		this.senha= senha;
	}
	
	@Override
	public String toString() 
	{
		return "Usuario [id=" + idUsuario + ", nome=" + nome + ", , senha=" + senha + ",cpf=" + cpf + ", tipo=" + tipo + "]";
	}
	
	
	
	
}
