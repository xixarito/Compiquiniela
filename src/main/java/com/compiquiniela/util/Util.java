package com.compiquiniela.util;

import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util {	
	Locale locale = new Locale("es","MX");
	public String FormateDate(String fecha){
		String fecFormat;
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
		try {
			date = dt.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        SimpleDateFormat dt1 = new SimpleDateFormat("EEE, d MMM",locale);
        
        fecFormat = dt1.format(date);
        return fecFormat;
	}
	
	public String FormateHora(String hora){
		String horaFormat;
		SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
		try {
			date = dt.parse(hora);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm");
        
        horaFormat = dt1.format(date);
        return horaFormat;
	}
	
	public static void Connect(String webURL) throws IOException {
    	URL server = new URL(webURL);
    	Properties systemProperties = System.getProperties();
    	systemProperties.setProperty("http.proxyHost",Constantes.PROXY);
    	systemProperties.setProperty("http.proxyPort",Constantes.PORT);
    	systemProperties.setProperty("User-Agent", Constantes.USRAGENT);
    	HttpURLConnection connection = (HttpURLConnection)server.openConnection();
    	connection.connect();
	}
	
	public static String tipoSeleccion(String tipoConsulta){
		tipoConsulta = tipoConsulta.trim();
		if (tipoConsulta.equals("local")) {
			return Constantes.ETILOCAL;
		} else if (tipoConsulta.equals("visitante")) {
			return Constantes.ETIVISITA;
		} else if (tipoConsulta.equals("resultado")) {
			return Constantes.ETIRES;
		} else if (tipoConsulta.equals("hora")) {
			return Constantes.ETIHORA;
		} else if (tipoConsulta.equals("dia")) {
			return Constantes.ETIDIA;
		} else {
			return null;
		}		
	}
	
	
}
