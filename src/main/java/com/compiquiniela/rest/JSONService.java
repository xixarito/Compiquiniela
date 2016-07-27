package com.compiquiniela.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.compiquiniela.bean.Jornada;
import com.compiquiniela.bean.Liga;
import com.compiquiniela.bean.Partido;
import com.compiquiniela.bean.Torneo;
import com.compiquiniela.dao.ObtieneInformacionDAO;
	
@Path("/service")
public class JSONService {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ObtieneInformacionDAO info = (ObtieneInformacionDAO) context.getBean("obtieneInformacionDAO");
	
	@GET
	@Path("/liga")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Liga> getLiga() {
		ArrayList<Liga> resultado = new ArrayList<Liga>();
		
		try {
			resultado = info.getLiga();
		} catch (Exception e) {
			Liga error = new Liga();
			error.setError("Error en el servicio");
			resultado.add(error);
		}

		return resultado;
	}
	
	@GET
	@Path("/torneo/{ligaIdConsulta}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Torneo> getTorneo(@PathParam("ligaIdConsulta") String ligaIdConsulta) {
		ArrayList<Torneo> resultado = new ArrayList<Torneo>();
		
		try {
			resultado = info.getTorneo(Integer.parseInt(ligaIdConsulta.trim()));
		} catch (Exception e) {
			Torneo error = new Torneo();
			error.setError("Error en el servicio");
			resultado.add(error);
		}

		return resultado;
	}
	
	@GET
	@Path("/jornada/{torneoIdConsulta}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Jornada> getJornada(@PathParam("torneoIdConsulta") String torneoIdConsulta) {
		ArrayList<Jornada> resultado = new ArrayList<Jornada>();
		
		try {
			resultado = info.getJornada(Integer.parseInt(torneoIdConsulta.trim()));
		} catch (Exception e) {
			Jornada error = new Jornada();
			error.setError("Error en el servicio");
			resultado.add(error);
		}

		return resultado;
	}
	
	@GET
	@Path("/partido/{jornadaIdConsulta}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Partido> getPartido(@PathParam("jornadaIdConsulta") String jornadaIdConsulta) {
		ArrayList<Partido> resultado = new ArrayList<Partido>();
		
		try {
			resultado = info.getPartido(Integer.parseInt(jornadaIdConsulta.trim()));
		} catch (Exception e) {
			Partido error = new Partido();
			error.setError("Error en el servicio");
			resultado.add(error);
		}

		return resultado;
	}


}