package com.compiquiniela.bean;

public class Torneo {
	private int torneoId;
	private int ligaId;
	private String nomCorto;
	private String descripcion;
	
	public int getTorneoId() {
		return torneoId;
	}
	public void setTorneoId(int torneoId) {
		this.torneoId = torneoId;
	}
	public int getLigaId() {
		return ligaId;
	}
	public void setLigaId(int ligaId) {
		this.ligaId = ligaId;
	}
	public String getNomCorto() {
		return nomCorto;
	}
	public void setNomCorto(String nomCorto) {
		this.nomCorto = nomCorto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
