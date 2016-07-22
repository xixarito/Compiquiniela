package com.compiquiniela.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.compiquiniela.bean.Liga;

public class ObtieneInformacionDAO extends AccesoJDBCBaseDAO {
	
	public ArrayList<Liga> getLiga(){
		SimpleJdbcCall recuperaJoranada = new SimpleJdbcCall(dataSource).withProcedureName("comp_sp_jornadas")
				.returningResultSet("lista", new RowMapper<Liga>() {
					@Override
					public Liga mapRow(ResultSet rs, int rowNum)	throws SQLException {
						Liga lista = new Liga();
						lista.setLigaId(rs.getInt("LigaId"));
						lista.setNomCorto(rs.getString("NomCorto"));
						lista.setDescripcion(rs.getString("Descripcion"));
						lista.setPaisId(rs.getString("PaisId"));
						return lista;
					}
				});
		Map<String, Object> m = recuperaJoranada.execute();
		return (ArrayList<Liga>) m;
	}
	
	
	

}
