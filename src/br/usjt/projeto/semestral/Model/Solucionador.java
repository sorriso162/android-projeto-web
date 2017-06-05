package br.usjt.projeto.semestral.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Solucionador {
	@Id
	@Column(name="idSolucionador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolucionador;
	private String nome;
	private String cpf;
	private String tipo;
	private String senha;
	
	/**
	 * 
	 * @return
	 */
	public Solucionador(){}
	public Solucionador(String idSolucionador)
	{
		this.idSolucionador = Integer.parseInt(idSolucionador);
	}
	public int getId() 
	{
		return idSolucionador;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) 
	{
		this.idSolucionador = id;
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
		return "Solucionador [id=" + idSolucionador + ", nome=" + nome + ", cpf=" + cpf + ", tipo=" + tipo + "]";
	}
	
}
