package com.compiquiniela.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.compiquiniela.bean.Jornada;
import com.compiquiniela.bean.Liga;
import com.compiquiniela.bean.Partido;
import com.compiquiniela.bean.Torneo;
import com.compiquiniela.util.Util;

public class ObtieneInformacionDAO extends AccesoJDBCBaseDAO {
	Util formatea = new Util();
	public ArrayList<Liga> getLiga() throws Exception {
		ArrayList<Liga> resultado = new ArrayList<Liga>();
		try{
			SimpleJdbcCall recuperaLiga = new SimpleJdbcCall(dataSource).withProcedureName("comp_spc_liga")
					.returningResultSet("lista", new RowMapper<Liga>() {
						@Override
						public Liga mapRow(ResultSet rs, int rowNum) throws SQLException {
							Liga lista = new Liga();
							lista.setLigaId(rs.getInt("LigaId"));
							lista.setNomCorto(rs.getString("NomCorto"));
							lista.setDescripcion(rs.getString("Descripcion"));
							lista.setPaisId(rs.getString("PaisId"));
							return lista;
						}
					});
			Map<String, Object> m = recuperaLiga.execute();
			resultado = (ArrayList<Liga>) m.get("lista");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return resultado;
		
	}
	
	public ArrayList<Torneo> getTorneo(int ligaIdConsulta) throws Exception {
		ArrayList<Torneo> resultado = new ArrayList<Torneo>();
		try{
			SimpleJdbcCall recuperaTorneo = new SimpleJdbcCall(dataSource).withProcedureName("comp_spc_torneo")
					.returningResultSet("lista", new RowMapper<Torneo>() {
						@Override
						public Torneo mapRow(ResultSet rs, int rowNum) throws SQLException {
							Torneo lista = new Torneo();
							lista.setTorneoId(rs.getInt("TorneoId"));
							lista.setLigaId(rs.getInt("LigaId"));
							lista.setNomCorto(rs.getString("NomCorto"));
							lista.setDescripcion(rs.getString("Descripcion"));
							return lista;
						}
					});
			SqlParameterSource in = new MapSqlParameterSource().addValue("LigaIdConsulta", ligaIdConsulta);
			Map<String, Object> m = recuperaTorneo.execute(in);
			resultado = (ArrayList<Torneo>) m.get("lista");
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		return resultado;
	}
	
	public ArrayList<Jornada> getJornada(int ligaIdConsulta, int torneoIdConsulta) throws Exception {
		ArrayList<Jornada> resultado = new ArrayList<Jornada>();
		try{
			SimpleJdbcCall recuperaJornada = new SimpleJdbcCall(dataSource).withProcedureName("comp_spc_jornada")
					.returningResultSet("lista", new RowMapper<Jornada>() {
						@Override
						public Jornada mapRow(ResultSet rs, int rowNum) throws SQLException {
							Jornada lista = new Jornada();
							lista.setJornadaId(rs.getInt("JornadaId"));
							lista.setTorneoId(rs.getInt("TorneoId"));
							lista.setNomCorto(rs.getString("NomCorto"));
							lista.setDescripcion(rs.getString("Descripcion"));
							lista.setFecInicio(rs.getString("FecInicio"));
							return lista;
						}
					});
			SqlParameterSource in = new MapSqlParameterSource()
				.addValue("LigaIdConsulta", ligaIdConsulta)
				.addValue("TorneoIdConsulta", torneoIdConsulta);
			Map<String, Object> m = recuperaJornada.execute(in);
			resultado = (ArrayList<Jornada>) m.get("lista");
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		
		return resultado;
	}
	
	public ArrayList<Partido> getPartido(int ligaIdConsulta, int torneoIdConsulta, int jornadaIdConsulta) throws Exception {
		ArrayList<Partido> resultado = new ArrayList<Partido>();
		try{
			SimpleJdbcCall recuperaPartido = new SimpleJdbcCall(dataSource).withProcedureName("comp_spc_partido")
					.returningResultSet("lista", new RowMapper<Partido>() {
						@Override
						public Partido mapRow(ResultSet rs, int rowNum)	throws SQLException {
							Partido lista = new Partido();
							lista.setPartidoId(rs.getInt("PartidoId"));
							lista.setJornadaId(rs.getInt("JornadaId"));
							lista.setEquipoLocalId(rs.getString("EquipoLocalId"));
							lista.setEquipoVisitanteId(rs.getString("EquipoVisitanteId"));
							lista.setEstadioId(rs.getString("EstadioId"));
							lista.setFecha(formatea.FormateDate(rs.getString("Fecha")));
							lista.setHora(formatea.FormateHora(rs.getString("Hora")));
							lista.setBandResultado(rs.getInt("BandResultado"));
							lista.setResEquipoLocal(rs.getInt("resEquipoLocal"));
							lista.setResEquipoVisitante(rs.getInt("resEquipoVisitante"));
							return lista;
						}
					});
			SqlParameterSource in = new MapSqlParameterSource()
				.addValue("LigaIdConsulta", ligaIdConsulta)
				.addValue("TorneoIdConsulta", torneoIdConsulta)
				.addValue("JornadaIdConsulta", jornadaIdConsulta);
			Map<String, Object> m = recuperaPartido.execute(in);
			resultado = (ArrayList<Partido>) m.get("lista");
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		return resultado;
	}
}
