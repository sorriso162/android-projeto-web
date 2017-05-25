package br.usjt.projeto.semestral.Model;

import java.sql.Date;

import javax.transaction.Transactional;
@Transactional
public class MeusChamados {
	private int id;
	private int idUsuario;
	private int idSolucionador;
	private String usuario;
	private String descricao;
	private String status;
	private String tipo;
	private String solucionador;
	private String   dateInicio;
	private String   dataFim;
	
	
	
	public int getIdSolucionador() {
		return idSolucionador;
	}
	public void setIdSolucionador(int idSolucionador) {
		this.idSolucionador = idSolucionador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSolucionador() {
		return solucionador;
	}
	public void setSolucionador(String solucionador) {
		this.solucionador = solucionador;
	}
	public String getDateInicio() {
		return dateInicio;
	}
	public void setDateInicio(String dateInicio) {
		this.dateInicio = dateInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	@Override
	public String toString() {
		return "MeusChamados [id=" + id + ", idUsuario=" + idUsuario + ", idSolucionador=" + idSolucionador
				+ ", usuario=" + usuario + ", descricao=" + descricao + ", status=" + status + ", tipo=" + tipo
				+ ", solucionador=" + solucionador + ", dateInicio=" + dateInicio + ", dataFim=" + dataFim + "]";
	}
	


}


