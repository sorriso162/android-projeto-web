package br.usjt.projeto.semestral.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Solucionador {
	@Id
	private int id;
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
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) 
	{
		this.id = id;
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
		return "Administrador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", tipo=" + tipo + "]";
	}
	
}
