package Interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Logica.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Fase> fases = cargarFases(new LinkedList<Fase>());
		Encargado encargado=new Encargado(1,"Jorge Nitales","asdasd");
		LinkedList<Pais> listapaises= cargarPaises(new LinkedList<Pais>());
		JOptionPane.showMessageDialog(null, "Lista base \n"+mostrarPaises(listapaises));

		encargado.grupos(listapaises,fases);
		JOptionPane.showMessageDialog(null, mostrarPaises(fases.get(0).getPaises()));
		mostrarPartidos(listapaises.get(1));
		//fases.get(0).getPaises().get(1).getPartidos().add(new Partido(200,listapaises.get(0),"Empate",2));
		
		
	}

	
	public static LinkedList<Pais> cargarPaises(LinkedList<Pais> lista){
		lista.add(new Pais(lista.size()+1,"Qatar",0.7,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Ecuador",0.9,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Senegal",0.8,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Holanda",1,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Inglaterra",1.2,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Iran",0.7,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Estados Unidos",1.1,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Gales",1,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Argentina",1.5,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Arabia Saudita",0.9,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Mexico",1,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Polonia",1,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Francia",1.5,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Australia",0.9,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Dinamarca",0.9,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Tunez",0.7,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"España",1.2,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Costa Rica",0.7,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Alemania",1.6,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Japon",0.7,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Belgica",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Canada",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Marruecos",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Croacia",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Brasil",1.6,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Serbia",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Suiza",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Camerun",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Portugal",0.7,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Gana",0.7,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Uruguay",1,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Korea",0.7,0,"H",true,new LinkedList<Partido>()));
		return lista;
	}
	
	public static LinkedList<Fase> cargarFases(LinkedList<Fase> lista) {
		lista.add(new Fase(1,"Grupos",new LinkedList<Pais>()));
		lista.add(new Fase(2,"Octavos",new LinkedList<Pais>()));
		lista.add(new Fase(3,"Cuartos",new LinkedList<Pais>()));
		lista.add(new Fase(4,"Semifinal",new LinkedList<Pais>()));
		lista.add(new Fase(5,"Final",new LinkedList<Pais>()));
		return lista;
	}
	
	public static String mostrarPaises(LinkedList<Pais> lista) {
		String aux="";
		if (lista.isEmpty()) {
		} else {
			for (Pais pais : lista) {
				aux+=pais+"\n";
			}
		}
		return aux;
	}
	
	public static Pais listadepaises(Fase fase) {
String []opciones= new String [fase.getPaises().size()];
		
		
		for (Pais pais : fase.getPaises()) {
			
			opciones[fase.getPaises().indexOf(pais)]=pais.getNombre();
		}
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Seleccione de Datos" // Mensaje de la ventana
				,"Lista de Datos" // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,opciones // el objeto
				,opciones[0] // posicion del que va aparecer seleccionado
				);
		
		JOptionPane.showMessageDialog(null, opcion);
		
			for (Pais pais : fase.getPaises()) {
			
				if(pais.getNombre().equals(opcion)) {
					return pais;
				}
		}
			return null;
	}
	
	public static void mostrarPartidos(Pais pais) {
		String aux="";
		for (Partido partidos : pais.getPartidos()) {
			aux+="Partido contra: "+partidos.getAdversario().getNombre()+"\n"+partidos.getResultado()+" con "+partidos.getGoles()+"\n \n";
			
		}
		JOptionPane.showMessageDialog(null, aux);
	}
	
}

