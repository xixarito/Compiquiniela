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
import com.compiquiniela.bean.Principal;
import com.compiquiniela.bean.Partido;
import com.compiquiniela.bean.Torneo;
import com.compiquiniela.dao.ObtieneInformacionDAO;
	
@Path("/service")
public class JSONService {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ObtieneInformacionDAO info = (ObtieneInformacionDAO) context.getBean("obtieneInformacionDAO");
	Principal respuesta = new Principal();
	
	@GET
	@Path("/liga")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Principal getLiga() {
		ArrayList<Liga> resultado = new ArrayList<Liga>();

		try {
			resultado = info.getLiga();
		} catch (Exception e) {
			Liga error = new Liga();
			error.setError("Error en el servicio");
			resultado.add(error);
		}
		
		respuesta.setLigas(resultado);
		
		return respuesta;
	}
	
	@GET
	@Path("/torneo/{ligaIdConsulta}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Principal getTorneo(@PathParam("ligaIdConsulta") String ligaIdConsulta) {
		ArrayList<Torneo> resultado = new ArrayList<Torneo>();
		
		try {
			resultado = info.getTorneo(Integer.parseInt(ligaIdConsulta.trim()));
		} catch (Exception e) {
			Torneo error = new Torneo();
			error.setError("Error en el servicio");
			resultado.add(error);
		}

		respuesta.setTorneos(resultado);
		
		return respuesta;
	}
	
	@GET
	@Path("/jornada/{ligaIdConsulta}/{torneoIdConsulta}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Principal getJornada(@PathParam("ligaIdConsulta") String ligaIdConsulta,
			@PathParam("torneoIdConsulta") String torneoIdConsulta) {
		ArrayList<Jornada> resultado = new ArrayList<Jornada>();
		
		try {
			resultado = info.getJornada(Integer.parseInt(ligaIdConsulta.trim()),
					Integer.parseInt(torneoIdConsulta.trim()));
		} catch (Exception e) {
			Jornada error = new Jornada();
			error.setError("Error en el servicio");
			resultado.add(error);
		}

		respuesta.setJornadas(resultado);
		
		return respuesta;

	}
	
	@GET
	@Path("/partido/{ligaIdConsulta}/{torneoIdConsulta}/{jornadaIdConsulta}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Principal getPartido(@PathParam("ligaIdConsulta") String ligaIdConsulta,
			@PathParam("torneoIdConsulta") String torneoIdConsulta,
			@PathParam("jornadaIdConsulta") String jornadaIdConsulta) {
		ArrayList<Partido> resultado = new ArrayList<Partido>();
		
		try {
			resultado = info.getPartido(Integer.parseInt(ligaIdConsulta.trim()),
					Integer.parseInt(torneoIdConsulta.trim()),
					Integer.parseInt(jornadaIdConsulta.trim()));
		} catch (Exception e) {
			Partido error = new Partido();
			error.setError("Error en el servicio");
			resultado.add(error);
		}

		respuesta.setPartidos(resultado);
		
		return respuesta;
	}


}