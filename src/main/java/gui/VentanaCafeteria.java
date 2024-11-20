package gui;

import controller.CafeteriaController;
import model.Cafe;
import model.Tamanio;
import model.IngredienteOpcional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaCafeteria {

	private CafeteriaController controlador;
	private JFrame ventana;
	private JTextArea areaTexto;
	private JTextField campoNombreCafe;
	private JTextField campoGramosCafe;
	private JTextField campoMlAgua;
	private JComboBox<Tamanio> comboTamanio;
	private JTextField campoIngrediente;

	public VentanaCafeteria(CafeteriaController controlador) {
		this.controlador = controlador;
		ventana = new JFrame("Cafetería");
		ventana.setLayout(new FlowLayout());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(500, 500);
		areaTexto = new JTextArea(20, 40);
		areaTexto.setEditable(false);
		JScrollPane scroll = new JScrollPane(areaTexto);

		// Componentes para agregar un nuevo café
		JLabel labelNombreCafe = new JLabel("Nombre del café:");
		campoNombreCafe = new JTextField(20);
		JLabel labelGramosCafe = new JLabel("Gramos de café:");
		campoGramosCafe = new JTextField(5);
		JLabel labelMlAgua = new JLabel("Mililitros de agua:");
		campoMlAgua = new JTextField(5);
		JLabel labelTamanio = new JLabel("Tamaño:");
		comboTamanio = new JComboBox<>(Tamanio.values());

		JLabel labelIngrediente = new JLabel("Ingrediente (si lo hay):");
		campoIngrediente = new JTextField(20);

		// Botones de la interfaz
		JButton btnAgregarCafe = new JButton("Agregar Café");
		JButton btnMostrarPorTamanio = new JButton("Mostrar cafés por tamaño");
		JButton btnEliminarCafe = new JButton("Eliminar Café");
		JButton btnModificarCafeteria = new JButton("Modificar Información");

		// Agregar componentes a la ventana
		ventana.add(labelNombreCafe);
		ventana.add(campoNombreCafe);
		ventana.add(labelGramosCafe);
		ventana.add(campoGramosCafe);
		ventana.add(labelMlAgua);
		ventana.add(campoMlAgua);
		ventana.add(labelTamanio);
		ventana.add(comboTamanio);
		ventana.add(labelIngrediente);
		ventana.add(campoIngrediente);
		ventana.add(btnAgregarCafe);
		ventana.add(btnMostrarPorTamanio);
		ventana.add(btnEliminarCafe);
		ventana.add(btnModificarCafeteria);
		ventana.add(scroll);

		// Acción para agregar un café
		btnAgregarCafe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarCafe();
			}
		});

		// Acción para mostrar cafés por tamaño
		btnMostrarPorTamanio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarCafesPorTamanio();
			}
		});

		// Acción para descontinuar un café
		btnEliminarCafe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				descontinuarCafe();
			}
		});

		// Acción para modificar la cafetería
		btnModificarCafeteria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificarCafeteria();
			}
		});

		ventana.setVisible(true);
	}

	// Método para agregar un café
	private void agregarCafe() {
		String nombre = campoNombreCafe.getText();
		int gramosCafe = Integer.parseInt(campoGramosCafe.getText());
		int mlAgua = Integer.parseInt(campoMlAgua.getText());
		Tamanio tamanio = (Tamanio) comboTamanio.getSelectedItem();

		// Crear lista de ingredientes opcionales
		ArrayList<IngredienteOpcional> ingredientes = new ArrayList<>();
		String ingredienteTexto = campoIngrediente.getText().trim();
		if (!ingredienteTexto.isEmpty()) {
			try {
				IngredienteOpcional ingrediente = IngredienteOpcional.valueOf(ingredienteTexto.toUpperCase());
				ingredientes.add(ingrediente);
			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(ventana, "Ingrediente no válido, por favor elige entre: Crema, Leche, Chocolate.");
				return;
			}
		}

		controlador.agregarCafe(nombre, gramosCafe, mlAgua, tamanio, ingredientes);
		areaTexto.append("Café agregado: " + nombre + " (" + tamanio + ")\n");
	}

	// Método para mostrar cafés por tamaño
	private void mostrarCafesPorTamanio() {
		Tamanio tamanioSeleccionado = (Tamanio) comboTamanio.getSelectedItem();
		ArrayList<Cafe> cafes = controlador.obtenerCafesPorTamanio(tamanioSeleccionado);

		areaTexto.append("Cafés del tamaño " + tamanioSeleccionado + ":\n");
		for (Cafe cafe : cafes) {
			areaTexto.append(cafe.getNombre() + "\n");
		}
	}

	// Método para descontinuar un café
	private void descontinuarCafe() {
		String nombreCafe = JOptionPane.showInputDialog("Introduce el nombre del café a descontinuar:");
		controlador.eliminarCafe(nombreCafe);
		areaTexto.append("Café descontinuado: " + nombreCafe + "\n");
	}

	// Método para modificar la cafetería
	private void modificarCafeteria() {
		String nuevaDireccion = JOptionPane.showInputDialog("Introduce la nueva dirección:");
		controlador.actualizarDireccionCafeteria(nuevaDireccion);
		areaTexto.append("Dirección de la cafetería actualizada: " + nuevaDireccion + "\n");
	}
}
