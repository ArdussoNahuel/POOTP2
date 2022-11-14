package Logica;

import java.util.LinkedList;

public class Encargado {
	private int dni;
	private String nombre;
	private String contraseña;
	
	public Encargado(int dni, String nombre, String contraseña) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.contraseña = contraseña;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Encargado [dni=" + dni + ", nombre=" + nombre + ", contraseña=" + contraseña + "]";
	}
	
	
	public void grupos(LinkedList<Pais> lista) {
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
		
		
	}
	
	public void octavos(LinkedList<Pais> lista) {
		
	}
	
	
}
