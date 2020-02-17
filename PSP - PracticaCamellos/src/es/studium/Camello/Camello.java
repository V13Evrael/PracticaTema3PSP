package es.studium.Camello;

import java.util.Arrays;

import es.studium.ClaseMain.ClaseMain;

public class Camello implements Runnable, Comparable<Camello> {

	private int dorsal;
	private String nombre;
	private static Boolean finCarrera = false;
	private int posicionActual = 0;
	private static Integer meta = 0;
	private static Integer posicionLider = 0;
	private static Integer camelloGanador = -1;

	// Constructor sin parámetros
	public Camello() {
		dorsal = 0;
		nombre = "Camello " + dorsal;
	}

	// Constructor con parámetro
	public Camello(int dorsal) {

		this.dorsal = dorsal;
		this.nombre = "Camello " + dorsal;
	}

	// Get del dorsal, que nos da el número que se usa del Camello.
	public int getDorsal() {
		return dorsal;
	}

	// Set del dorsal.
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	// Get el nombre del Camello.
	public String getNombre() {
		return nombre;
	}

	// Set del nombre del Camello.
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Get la posición del Camello.
	public int getPosicionActual() {

		return posicionActual;
	}

	// Set la posición actual del Camello.
	public void setPosicionActual(int nuevaPos) {

		this.posicionActual = nuevaPos;
	}

	// Set de la meta.
	public static void setMeta(int nuevaMeta) {

		meta = nuevaMeta;
	}

	public static int lanzaBola() {

		int resultado = 3;

		int numero = (int) (Math.random() * 100);

		if (numero < 30) {
			resultado = 0;
		}

		else if (numero < 70) {
			resultado = 1;
		}

		else if (numero < 90) {
			resultado = 2;
		}

		return resultado;
	}

	public Integer avanza() {

		int mov = lanzaBola();
		int nuevaPosicion = this.getPosicionActual() + mov;

		if (meta <= nuevaPosicion) {
			nuevaPosicion = meta;
		}

		this.setPosicionActual(nuevaPosicion);

		return mov;
	}

	public static void compruebaFin(Camello camel) {

		if (camel.getPosicionActual() >= meta) {

			finCarrera = true;

			if (camelloGanador == -1) {
				camelloGanador = camel.getDorsal();
			}
		}
	}

	public static void compruebaLider(Camello camel) {

		if (camel.getPosicionActual() > posicionLider) {

			posicionLider = camel.getPosicionActual();
		}
	}

	public static synchronized void muestraAvance(Integer mov, Camello camel) {

		compruebaFin(camel);
		compruebaLider(camel);

		String resultado = "";

		if (!finCarrera) {

			resultado = camel.getNombre() + " avanza " + posSingular(mov) + " y lleva " + camel.getPosicionActual()
					+ " posiciones, ";
			if (camel.getPosicionActual() == posicionLider) {
				resultado = resultado + "y va en primera posición.";
			} else {
				resultado = resultado + "a " + posSingular(posicionLider - camel.getPosicionActual()) + " del líder";
			}

			System.out.println(resultado);
		}

		else if (camelloGanador == camel.getDorsal()) {

			System.out.println("\nEl " + camel.getNombre() + " ha ganado la carrera");
			Arrays.sort(ClaseMain.listaCamellos);
			System.out.println("\nEl ranking ha quedado del siguiente modo:");
			System.out.println("1º " + camel.getNombre());

			int contadorRank = 2;

			for (int i = 0; i < ClaseMain.listaCamellos.length; i++) {

				if (ClaseMain.listaCamellos[i].getDorsal() != camelloGanador) {
					System.out.println((contadorRank) + "º " + ClaseMain.listaCamellos[i].getNombre() + " a "
							+ posSingular(meta - ClaseMain.listaCamellos[i].getPosicionActual()));
					contadorRank++;
				}
			}
		}
	}

	@Override
	public void run() {

		while (!finCarrera) {

			Integer movimiento = this.avanza();
			try {
				Thread.sleep((int) (Math.random() * 50) + 30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			muestraAvance(movimiento, this);
		}
	}

	@Override
	public int compareTo(Camello camel) {

		if (camel.getPosicionActual() > this.getPosicionActual()) {
			return 1;
		}

		if (camel.getPosicionActual() < this.getPosicionActual()) {
			return -1;
		}

		return 0;
	}

	public static String posSingular(int valor) {

		if (valor == 1) {
			return valor + " posición";
		}
		return valor + " posiciones";
	}
}