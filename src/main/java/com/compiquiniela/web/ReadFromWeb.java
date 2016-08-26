package com.compiquiniela.web;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.compiquiniela.bean.Partido;
import com.compiquiniela.util.Constantes;
import com.compiquiniela.util.Util;

public class ReadFromWeb {
	
	private ArrayList<Partido> ConsultaWeb (int jornada) throws Exception{
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		String urlConsulta;
		
		urlConsulta = Constantes.URL_BASE + Constantes.TORNEOMEX + Integer.toString(jornada);
		Util.Connect(urlConsulta);
		
		Document doc = Jsoup.connect(urlConsulta).get();
        Elements numFechas = doc.getElementsByClass("tif");
       
		for (int cont = 0; cont < numFechas.size(); cont++) {
			Element fecha = doc.select("div.tif").get(cont);
			Elements news = new Elements();
			Element item = fecha.nextElementSibling();
			while (item != null && !(item.tagName().equals("div") && item.className().equals("tif"))) {
				news.add(item);
				item = item.nextElementSibling();
			}

			for (Element element : news) {
				if (!element.text().equals("")){
					Partido partido = new Partido();
					partido.guardaPartido(genfecha(fecha.text()),
							textLabel(Constantes.ETILOCAL, element),
							textLabel(Constantes.ETIVISITA, element),
							textLabel(Constantes.ETIHORA, element),
							resLocal(textLabel(Constantes.ETIRES, element)),
							resVisitante(textLabel(Constantes.ETIRES, element)));
					partidos.add(partido);
				}
			}
		}

		return partidos;
	}
	
	private String textLabel(String etiqueta, Element element){
		String respuesta;
		respuesta = element.select(etiqueta).text();
		return respuesta.trim();
	}
	
	private int resLocal (String resultado){
		int resLocal;
		if (resultado.equals("---") || resultado.equals("")){
			resLocal = 0;
		} else {
			resultado.indexOf("-");
			resLocal = Integer.parseInt(resultado.substring(0,resultado.indexOf("-")));
		}
		return resLocal;
	}
	
	private int resVisitante (String resultado){
		int resVisitante;
		if (resultado.equals("---") || resultado.equals("")){
			resVisitante = 0;
		} else {
			resultado.indexOf("-");
			resVisitante = Integer.parseInt(resultado.substring(resultado.indexOf("-") + 1,resultado.length()));
		}
		return resVisitante;
	}
	
	private String genfecha (String fecha){
		String fechaFormat;
		fechaFormat = fecha.replaceAll(Constantes.NBSP, "");
		fechaFormat = fechaFormat.replaceAll("de ", "");
		fechaFormat = fechaFormat.substring(4,fechaFormat.length());
		fechaFormat = fechaFormat.replaceAll(" ", "-");
		
		return fechaFormat;
	}
	
	public static void main(String[] args) throws Exception {
		ReadFromWeb read = new ReadFromWeb();
		ArrayList<Partido> consulta = new ArrayList<Partido>();
		Partido uno = new Partido();
		consulta = read.ConsultaWeb(4);
		for (int i = 0; i < consulta.size(); i++) {
			uno = consulta.get(i);
			System.out.println(uno.getEquipoLocalId());
			System.out.println(uno.getEquipoVisitanteId());
			System.out.println(uno.getHora());
			System.out.println(uno.getFecha());
			System.out.println(uno.getResEquipoLocal());
			System.out.println(uno.getResEquipoVisitante());
			System.out.println("***********************************");
        }
	}
	
}
