package Interfaz;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Logica.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Fase> fases = cargarFases(new LinkedList<Fase>());
		Encargado encargado=new Encargado(1,"Jorge Nitales","asdasd");
		
		fases.get(0).setPaises(cargarPaises(fases.get(0).getPaises()));
		//JOptionPane.showMessageDialog(null, "Lista base \n"+fases.get(0));
		//JOptionPane.showMessageDialog(null, "Lista octavos \n"+fases.get(1));
		menu(fases,encargado,0);
		for (Pais pais : fases.get(0).getPaises()) {
			//menuPais (pais);
		}
		//JOptionPane.showMessageDialog(null, "Lista base \n"+fases.get(0));
		//for (Fase fase : fases) {
			//if (fase.getNro()>0 && fase.getNro()<5) {
				//encargado.eliminatoria(fases, fase.getNro());

			//}
			//JOptionPane.showMessageDialog(null, fase);

			
		//}
		
		//mostrarPartidos(fases.get(0).getPaises().get(8));
		//mostrarPartidos(fases.get(0).getPaises().get(7));
		//fases.get(0).getPaises().get(1).getPartidos().add(new Partido(200,listapaises.get(0),"Empate",2));
		
		
	}

	
	public static void menu (LinkedList<Fase> fases, Encargado encargado, int fase) {
		String []opciones= {"Avanzar a la siguiente fase","Ver paises de esta fase","Ver todos los paises","Volver a la fase anterior","Elegir fase"};
		String titulo=" la "+fases.get(fase).getDescr();
		String descripcion="Elija una opción";
		if (fase==0) {
			opciones[3]="No se puede retroceder más";
		} else if (fase==4) {
			opciones[0]="Ver ganador";
		} else if (fase==5) {
			titulo="l ganador";
			descripcion=fases.get(fase).getPaises().getFirst().getNombre()+" es campeón del mundo";
			opciones[0]="Información del ganador";
			opciones[1]="Salir del programa";
		}
		if (fases.get(1).getPaises().isEmpty()) {
			opciones[0]="Comenzar mundial";
		}
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,descripcion // Mensaje de la ventana
				,"Menu de"+titulo // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,opciones // el objeto
				,opciones[0] // posicion del que va aparecer seleccionado
				);
		if (opcion==null || opcion.equals("Salir del programa")) {
			JOptionPane.showMessageDialog(null, "Gracias por disfrutar el mundial de Qatar 2022\nNos vemos :D");
		} else {
			switch (opcion) {
			case "Ver todos los paises": 
				menuPaises(fases.get(0));
				//JOptionPane.showMessageDialog(null, mostrarPaises(fases.getFirst().getPaises()));
				menu(fases, encargado, fase);
				break;
			case "Avanzar a la siguiente fase": 
				if (fase<fases.size()) {
					if (fases.get(fase+1).getPaises().isEmpty()) {
						encargado.eliminatoria(fases, fase);
					}
					menu(fases, encargado, fase+1);
				} else {
					JOptionPane.showMessageDialog(null, "Estás en la última fase, no se puede avanzar más");
					menu(fases, encargado, fase);
				}
				break;
			case "Volver a la fase anterior": 
					menu(fases, encargado, fase-1);
				break;
			case "Ver paises de esta fase": 
				if (fases.get(fase).getPaises().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vacia");
				} else {
					menuPaises(fases.get(fase));
				}
				menu(fases, encargado, fase);
				break;
			case "Elegir fase": 
				int aux=menuFases(fases);
				if (aux==-1) {
					menu(fases, encargado, fase);
				} else {
					menu(fases, encargado, aux);
				}
				break;
			case "Comenzar mundial": 
				JOptionPane.showMessageDialog(null, "Comienza el mundial Qatar 2022");
				encargado.grupos(fases);
				menu(fases, encargado, fase+1);
				break;
			case "No se puede retroceder más": 
				JOptionPane.showMessageDialog(null, "Estás en la primera fase, no se puede retroceder más");
				menu(fases, encargado, fase);
				break;
			case "Ver ganador":
				if (fases.get(fase+1).getPaises().isEmpty()) {
					encargado.eliminatoria(fases, fase);
				}
				menu(fases, encargado, fase+1);
				break;
			case "Información del ganador":
				menuPais(fases.get(fase).getPaises().getFirst());
				menu(fases, encargado, fase);
				break;
			}
		}
		
	}
	
	
	public static void menuPaises (Fase fase) {
		String []aux= new String[fase.getPaises().size()+1];
		aux[0]="Volver al menu";
		if (fase.getPaises().isEmpty()) {
		} else {
			for (int i=0;i<fase.getPaises().size();i++) {
				aux[i+1]=fase.getPaises().get(i).toString();
			}
			String opcion = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Elija un país" // Mensaje de la ventana
					,"Paises de la "+fase.getDescr() // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,aux // el objeto
					,aux[0] // posicion del que va aparecer seleccionado
					);
			for (Pais pais : fase.getPaises()) {
				if (pais.toString().equals(opcion)) {
					menuPais (pais);
					menuPaises(fase);
				}
				
			}
		}
		
	}
	
	public static void menuPais (Pais pais) {
		String estado;
		if (pais.isEstado()) {
			estado="Activo";
			if (pais.getPartidos().size()>6) {
				estado="Ganador";
			}
		} else {
			estado="Descalificado";
		}
		String aux="Pais "+pais.getNombre()+"\n"+"Goles: "+pais.getGoles()+"\nEstado: "+estado+"\n------------------------------------------------\n";;
		for (Partido partidos : pais.getPartidos()) {
			for (Partido adver : partidos.getAdversario().getPartidos()) {
				if (adver.getAdversario().getNombre().equals(pais.getNombre())) {
					aux+="Partido contra: "+partidos.getAdversario().getNombre()+"\nResultado del partido: "+partidos.getGoles()+" a "+adver.getGoles()+"\nResultado final: "+partidos.getResultado()+"\n \n";
				}
			}
			
			
		}
		JOptionPane.showMessageDialog(null, aux);
	}
	
	public static int menuFases (LinkedList<Fase> fases) {
		String []aux= new String[fases.size()];
		for (int i = 0; i < fases.size()-1; i++) {
			if (fases.get(i).getPaises().isEmpty()) {
				aux[i+1]="Aún no se jugó";
			} else {
				aux[i+1]=fases.get(i).getDescr();
			}
		}
		aux[0]="Volver al menu";
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Elija una fase" // Mensaje de la ventana
				,"Todas las fases" // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,aux // el objeto
				,aux[0] // posicion del que va aparecer seleccionado
				);
		if (opcion==null) {
			return -1;
		}
		for (Fase fase : fases) {
			if (opcion.contains(fase.getDescr())) {
				return fase.getNro()-1;
			}
		}
		if (opcion.equals("Aún no se jugó")) {
			JOptionPane.showMessageDialog(null, "Esta fase aún no se jugó, se debe comenzar el mundial y elegir 'Avanzar a la siguiente fase' para desbloquear");
		}
		if (opcion.equals("Volver al menu") ) {
			return -1;
		}
		return menuFases (fases);
	}
	
	public static LinkedList<Pais> cargarPaises(LinkedList<Pais> lista){
		lista.add(new Pais(lista.size()+1,"Qatar",0.7,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Ecuador",0.9,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Senegal",0.8,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Holanda",1.2,0,"A",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Inglaterra",3,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Iran",3,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Estados Unidos",1,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Gales",1,0,"B ",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Argentina",1.5,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Arabia Saudita",0.9,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Mexico",1,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Polonia",1.2,0,"C",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Francia",1.5,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Australia",0.9,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Dinamarca",0.9,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Tunez",0.7,0,"D",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"España",1.3,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Costa Rica",0.7,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Alemania",1.6,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Japon",0.7,0,"E",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Belgica",1.1,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Canada",0.7,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Marruecos",0.8,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Croacia",1.15,0,"F",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Brasil",1.6,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Serbia",1.1,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Suiza",0.85,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Camerun",0.7,0,"G",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Portugal",1.15,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Gana",0.7,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Uruguay",1.15,0,"H",true,new LinkedList<Partido>()));
		lista.add(new Pais(lista.size()+1,"Korea",1.05,0,"H",true,new LinkedList<Partido>()));
		return lista;
	}
	
	public static LinkedList<Fase> cargarFases(LinkedList<Fase> lista) {
		lista.add(new Fase(1,"Fase de Grupos",new LinkedList<Pais>()));
		lista.add(new Fase(2,"Fase Octavos de Final",new LinkedList<Pais>()));
		lista.add(new Fase(3,"Fase Cuartos de Final",new LinkedList<Pais>()));
		lista.add(new Fase(4,"Fase Semifinal",new LinkedList<Pais>()));
		lista.add(new Fase(5,"Fase Final",new LinkedList<Pais>()));
		lista.add(new Fase(6,"Ganador",new LinkedList<Pais>()));
		return lista;
	}
	
	public static String mostrarPaises(LinkedList<Pais> lista) {
		String aux="";
		if (lista.isEmpty()) {
		} else {
			for (Pais pais : lista) {
				aux+=pais;
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
		
	}
	
}

