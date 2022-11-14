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
	
	
	public LinkedList<Pais> grupos(LinkedList<Pais> lista) {
		LinkedList<Pais> octavos = new LinkedList<Pais>();
		int i=1;
		int puntos[]= {0};
		boolean fingrupo;
		for (Pais pais : lista) {
			System.out.println("pais "+pais.getNombre());
			i=1;
			fingrupo=true;
			System.out.println(lista.indexOf(pais));
			while (fingrupo &&lista.indexOf(pais)<31 && pais.getGrupo()==lista.get(lista.indexOf(pais)+i).getGrupo()) {
				System.out.println("contra: "+lista.get(lista.indexOf(pais)+i).getNombre());
				pais.jugarPartido(lista.get(lista.indexOf(pais)+i));
				i++;
				if ((lista.indexOf(pais)+i)>31) {
					fingrupo=false;
				}
			}
			for (Partido partido : pais.getPartidos()) {
				if (partido.getResultado().equals("Victoria")) {
					puntos[lista.indexOf(pais)]+=3;
				} else if (partido.getResultado().equals("Empate")) {
					puntos[lista.indexOf(pais)]+=1;
				}
			}
		}
		int pri;
		int seg;
		for (i=0;i<32;i+=4) {
			pri=i;
			seg=i;
			for (int k=i;k<4;k++) {
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
			octavos.add(lista.get(pri));
			octavos.add(lista.get(seg));
		}
		
		for (i=0;i<32;i+=4) {
			if (puntos[i]>=puntos[i+1]) {
				if (puntos[i+1]>puntos[i+2]) {
					octavos.add(lista.get(i));
					octavos.add(lista.get(i+1));
				} else if (puntos[i+1]==puntos[i+2]) {
					/*cambiar partido por penal
					lista.get(i+1).jugarPartido(lista.get(i+2));
					if (lista.get(i+1).getPartidos().getLast().getResultado().equals("Victoria")) {
						octavos.add(lista.get(i));
						octavos.add(lista.get(i+1));
					} else if (lista.get(i+1).getPartidos().getLast().getResultado().equals("Derrota")) {
						octavos.add(lista.get(i));
						octavos.add(lista.get(i+2));
					} else {
						octavos.add(lista.get(i));
						octavos.add(lista.get(i+(int)(Math.random()+1)));
					}*/
				} else {
					if (puntos[i+2]>puntos[i+3])
					octavos.add(lista.get(i));
					octavos.add(lista.get(i+2));
				}
			} else if (puntos[i+1]==puntos[i+2]) {
				if (puntos[i+2]==puntos[i+3]) {
					//penales
				} else {
					octavos.add(lista.get(i));
					octavos.add(lista.get(i+2));
				}
			}
		}
		
		return octavos;
	}
	
	public void octavos(LinkedList<Pais> lista) {
		//for ()
	}
	
	
}
