package com.compiquiniela.bean;

import java.util.ArrayList;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Principal{
	private ArrayList<Liga> ligas = new ArrayList<Liga>();
	private ArrayList<Torneo> torneos = new ArrayList<Torneo>();
	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	private ArrayList<Jornada> jornadas = new ArrayList<Jornada>();
	
	public Principal(){
		this.ligas = null;
		this.torneos = null;
		this.partidos = null;
		this.jornadas = null;
	}
	
	public ArrayList<Liga> getLigas() {
		return ligas;
	}
	public void setLigas(ArrayList<Liga> ligas) {
		this.ligas = ligas;
	}
	public ArrayList<Torneo> getTorneos() {
		return torneos;
	}
	public void setTorneos(ArrayList<Torneo> torneos) {
		this.torneos = torneos;
	}
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}
	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}
	public ArrayList<Jornada> getJornadas() {
		return jornadas;
	}
	public void setJornadas(ArrayList<Jornada> jornadas) {
		this.jornadas = jornadas;
	}
	
}
