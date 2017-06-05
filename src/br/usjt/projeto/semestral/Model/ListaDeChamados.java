package br.usjt.projeto.semestral.Model;

import javax.transaction.Transactional;
@Transactional
public class ListaDeChamados {
	
	
	private int id;
	private String usuario;
	private String descricao;
	private String status;
	private String tipo;
	private String solucionador;
	private String   dateInicio;
	private String   dataFim;
	private String nomeUsuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "ListaDeChamados [id=" + id + ", usuario=" + usuario + ", descricao=" + descricao + ", status=" + status
				+ ", tipo=" + tipo + ", solucionador=" + solucionador + ", dateInicio=" + dateInicio + ", dataFim="
				+ dataFim + "]";
	}
	
	

}
