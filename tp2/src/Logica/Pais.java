package Logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Pais {

	private int id;
	private String nombre;
	private double calidad;
	private int goles;
	private String grupo;
	private boolean estado;
	private LinkedList<Partido> partidos;
	
	public Pais(int id, String nombre, double calidad, int goles, String grupo, boolean estado, LinkedList<Partido> partidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calidad = calidad;
		this.goles = goles;
		this.grupo = grupo;
		this.estado = estado;
		this.partidos = partidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCalidad() {
		return calidad;
	}

	public void setCalidad(double calidad) {
		this.calidad = calidad;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}

	@Override
	public String toString() {
		return "\nPais [id=" + id + ", nombre=" + nombre + ", calidad=" + calidad + ", goles=" + goles + ", grupo="
				+ grupo + ", estado=" + estado + "]";
	}
	
	public boolean jugarPartido(Pais adversario) {
		int goles1=0;
		int goles2=0;
			for (int i=1; i< Math.round(this.getCalidad()*5-1);i++) {
				goles1+=(int)Math.round(Math.random()*this.getCalidad());
			}
			for (int i=1; i< Math.round(adversario.getCalidad()*5-1);i++) {
				goles2+=(int)Math.round(Math.random()*adversario.getCalidad());
			}
			this.setGoles(this.getGoles()+goles1);
			adversario.setGoles(adversario.getGoles()+goles2);
			if (goles1>goles2) {
				this.partidos.add(new Partido(this.partidos.size()+1,adversario,"Victoria",goles1));
				adversario.partidos.add(new Partido(adversario.partidos.size()+1,this,"Derrota",goles2));
				adversario.setEstado(false);
				//System.out.println("Victoria "+goles1+" a "+goles2);
				return false;
			} else if (goles1<goles2) {
				this.partidos.add(new Partido(this.partidos.size()+1,adversario,"Derrota",goles1));
				this.setEstado(false);
				adversario.partidos.add(new Partido(adversario.partidos.size()+1,this,"Victoria",goles2));
				//System.out.println("Derrota "+goles1+" a "+goles2);
				return false;
			} else {
				this.partidos.add(new Partido(this.partidos.size()+1,adversario,"Empate",goles1));
				adversario.partidos.add(new Partido(adversario.partidos.size()+1,this,"Empate",goles2));
				//System.out.println("Empate "+goles1+" a "+goles2);
				return true;
			}
	}
	
	public Pais penales(Pais adversario) {
		int goles1=0;
		int goles2=0;
		double aux;
		for (int i=0; i< 5;i++) {
			aux=Math.random()*2;
			//aux=Double.parseDouble(JOptionPane.showInputDialog("Ingresar tiro equipo "+this.getNombre()));
			if (aux<=this.getCalidad()) {
				goles1++;
			}
		}
		for (int i=0; i< 5;i++) {
			aux=Math.random()*2;
			//aux=Double.parseDouble(JOptionPane.showInputDialog("Ingresar tiro equipo "+adversario.getNombre()));
			if (aux<=adversario.getCalidad()) {
				goles2++;
			}
		}
		if (goles1>goles2) {
			this.getPartidos().getLast().setResultado("Victoria por penales "+goles1+" a "+goles2);
			adversario.getPartidos().getLast().setResultado("Derrota por penales "+goles2+" a "+goles1);
			adversario.setEstado(false);
			return this;
		} else if (goles1<goles2) {
			this.getPartidos().getLast().setResultado("Derrota por penales "+goles1+" a "+goles2);
			this.setEstado(false);
			adversario.getPartidos().getLast().setResultado("Victoria por penales "+goles2+" a "+goles1);
			return adversario;
		} else {
			System.out.println("penales again");
			return this.penales(adversario);
		}
	}
	
	
}
