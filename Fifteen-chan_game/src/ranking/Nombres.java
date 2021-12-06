package ranking;

import java.io.Serializable;

public class Nombres implements Serializable,Comparable<Nombres> {
	private String nombre;
	private Integer puntaje;
	public Nombres(int puntos, String jugador) {
		puntaje=puntos;
		nombre=jugador;
	}
	
	public void setPuntaje(Integer puntos) {
		puntaje=puntos;
	}
	public void setNombre(String jugador) {
		nombre=jugador;
	}

	public Integer getPuntaje() {
		return puntaje;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Nombres o) {
		return this.getPuntaje().compareTo(o.getPuntaje());
	}
}
