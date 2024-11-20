package model;

import java.util.ArrayList;

public class Cafeteria {

	private String nombre;
	private String direccion;
	private ArrayList<Cafe> cafes;
	private ArrayList<RedSocial> redesSociales;

	public Cafeteria(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cafes = new ArrayList<>();
		this.redesSociales = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Cafe> getCafes() {
		return this.cafes;
	}

	public void setCafes(ArrayList<Cafe> cafes) {
		this.cafes = cafes;
	}

	public ArrayList<RedSocial> getRedesSociales() {
		return this.redesSociales;
	}

	public void setRedesSociales(ArrayList<RedSocial> redesSociales) {
		this.redesSociales = redesSociales;
	}

	@Override
	public String toString() {
		return "Cafeteria{" +
				"Nombre='" + nombre + '\'' +
				", Direccion='" + direccion + '\'' +
				", Cafes=" + cafes +
				", Redes Sociales=" + redesSociales +
				'}';
	}

}