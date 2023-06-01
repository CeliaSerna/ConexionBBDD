package com.cursoceat.modell;

public class Alumnos {

	private int cod;
	private String nombre;
	private String clase;
	private float media;
	
	public Alumnos(int cod, String nombre, String clase, float media) {
		
		this.cod = cod;
		this.nombre = nombre;
		this.clase = clase;
		this.media = media;
	}
	public Alumnos(String nombre, String clase, float media) {
		
		this.nombre = nombre;
		this.clase = clase;
		this.media = media;
	}
	public Alumnos() {
		
	}
	public int getCod() {
		return cod;
	}
	public String getNombre() {
		return nombre;
	}
	public String getClase() {
		return clase;
	}
	public float getMedia() {
		return media;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	@Override
	public String toString() {
		return "Alumnos [Código = " + cod + ", Nombre = " + nombre + ", Clase = " + clase + ", Media = " + media + "]\n";
	}




}
