package br.usjt.projeto.semestral.Model;

import java.sql.Date;

import javax.transaction.Transactional;
@Transactional
public class ChamadoView {
	 private int id;
	 private String descricao;
	 private Date dataFim;
	 private Date dateInicio;
	 private String status;
	 private String tipo;
	 private String nomeSolucionador;
	 private String nomeUsuario;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Date getDateInicio() {
		return dateInicio;
	}
	public void setDateInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
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
	public String getNomeSolucionador() {
		return nomeSolucionador;
	}
	public void setNomeSolucionador(String nomeSolucionador) {
		this.nomeSolucionador = nomeSolucionador;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	@Override
	public String toString() {
		return "ChamadoView [id=" + id + ", descricao=" + descricao + ", dataFim=" + dataFim + ", dateInicio="
				+ dateInicio + ", status=" + status + ", tipo=" + tipo + ", nomeSolucionador=" + nomeSolucionador
				+ ", nomeUsuario=" + nomeUsuario + "]";
	}
	 
	 
}
