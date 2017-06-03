package br.usjt.projeto.semestral.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Bruni
 *
 */
@Entity
public class Chamado {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario idUsuario;
	@ManyToOne
	@JoinColumn(name="idSolucionador")
	private Solucionador idSolucionador;
	private String descricao;
	private String status;
	private String tipo;
	private String dataInicio;
	private String dataFim;
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public Solucionador getIdSolucionador() {
		return idSolucionador;
	}
	/**
	 * 
	 * @param idSolucionador
	 */
	public void setIdSolucionador(Solucionador idSolucionador) {
		this.idSolucionador = idSolucionador;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * 
	 * @return
	 */
	public String getDataInicio() {
		return dataInicio;
	}
	/**
	 * 
	 * @param dataInicio
	 */
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	/**
	 * 
	 * @return
	 */
	public String getDateFim() {
		return dataFim;
	}
	/**
	 * 
	 * @param dataFim
	 */
	
	public void setDateFim(String dataFim) {
		this.dataFim = dataFim;
	}
	/**
	 * 
	 * @return
	 */
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	/**
	 * 
	 * @param idUsuario
	 */
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Override
	public String toString() {
		return "Chamado [id=" + id + ", idUsuario=" + idUsuario + ", idSolucionador=" + idSolucionador + ", descricao="
				+ descricao + ", status=" + status + ", tipo=" + tipo + ", dataInicio=" + dataInicio + ", dataFim="
				+ dataFim + "]";
	}
	
}