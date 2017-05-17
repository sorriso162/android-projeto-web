package br.usjt.projeto.semestral.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 
 * @author Bruni
 *
 */
@Entity
public class Chamado {
	@Id
	private int id;
	private int idUsuario;
	private String descricao;
	private String status;
	private String tipo;
	private Date   dateInicio;
	private Date   dateFim;
	
	
	
	
	
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
	public Date getDataInicio() {
		return dateInicio;
	}
	/**
	 * 
	 * @param dataInicio
	 */
	public void setDataInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
	}
	/**
	 * 
	 * @return
	 */
	public Date getDateFim() {
		return dateFim;
	}
	/**
	 * 
	 * @param dataFim
	 */
	
	public void setDateFim(Date dataFim) {
		this.dateFim = dataFim;
	}
	/**
	 * 
	 * @return
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * 
	 * @param idUsuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Override
	public String toString() {
		return "Chamado [id=" + id + ", idUsuario=" + idUsuario + ", descricao=" + descricao + ", status=" + status
				+ ", tipo=" + tipo + ", dataInicio=" + dateInicio + ", dataFim=" + dateFim + "]";
	}
	
	
	
	
	
	
}
