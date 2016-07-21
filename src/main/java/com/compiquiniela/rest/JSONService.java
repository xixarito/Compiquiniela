package com.compiquiniela.rest;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.compiquiniela.bean.Liga;
import com.compiquiniela.dao.ObtieneInformacionDAO;
	
@Path("/service")
public class JSONService {
	ObtieneInformacionDAO info = new ObtieneInformacionDAO();
	@GET
	@Path("/liga/{name}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Liga> getLiga(@PathParam("name") String name, @PathParam("id") int id) {
		ArrayList<Liga> resultado = new ArrayList<Liga>();
		
		Liga liga = new Liga();
		liga.setLigaId(id);
		liga.setNomCorto(name);
		liga.setDescripcion("Liga de Futbol Profesional de México");
		liga.setPaisId("Mexico");
		
		Liga liga2 = new Liga();
		liga2.setLigaId(2);
		liga2.setNomCorto("Liga BBVA");
		liga2.setDescripcion("Liga de Futbol Profesional de España");
		liga2.setPaisId("España");
		
		resultado.add(liga);
		resultado.add(liga2);

		return resultado;

	}
	
	@GET
	@Path("/liga")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Liga> getLiga() {
		ArrayList<Liga> resultado = new ArrayList<Liga>();
		
		resultado = info.getLiga();

		return resultado;

	}
}