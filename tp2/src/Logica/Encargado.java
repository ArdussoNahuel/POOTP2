package Logica;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

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
	
	public void grupos(LinkedList<Fase> fases) {
		int i;
		int  []puntos= new int[33];
		int []primeros=new int[8];
		int []segundos=new int[8];
		boolean fingrupo;
		for (Pais pais : fases.get(0).getPaises()) {
			//JOptionPane.showMessageDialog(null, fases.get(1));
			//System.out.println("pais "+pais.getNombre());
			i=1;
			fingrupo=true;
			//System.out.println(fases.get(0).getPaises().indexOf(pais));
			while (fingrupo &&fases.get(0).getPaises().indexOf(pais)<fases.get(0).getPaises().size()-1 && pais.getGrupo()==fases.get(0).getPaises().get(fases.get(0).getPaises().indexOf(pais)+i).getGrupo()) {
				//System.out.println("contra: "+fases.get(0).getPaises().get(fases.get(0).getPaises().indexOf(pais)+i).getNombre());
				pais.jugarPartido(fases.get(0).getPaises().get(fases.get(0).getPaises().indexOf(pais)+i));
				i++;
				if ((fases.get(0).getPaises().indexOf(pais)+i)>fases.get(0).getPaises().size()-1) {
					fingrupo=false;
				}
			}
			puntos[fases.get(0).getPaises().indexOf(pais)]=0;
			for (Partido partido : pais.getPartidos()) {
				if (partido.getResultado().equals("Victoria")) {
					puntos[fases.get(0).getPaises().indexOf(pais)]+=3;
				} else if (partido.getResultado().equals("Empate")) {
					puntos[fases.get(0).getPaises().indexOf(pais)]+=1;
				}
			}
		}
		puntos[32]=-1;
		int pri;
		int seg;
		for (i=0;i<32;i+=4) {
			pri=32;
			seg=32;
			for (int k=i;k<i+4;k++) {
				fases.get(0).getPaises().get(k).setEstado(false);
				if (puntos[k]>puntos[pri]) {
					seg=pri;
					pri=k;
				} else if (puntos[k]==puntos[pri]) {
					if (fases.get(0).getPaises().get(k).getGoles()>fases.get(0).getPaises().get(pri).getGoles()) {
						seg=pri;
						pri=k;
					} else {
						seg=k;
					}
				} else if (puntos[k]>puntos[seg]) {
					seg=k;
				} else if (puntos[k]==puntos[seg]) {
					if (fases.get(0).getPaises().get(k).getGoles()>fases.get(0).getPaises().get(seg).getGoles()) {
						seg=k;
					}
				}
			}
			primeros[i/4]=pri;
			segundos[i/4]=seg;
			fases.get(0).getPaises().get(pri).setEstado(true);
			fases.get(0).getPaises().get(seg).setEstado(true);
			//fases.get(1).getPaises().add(fases.get(0).getPaises().get(pri));
			//fases.get(1).getPaises().add(fases.get(0).getPaises().get(seg));
		}
		for (i=0;i<8;i+=2) {
				fases.get(1).getPaises().add(fases.get(0).getPaises().get(primeros[i]));
				fases.get(1).getPaises().add(fases.get(0).getPaises().get(segundos[i+1]));
		}
		for (i=0;i<8;i+=2) {
			fases.get(1).getPaises().add(fases.get(0).getPaises().get(segundos[i]));
			fases.get(1).getPaises().add(fases.get(0).getPaises().get(primeros[i+1]));
	}
		
		
	}
	
	public void eliminatoria(LinkedList<Fase> fases, int fase) {
		for (int i=0;i<fases.get(fase).getPaises().size(); i+=2) {
			if(fases.get(fase).getPaises().get(i).jugarPartido(fases.get(fase).getPaises().get(i+1))) {
				fases.get(fase).getPaises().get(i).penales(fases.get(fase).getPaises().get(i+1));
			}
			if (fases.get(fase).getPaises().get(i).isEstado()) {
				fases.get(fase+1).getPaises().add(fases.get(fase).getPaises().get(i));;
			}
			if (fases.get(fase).getPaises().get(i+1).isEstado()) {
				fases.get(fase+1).getPaises().add(fases.get(fase).getPaises().get(i+1));;
			}
			
		}
	}
	
	
}
