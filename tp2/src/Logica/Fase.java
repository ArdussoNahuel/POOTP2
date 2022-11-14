package Logica;

import java.util.LinkedList;

public class Fase {

	private int nro;
	private String descr;
	private LinkedList<Pais> paises;
	
	public Fase(int nro, String descr, LinkedList<Pais> paises) {
		super();
		this.nro = nro;
		this.descr = descr;
		this.paises = paises;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public LinkedList<Pais> getPaises() {
		return paises;
	}
	public void setPaises(LinkedList<Pais> paises) {
		this.paises = paises;
	}
	@Override
	public String toString() {
		return "Fase [nro=" + nro + ", descr=" + descr + ", paises=" + paises + "]";
	}
	
	
	
}
