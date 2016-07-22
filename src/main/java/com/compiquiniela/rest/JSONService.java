package com.compiquiniela.rest;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.compiquiniela.bean.Liga;
import com.compiquiniela.dao.ObtieneInformacionDAO;
	
@Path("/service")
public class JSONService {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ObtieneInformacionDAO info = (ObtieneInformacionDAO) context.getBean("obtieneInformacionDAO");
	
	@GET
	@Path("/liga/{name}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Liga> getLiga(@PathParam("name") String name, @PathParam("id") int id) {
		ArrayList<Liga> resultado = new ArrayList<Liga>();
		
		Liga liga = new Liga();
		liga.setLigaId(id);
		liga.setNomCorto(name);
		liga.setDescripcion("Liga de Futbol Profesional de M�xico");
		liga.setPaisId("Mexico");
		
		Liga liga2 = new Liga();
		liga2.setLigaId(2);
		liga2.setNomCorto("Liga BBVA");
		liga2.setDescripcion("Liga de Futbol Profesional de Espa�a");
		liga2.setPaisId("Espa�a");
		
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