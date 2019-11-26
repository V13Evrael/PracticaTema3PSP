package es.studium.ClaseMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import es.studium.Camello.Camello;

public class ClaseMain {
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		int cantidadCamellos = 0;
		int distanciaMeta = 0;
		ArrayList<Camello> listaCamellos = new ArrayList<Camello>();
		
		preguntaDatos("el número de camellos", 2, 10, cantidadCamellos);
		preguntaDatos("la distancia hasta la meta", 10, 50, distanciaMeta);
		
		for (int i = 0; i<cantidadCamellos; i++) {
			
			listaCamellos.add(new Camello(1));
		}

		
	}
	
	public static void preguntaDatos(String dato, int menorValor, int mayorValor, int variableDato) {
		
		int numeroDato = 0;
		boolean incorrect = false;
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduzca " + dato +  " (debe ser un número entre "+ menorValor + " y " + mayorValor + ", incluidos ambos)");
		
		do {
			
			try {
				if (incorrect){
					System.out.println("El valor introducido no está entre "+ menorValor + " y " + mayorValor + " (ambos incluidos). Vuelva a intentarlo.");
				}
				numeroDato = Integer.parseInt(lectura.readLine());
				incorrect = true;
			}
			catch (IOException ioe) {
				
				System.out.println("Se produjo un error con la entrada/salida de los datos. Saliendo del programa...");
				break;
			}
			catch (NumberFormatException nfe) {
				
				System.out.println("El valor introducido no es un número. Vuelva a intentarlo");
				incorrect = false;
			}
		}while ((numeroDato < menorValor) | (numeroDato > mayorValor));	
		
		System.out.println(dato.toUpperCase() + " para esta carrera es " + numeroDato + "\n" );
		variableDato = numeroDato;
	}

}
