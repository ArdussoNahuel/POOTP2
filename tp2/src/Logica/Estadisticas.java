package Logica;

import java.util.LinkedList;

public class Estadisticas {

	private String masgoles;
	private String masvictorias;
	private String menosgoles;
	private String menosvictorias;
	private String masempates;
	
	public Estadisticas(String masgoles, String masvictorias, String menosgoles, String menosvictorias, String masempates) {
		super();
		this.masgoles = masgoles;
		this.masvictorias = masvictorias;
		this.menosgoles = menosgoles;
		this.menosvictorias = menosvictorias;
		this.masempates = masempates;
	}

	public String getMasgoles() {
		return masgoles;
	}

	public void setMasgoles(String masgoles) {
		this.masgoles = masgoles;
	}

	public String getMasvictorias() {
		return masvictorias;
	}

	public void setMasvictorias(String masvictorias) {
		this.masvictorias = masvictorias;
	}

	public String getMenosgoles() {
		return menosgoles;
	}

	public void setMenosgoles(String menosgoles) {
		this.menosgoles = menosgoles;
	}

	public String getMenosvictorias() {
		return menosvictorias;
	}

	public void setMenosvictorias(String menosvictorias) {
		this.menosvictorias = menosvictorias;
	}

	public String getMasempates() {
		return masempates;
	}

	public void setMasempates(String masempates) {
		this.masempates = masempates;
	}

	@Override
	public String toString() {
		return "Estadisticas [masgoles=" + masgoles + ", masvictorias=" + masvictorias + ", menosgoles=" + menosgoles
				+ ", menosvictorias=" + menosvictorias + ", masempates=" + masempates + "]";
	}
	
	
	
	public String estadisticas(LinkedList<Pais> paises) {
		int vic=0;
		int der=0;
		int emp=0;
		int masgoles=0;;
		int menosgoles=0;;
		for (Pais pais : paises) {
			if (paises.indexOf(pais)==0) {
				for (Partido partidos : pais.getPartidos()) {
					if (partidos.getResultado().contains("Victoria")) {
						vic++;
					} else if (partidos.getResultado().contains("Derrota")) {
						der++;
					} else {
						emp++;
					}
				}
				masgoles=pais.getGoles();
				menosgoles=pais.getGoles();
				this.masgoles=pais.getNombre()+" con "+masgoles;
				this.masvictorias=pais.getNombre()+" con "+vic;
				this.menosgoles=pais.getNombre()+" con "+menosgoles;
				this.menosvictorias=pais.getNombre()+" con "+der;
				this.masempates=pais.getNombre()+" con "+emp;
			} else {
				int victorias=0;
				int derrotas=0;
				int empates=0;
				for (Partido partidos : pais.getPartidos()) {
					if (partidos.getResultado().contains("Victoria")) {
						victorias++;
					} else if (partidos.getResultado().contains("Derrota")) {
						derrotas++;
					} else {
						empates++;
					}
				}
				if (pais.getGoles()> masgoles) {
					masgoles=pais.getGoles();
					this.masgoles=pais.getNombre()+" con "+masgoles;
				}
				if (pais.getGoles()< menosgoles) {
					menosgoles=pais.getGoles();
					this.menosgoles=pais.getNombre()+" con "+menosgoles;
				}
				if (victorias>vic) {
					vic=victorias;
					this.masvictorias=pais.getNombre()+" con "+vic;
				}
				if (derrotas>der) {
					der=derrotas;
					this.menosvictorias=pais.getNombre()+" con "+der;
				}
				if (empates>emp) {
					emp=empates;
					this.masempates=pais.getNombre()+" con "+emp;
				}
			}
		}
		return "Selección con más goles: "+this.masgoles+"\nSelección con menos goles: "+this.menosgoles+"\nSelección con más victorias: "+this.masvictorias+"\nSelección con más derrotas:"+this.menosvictorias+"\nSelección con más empates: "+this.masempates;
		
	}
	
}
