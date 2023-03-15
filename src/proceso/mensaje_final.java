package proceso;

import javax.swing.JOptionPane; 

public class mensaje_final {

	public void mensaje_final_() {
		System.out.println("Terminar");
		Object mensaje_opcion = JOptionPane.showConfirmDialog(null, "¿Deseas Continuar?","Seleccionar una Opción: ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		int mensaje = (Integer) mensaje_opcion;
		
		if(mensaje==0) {
			// Desa continuar
			desarrollo intentar_de_nuevo = new desarrollo();
			intentar_de_nuevo.iniciar();
		}
		else if(mensaje==1) {
			// Desaa Terminar el Programa
			JOptionPane.showMessageDialog(null, "Programa Finalizado", "Gracias por usar el Programa", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
