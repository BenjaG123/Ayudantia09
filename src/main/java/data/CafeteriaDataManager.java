package data;

import com.google.gson.Gson;
import model.Cafeteria;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CafeteriaDataManager {

	private static final String ARCHIVO_CAFETERIA = "cafeteria.json";
	private Gson gson;

	public CafeteriaDataManager() {
		gson = new Gson();
	}

	public Cafeteria cargarCafeteria() {
		Cafeteria cafeteria = null;
		try {
			File archivo = new File(ARCHIVO_CAFETERIA);
			if (archivo.exists()) {
				FileReader reader = new FileReader(archivo);
				cafeteria = gson.fromJson(reader, Cafeteria.class);
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cafeteria;
	}

	public void guardarCafeteria(Cafeteria cafeteria) {
		try {
			FileWriter writer = new FileWriter(ARCHIVO_CAFETERIA);
			gson.toJson(cafeteria, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
