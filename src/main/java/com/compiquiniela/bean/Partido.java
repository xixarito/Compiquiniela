package com.compiquiniela.bean;

public class Partido extends Error {
	private int partidoId;
	private int jornadaId;
	private String equipoLocalId;
	private String equipoVisitanteId;
	private String estadioId;
	private String fecha;
	private String hora;
	private int bandResultado;
	private int resEquipoLocal;
	private int resEquipoVisitante;
	
	public void guardaPartido(String fecha, String equipoLocalId, String equipoVisitanteId,
			String hora, int resEquipoLocal, int resEquipoVisitante){
		this.equipoLocalId = equipoLocalId;     
		this.equipoVisitanteId = equipoVisitanteId;
		this.fecha = fecha;
		this.hora = hora;
		this.resEquipoLocal = resEquipoLocal;
		this.resEquipoVisitante = resEquipoVisitante;
	}
	
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
	public int getBandResultado() {
		return bandResultado;
	}
	public void setBandResultado(int bandResultado) {
		this.bandResultado = bandResultado;
	}
	public int getResEquipoLocal() {
		return resEquipoLocal;
	}
	public void setResEquipoLocal(int resEquipoLocal) {
		this.resEquipoLocal = resEquipoLocal;
	}
	public int getResEquipoVisitante() {
		return resEquipoVisitante;
	}
	public void setResEquipoVisitante(int resEquipoVisitante) {
		this.resEquipoVisitante = resEquipoVisitante;
	}
	
}
