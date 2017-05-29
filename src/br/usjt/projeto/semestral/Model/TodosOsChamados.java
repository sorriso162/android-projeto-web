package br.usjt.projeto.semestral.Model;

import javax.transaction.Transactional;

@Transactional
public class TodosOsChamados {
	private int id;
	private String nomeUsuario;
	private String descricao;
	private String status;
	private String tipo;
	private String nomeSolucionador;
	private String dateInicio;
	private String dataFim;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
	public String getNomeSolucionador() {
		return nomeSolucionador;
	}
	public void setNomeSolucionador(String nomeSolucionador) {
		this.nomeSolucionador = nomeSolucionador;
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
		return "TodosOsChamados [id=" + id + ", nomeUsuario=" + nomeUsuario + ", descricao=" + descricao + ", status="
				+ status + ", tipo=" + tipo + ", nomeSolucionador=" + nomeSolucionador + ", dateInicio=" + dateInicio
				+ ", dataFim=" + dataFim + "]";
	}
	
	
}
