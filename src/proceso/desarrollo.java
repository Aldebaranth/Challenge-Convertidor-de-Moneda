package proceso;
import javax.swing.JOptionPane;

import API.conversor_Ascii;
import API.conversor_moneda;
import API.conversor_temperatura;

public class desarrollo {

	public void iniciar() {
		// Hacemos el menu de Opciones
		Object [] opciones = {
				"Conversor de Moneda", "Conversor de Temperatura", "Conversor de codigo Ascii"};
		Object opcion_elegir = JOptionPane.showInputDialog(null, "Seleccionar una opción de conversión", "Menú", JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
		String opcion_elegida = (String) opcion_elegir;
		
		if(opcion_elegida!=null) {
			switch (opcion_elegida) {
				case "Conversor de Moneda": {
					conversor_moneda conversor_m = new conversor_moneda();
					conversor_m.obtener_datos();
					break;
				}
				case "Conversor de Temperatura": {
					conversor_temperatura conversor_t = new conversor_temperatura();
					conversor_t.obtener_datos();
					break;
				}
				case "Conversor de codigo Ascii": {
					conversor_Ascii conversor_c = new conversor_Ascii();
					conversor_c.obtener_datos();
					break;
				}
				default:
					break;
				}	
		}
	}
}
