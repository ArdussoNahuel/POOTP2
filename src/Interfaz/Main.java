package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Pais> listapaises= new LinkedList<Pais>();
		cargarPaises(listapaises);
		JOptionPane.showMessageDialog(null, mostrarPaises(listapaises));
		System.out.println(Math.round(50*1.3/10));
		System.out.println((int)((50*1.15)/10));
	}

	
	public static LinkedList<Pais> cargarPaises(LinkedList<Pais> lista){
		lista.add(new Pais(lista.size()+1,"Qatar",0.7,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Ecuador",0.9,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Senegal",0.8,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Holanda",1,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Inglaterra",1.05,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Iran",0.7,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Estados Unidos",1,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Gales",1,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Argentina",1.2,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Arabia Saudita",0.9,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Mexico",1,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Polonia",1,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Francia",1.2,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Australia",0.9,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Dinamarca",0.9,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Tunez",0.7,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Espa�a",1.1,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Costa Rica",0.7,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Alemania",0.7,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Japon",0.7,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Belgica",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Canada",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Marruecos",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Croacia",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Brasil",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Serbia",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Suiza",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Camerun",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Portugal",0.7,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Gana",0.7,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Uruguay",0.7,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Korea",0.7,0,"H",true,new LinkedList<Partido>()));
		return lista;
	}
	
	public static String mostrarPaises(LinkedList<Pais> lista) {
		String aux="";
		if (lista.isEmpty()) {
			aux="No hay paises en esta lista";
		} else {
			for (Pais pais : lista) {
				aux+=pais+"\n";
			}
		}
		return aux;
	}
	
	public static void grupos(LinkedList<Pais> lista) {
		
		for (Pais pais : lista) {
			jugarPartido();
		}
		
	}
	
}

