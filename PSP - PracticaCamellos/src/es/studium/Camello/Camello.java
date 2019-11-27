package es.studium.Camello;

public class Camello implements Runnable {

	private int dorsal;
	private String nombre;
	private boolean finCarrera = false;
	private int posicionActual = 0;
	private static Integer meta = 0;
	private static int posicionLider = 1;
	
	public Camello() {
		dorsal = 0;
		nombre = "Camello " + dorsal;
	}
	
	public Camello(int dorsal) {
		
		this.dorsal = dorsal;
		this.nombre = "Camello " + dorsal;
	}
	
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPosicionActual() {
		
		return posicionActual;
	}
	
	public void setPosicionActual(int nuevaPos) {
		
		this.posicionActual = nuevaPos;
	}
	
	public static int lanzaBola() {
		
		int resultado = 3;
		
		int numero = (int) (Math.random()*100);
		
		if (numero<30) {
			resultado = 0;
		}
		
		else if (numero<70) {
			resultado = 1;
		}
		
		else if (numero<90) {
			resultado = 2;
		}
		
		return resultado;		
	}
	
	public void avanzaYMuestra() {
		
		int mov = lanzaBola();
		int posicion = this.getPosicionActual() + mov;
		this.setPosicionActual(posicion);
		String muestra = "";
		
		muestra = (nombre + " avanza " + mov + " posiciones y lleva " + posicion + " posiciones, ");
		
		if(posicion >= posicionLider) {
			
			posicionLider = posicion;
			muestra += "y va en primera posición.";
		}
		
		else {
			
			muestra += "a " + (posicionLider-posicion) + " posiciones del líder.";		
		}
		
		synchronized (meta) {
			
			if (posicion>=meta) {
				finCarrera = true;
				System.out.println("El " + nombre + " es el ganador.");
			}
		}
		
		System.out.println(muestra);
	}
	
	public static void setMeta(int nuevaMeta) {
		
		meta = nuevaMeta;
	}
	
	@Override
	public void run() {

		
	}
}
