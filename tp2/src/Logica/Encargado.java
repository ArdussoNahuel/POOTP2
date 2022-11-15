package Logica;

import java.util.LinkedList;

public class Encargado {
	private int dni;
	private String nombre;
	private String contrasena;
	
	public Encargado(int dni, String nombre, String contrasena) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Encargado [dni=" + dni + ", nombre=" + nombre + ", contrasena=" + contrasena + "]";
	}
	
	
	
	/*public void jugarFase(LinkedList<Pais> lista, Fase fase) {
		int i;
		int  []puntos= new int[fase.getPaises().size()+1];
		boolean fingrupo;
		for (Pais pais : lista) {
			System.out.println("pais "+pais.getNombre());
			i=1;
			fingrupo=true;
			System.out.println(lista.indexOf(pais));
			while (fingrupo &&lista.indexOf(pais)<lista.size()-1 && pais.getGrupo()==lista.get(lista.indexOf(pais)+i).getGrupo()) {
				System.out.println("contra: "+lista.get(lista.indexOf(pais)+i).getNombre());
				pais.jugarPartido(lista.get(lista.indexOf(pais)+i));
				i++;
				if ((lista.indexOf(pais)+i)>lista.size()-1) {
					fingrupo=false;
				}
			}
			puntos[lista.indexOf(pais)]=0;
			for (Partido partido : pais.getPartidos()) {
				if (partido.getResultado().equals("Victoria")) {
					puntos[lista.indexOf(pais)]+=3;
				} else if (partido.getResultado().equals("Empate")) {
					puntos[lista.indexOf(pais)]+=1;
				}
			}
			fases.get(0).getPaises().add(pais);
		}
		puntos[32]=-1;
		int pri;
		int seg;
		for (i=0;i<32;i+=4) {
			pri=32;
			seg=32;
			for (int k=i;k<i+4;k++) {
				if (puntos[k]>puntos[pri]) {
					seg=pri;
					pri=k;
				} else if (puntos[k]==puntos[pri]) {
					//penales prim puesto
				} else if (puntos[k]>puntos[seg]) {
					seg=k;
				} else if (puntos[k]==puntos[seg]) {
					//penales seg puesto
				}
			}
			fases.get(1).getPaises().add(lista.get(pri));
			fases.get(1).getPaises().add(lista.get(seg));
		}
	}*/
	
	public void grupos(LinkedList<Pais> lista, LinkedList<Fase> fases) {
		int i;
		int  []puntos= new int[33];
		boolean fingrupo;
		for (Pais pais : lista) {
			System.out.println("pais "+pais.getNombre());
			i=1;
			fingrupo=true;
			System.out.println(lista.indexOf(pais));
			while (fingrupo &&lista.indexOf(pais)<lista.size()-1 && pais.getGrupo()==lista.get(lista.indexOf(pais)+i).getGrupo()) {
				System.out.println("contra: "+lista.get(lista.indexOf(pais)+i).getNombre());
				pais.jugarPartido(lista.get(lista.indexOf(pais)+i));
				i++;
				if ((lista.indexOf(pais)+i)>lista.size()-1) {
					fingrupo=false;
				}
			}
			puntos[lista.indexOf(pais)]=0;
			for (Partido partido : pais.getPartidos()) {
				if (partido.getResultado().equals("Victoria")) {
					puntos[lista.indexOf(pais)]+=3;
				} else if (partido.getResultado().equals("Empate")) {
					puntos[lista.indexOf(pais)]+=1;
				}
			}
			fases.get(0).getPaises().add(pais);
		}
		puntos[32]=-1;
		int pri;
		int seg;
		for (i=0;i<32;i+=4) {
			pri=32;
			seg=32;
			for (int k=i;k<i+4;k++) {
				if (puntos[k]>puntos[pri]) {
					seg=pri;
					pri=k;
				} else if (puntos[k]==puntos[pri]) {
					//penales prim puesto
				} else if (puntos[k]>puntos[seg]) {
					seg=k;
				} else if (puntos[k]==puntos[seg]) {
					//penales seg puesto
				}
			}
			fases.get(1).getPaises().add(lista.get(pri));
			fases.get(1).getPaises().add(lista.get(seg));
		}
		
	}
	
	public void octavos(LinkedList<Pais> lista) {
		//for ()
	}
	
	
}
