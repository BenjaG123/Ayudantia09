package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Cafe;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CafeDataManger {

	private static final String ARCHIVO_CAFES = "cafes.json";
	private final Gson gson;

	public CafeDataManger() {
		gson = new Gson();
	}

	public ArrayList<Cafe> cargarCafes() {
		ArrayList<Cafe> cafes = new ArrayList<>();
		try {
			File archivo = new File(ARCHIVO_CAFES);
			if (archivo.exists()) {
				FileReader reader = new FileReader(archivo);
				Type listType = new TypeToken<ArrayList<Cafe>>(){}.getType();
				cafes = gson.fromJson(reader, listType);
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cafes;
	}

	public void guardarCafes(ArrayList<Cafe> cafes) {
		try {
			FileWriter writer = new FileWriter(ARCHIVO_CAFES);
			gson.toJson(cafes, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
