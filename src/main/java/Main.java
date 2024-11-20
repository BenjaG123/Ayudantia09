import controller.CafeteriaController;
import gui.VentanaCafeteria;

public class Main {
    public static void main(String[] args) {
        CafeteriaController controlador = new CafeteriaController();
        new VentanaCafeteria(controlador);
    }
}
