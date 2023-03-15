package API;
import proceso.desarrollo;//paquete
import proceso.mensaje_final;//paquete
import java.time.LocalDate; //fecha
import java.time.format.DateTimeFormatter;// para pasar dato de LocalDate a String 
import javax.swing.JOptionPane; //interfaz

public class conversor_moneda {
	
	public void obtener_datos() {
	
		//ingresar tipo moneda
		Object [] opciones_moneda={
				"De Pesos(MX) a Dolar","De Pesos (COP) a Dólar", "De Soles(PEN) a Dólar",
				"De Soles (PEN) a Pesos (COP)","De Soles (PEN) a Euro","De Soles a Yen",
				"De Soles a Yuan", "De Soles a Won",
				"De Soles (PEN) a pesos (MX)","De Dolar a Euro","De Dolar a Pesos(COP)",
				"De Dolar a Soles","De Euro a Soles", "De Yen a Soles", "De Yuan a Soles",
				"De Won a Soles"
				}; 
		Object opciones_elegir_moneda = JOptionPane.showInputDialog(null,"Selecciona una opción de conversión", "Menu",JOptionPane.QUESTION_MESSAGE,null,opciones_moneda, opciones_moneda[0]);
		//System.out.println(opciones_elegir_moneda);
		String opcionMoneda_elegida= (String)opciones_elegir_moneda;
		
		// por si no elige ninguna opcion de conversion
		if (opciones_elegir_moneda==null) {
			mensaje_final mensaje_final= new mensaje_final();
			mensaje_final.mensaje_final_();
			// por si escoge no seguir se sale del programa
			System.exit(0);
		}
		
	
		try {
			//ingresar valor monetario
			String opcion_cantidad_dinero=JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desea convertir \n Opción escogida: "+ opcionMoneda_elegida);
			
			//operción conversión
			conversor_moneda operacion= new conversor_moneda();
			operacion.resultado_conversion(opcionMoneda_elegida, opcion_cantidad_dinero);
		}
		// por si se  ingresa un valor  no permitido
		catch(NumberFormatException | NullPointerException exception) {
			JOptionPane.showMessageDialog(null,"Valor no valido","Error",JOptionPane.ERROR_MESSAGE);
			desarrollo intentar_de_nuevo= new desarrollo();
			intentar_de_nuevo.iniciar();

		}
		
	}
	
	public void resultado_conversion(String tipoConvercion, String cantidaDinero) {
		
		String datos_api[];//guarda los datos que se envia a  la API
		datos_api= new String[4];
		
		String pasar_De="",pasar_a = "";
	
		switch (tipoConvercion) {
			case "De Pesos(MX) a Dolar":
				pasar_De="MXN";
				pasar_a="USD";
				break;
				
			case "De Pesos (COP) a Dólar":
				pasar_De="COP";
				pasar_a="USD";
				break;
				
			case "De Pesos (COP) a Euro":
				pasar_De="COP";
				pasar_a="EUR";
				break;
			
			case "De Soles(PEN) a Dólar":
				pasar_De="PEN";
				pasar_a="USD";
				break;
				
			case "De Soles a Pesos (COP)":
				pasar_De="PEN";
				pasar_a="COP";
				break;
				
			case "De Soles a Yuan":
				pasar_De="PEN";
				pasar_a="CNY";
				break;
				
			case "De Soles a Won":
				pasar_De="PEN";
				pasar_a="KRW";
				break;	
			
			case "De Soles (PEN) a pesos (MX)":
				pasar_De="COP";
				pasar_a="MXN";
				break;
				
			case "De Soles a Yen":
				pasar_De="PEN";
				pasar_a="JPY";
				break;
				
			case "De Dolar a Pesos(COP)":
				pasar_De="USD";
				pasar_a="COP";
				break;
				
			case "De Dolar a Euro":
				pasar_De="USD";
				pasar_a="EUR";
				break;
					
			case "De Pesos(MX) a Pesos(COP)":
				pasar_De="MXN";
				pasar_a="COP";
				break;
				
			case "De Euro a Pesos(COP)" : 
				pasar_De="EUR";
				pasar_a="COP";	
				break;
				
			case "De Dolar a Soles":
				pasar_De="USD";
				pasar_a="PÉN";
				break;
				
			case "De Euro a Soles":
				pasar_De="EUR";
				pasar_a="PEN";
				break;
				
			case "De Yen a Soles":
				pasar_De="JPY";
				pasar_a="PEN";
				break;
				
			case "De Yuan a Soles":
				pasar_De="CNY";
				pasar_a="PEN";
				break;
				
			case "De Won a Soles":
				pasar_De="KRW";
				pasar_a="PEN";
				break;
							
			default:
				break;

		}
		
		// obtener la fecha actual 
		LocalDate actualDate =LocalDate.now();
		// pasar de tipo LocalDate a String
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String fecha_formateada = actualDate.format(formatter);
		
		// guardar los datos en el array
		datos_api[0]= fecha_formateada; 
		datos_api[1]=cantidaDinero;
		datos_api[2]=pasar_De;
		datos_api[3]=pasar_a;
		
		//pasar datos a la Api
		API_conversor respuesta = new API_conversor();
		double valor_convertido=respuesta.get(datos_api[0],datos_api[1],datos_api[2],datos_api[3]);
		
		
		//formato decimales del  resultado
		double valor_formateado=0;
		
		valor_formateado=Math.round((valor_convertido*100.0)/100.0);
		
		
		//mostrar conversión
		JOptionPane.showMessageDialog(null,"El valor de la conversión  "+ tipoConvercion+ " es : $"+ valor_formateado);
		
		//mensaje final
		
		mensaje_final mensaje_final= new mensaje_final();
		mensaje_final.mensaje_final_();
		
		
		
	}
	
	
	
	
}