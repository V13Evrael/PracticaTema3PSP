package es.studium.Camello;

public class Camello implements Runnable {

	private int dorsal;
	private String nombre;
	private int posicionActual = 0;
	
	
	public Camello() {
		dorsal = 0;
		nombre = "Camello " + dorsal;
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

	public Camello(int dorsal) {
		
		this.dorsal = dorsal;
		this.nombre = "Camello " + dorsal;
	}
	
	public int getPosicionActual() {
		
		return posicionActual;
	}
	
	public void setPosicionActual(int nuevaPos) {
		
		this.posicionActual = nuevaPos;
	}
	
	public void avanza(int puestosAvanzados) {
		
		this.setPosicionActual(this.getPosicionActual() + puestosAvanzados);
	}

	@Override
	public void run() {

		
	}
}
