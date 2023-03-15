package API;

import javax.swing.JOptionPane;

import proceso.desarrollo;
import proceso.mensaje_final;

public class conversor_Ascii{
	
	public void obtener_datos() {
		Object [] opciones_Ascii = {"De Número a codigo Ascii"};
		Object opciones_elegir_Ascii = JOptionPane.showInputDialog(null, "Selecciona una opción de conversión", "Menu",JOptionPane.QUESTION_MESSAGE,null,opciones_Ascii, opciones_Ascii[0]);
		String opcionAscii_elegida= (String)opciones_elegir_Ascii;
		
		if (opciones_elegir_Ascii==null) {
			mensaje_final mensaje_final= new mensaje_final();
			mensaje_final.mensaje_final_();
			// por si escoge no seguir se sale del programa
			System.exit(0);
		}
		
		try {
			//ingresar valor 
			String opcion_codigos=JOptionPane.showInputDialog("Ingrese los numeros o el codigo Ascii que desea convertir \n Opción escogida : "+ opcionAscii_elegida);
			
			//operción conversión
			conversor_Ascii operacion= new conversor_Ascii();
			operacion.resultado_conversion(opcionAscii_elegida,opcion_codigos);
		}// por si se  ingresa un valor  no permitido
		catch(NumberFormatException | NullPointerException exception) {
			JOptionPane.showMessageDialog(null,"Valor no valido","Error",JOptionPane.ERROR_MESSAGE);
			desarrollo intentar_de_nuevo= new desarrollo();
			intentar_de_nuevo.iniciar();

		}
	}

	public void resultado_conversion(String tipoConvercion, String codigoAscii) {
		String resultado_conversion="";
		
		switch (tipoConvercion) {
		case "De Número a codigo Ascii": {
			resultado_conversion=Character.toString(Integer.parseInt(codigoAscii));
			break;
		}
		default:
			break;
		}

		JOptionPane.showMessageDialog(null, "El valor de la conversion: "+ tipoConvercion + " es: \n" + resultado_conversion);

		mensaje_final mensaje_final= new mensaje_final();
		mensaje_final.mensaje_final_();
	}

}
