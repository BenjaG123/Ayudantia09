package model;

import java.util.ArrayList;

public class Cafe {

	private String nombre;
	private int gramosCafe;
	private int mlAgua;
	private Tamanio tamanio;
	private ArrayList<IngredienteOpcional> ingredientesOpcionales;


	public int getGramosCafe() {
		return this.gramosCafe;
	}

	public void setGramosCafe(int gramosCafe) {
		this.gramosCafe = gramosCafe;
	}

	public int getMlAgua() {
		return this.mlAgua;
	}

	public void setMlAgua(int mlAgua) {
		this.mlAgua = mlAgua;
	}

	public Tamanio getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public ArrayList<IngredienteOpcional> getIngredientesOpcionales() {
		return this.ingredientesOpcionales;
	}

	public void setIngredientesOpcionales(ArrayList<IngredienteOpcional> ingredientesOpcionales) {
		this.ingredientesOpcionales = ingredientesOpcionales;
	}

	public Cafe(String nombre, int gramosCafe, int mlAgua, Tamanio tamanio, ArrayList<IngredienteOpcional> ingredientesOpcionales) {
		this.nombre = nombre;
		this.gramosCafe = gramosCafe;
		this.mlAgua = mlAgua;
		this.tamanio = tamanio;
		this.ingredientesOpcionales = ingredientesOpcionales;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cafe{" +
				"Nombre='" + nombre + '\'' +
				", Gramos de Café=" + gramosCafe +
				", Cantidad de Agua (ml)=" + mlAgua +
				", Tamaño=" + tamanio +
				", Ingredientes Opcionales=" + ingredientesOpcionales +
				'}';
	}

}