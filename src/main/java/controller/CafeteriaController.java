package controller;

import data.CafeDataManger;
import data.CafeteriaDataManager;
import model.Cafe;
import model.Cafeteria;
import model.RedSocial;
import model.Tamanio;

import java.util.ArrayList;

public class CafeteriaController {

	private Cafeteria cafeteria;
	private CafeDataManger cafeDataManger;
	private CafeteriaDataManager cafeteriadm;

	public CafeteriaController() {
		this.cafeteriadm = new CafeteriaDataManager();
		this.cafeDataManger = new CafeDataManger();
		this.cafeteria = cafeteriadm.cargarCafeteria();
		if (this.cafeteria == null) {
			this.cafeteria = new Cafeteria("Cafetería Ejemplo", "Dirección desconocida");
		}
	}

	public Cafeteria getCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
		cafeteriadm.guardarCafeteria(cafeteria);
	}

	public void agregarCafe(String nombre, int gramosCafe, int mlAgua, Tamanio tamanio, ArrayList<model.IngredienteOpcional> ingredientesOpcionales) {
		Cafe nuevoCafe = new Cafe(nombre, gramosCafe, mlAgua, tamanio, ingredientesOpcionales);
		cafeteria.getCafes().add(nuevoCafe);
		cafeDataManger.guardarCafes(cafeteria.getCafes());
	}

	public ArrayList<Cafe> obtenerCafesPorTamanio(Tamanio tamanio) {
		ArrayList<Cafe> cafesPorTamanio = new ArrayList<>();
		for (Cafe cafe : cafeteria.getCafes()) {
			if (cafe.getTamanio() == tamanio) {
				cafesPorTamanio.add(cafe);
			}
		}
		return cafesPorTamanio;
	}

	public void eliminarCafe(String nombre) {
		cafeteria.getCafes().removeIf(cafe -> cafe.getNombre().equals(nombre));
		cafeDataManger.guardarCafes(cafeteria.getCafes());
	}

	public void actualizarDireccionCafeteria(String nuevaDireccion) {
		cafeteria.setDireccion(nuevaDireccion);
		cafeteriadm.guardarCafeteria(cafeteria);
	}

	public void eliminarRedesSociales(String sitioWeb) {
		ArrayList<RedSocial> redesSociales = cafeteria.getRedesSociales();
		redesSociales.removeIf(redSocial -> redSocial.getSitioWeb().equals(sitioWeb));
		cafeteriadm.guardarCafeteria(cafeteria);
	}

	public void modificarRedesSociales(String sitioWeb, String nuevoUsuario, String nuevoPassword) {
		ArrayList<RedSocial> redesSociales = cafeteria.getRedesSociales();
		for (RedSocial redSocial : redesSociales) {
			if (redSocial.getSitioWeb().equals(sitioWeb)) {
				redSocial.setUsuario(nuevoUsuario);
				redSocial.setPassword(nuevoPassword);
				break;
			}
		}
		cafeteriadm.guardarCafeteria(cafeteria);
	}

	public void agregarRedSocial(String usuario, String password, String sitioWeb) {
		RedSocial nuevaRedSocial = new RedSocial(usuario, password, sitioWeb);
		cafeteria.getRedesSociales().add(nuevaRedSocial);
		cafeteriadm.guardarCafeteria(cafeteria);
	}

	public void actualizarNombreCafeteria(String nuevoNombre) {
		cafeteria.setNombre(nuevoNombre);
		cafeteriadm.guardarCafeteria(cafeteria);
	}

	public void guardarDatos() {
		cafeteriadm.guardarCafeteria(cafeteria);
		cafeDataManger.guardarCafes(cafeteria.getCafes());
	}

	public void cargarDatos() {
		cafeteria = cafeteriadm.cargarCafeteria();
		if (cafeteria != null) {
			cafeteria.setCafes(cafeDataManger.cargarCafes());
		}
	}
}
