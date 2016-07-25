package com.compiquiniela.bean;

public class Partido extends Error {
	private int partidoId;
	private int jornadaId;
	private String equipoLocalId;
	private String equipoVisitanteId;
	private String estadioId;
	private String fecha;
	private String hora;
	
	public int getPartidoId() {
		return partidoId;
	}
	public void setPartidoId(int partidoId) {
		this.partidoId = partidoId;
	}
	public int getJornadaId() {
		return jornadaId;
	}
	public void setJornadaId(int jornadaId) {
		this.jornadaId = jornadaId;
	}
	public String getEquipoLocalId() {
		return equipoLocalId;
	}
	public void setEquipoLocalId(String equipoLocalId) {
		this.equipoLocalId = equipoLocalId;
	}
	public String getEquipoVisitanteId() {
		return equipoVisitanteId;
	}
	public void setEquipoVisitanteId(String equipoVisitanteId) {
		this.equipoVisitanteId = equipoVisitanteId;
	}
	public String getEstadioId() {
		return estadioId;
	}
	public void setEstadioId(String estadioId) {
		this.estadioId = estadioId;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
