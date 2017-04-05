import javax.swing.JOptionPane;

public class Interfaz {
	
	/**
	 * Metodo main, encargado de pedir los datos para el calculo de p
	 * @param args
	 */
	public static void main(String[] args) {//Declaracion metodo
		double cS = 0;
		double e = 0;
		double gL = 0;
		double xi = 0;
		String cantidadSegmentos = JOptionPane.showInputDialog("Ingrese cantidad de segmentos");
		if(cantidadSegmentos == null){
			System.exit(0);
		}else if (cantidadSegmentos.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un valor en el campo");
			System.exit(0);
		}
		
		String error = JOptionPane.showInputDialog("Ingrese tolerancia");
		if(error == null){
			System.exit(0);
		}else if (error.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un valor en el campo");
			System.exit(0);
		}
		
		String gradosLibertad = JOptionPane.showInputDialog("Ingrese grados de libertad");
		if(gradosLibertad == null){
			System.exit(0);
		}else if (gradosLibertad.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un valor en el campo");
			System.exit(0);
		}
		
		String x = JOptionPane.showInputDialog("Ingrese Xi");
		if(x == null){
			System.exit(0);
		}else if (x.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un valor en el campo");
			System.exit(0);
		}
		
		try {
			cS = Double.parseDouble(cantidadSegmentos);
			e = Double.parseDouble(error);
			gL = Double.parseDouble(gradosLibertad);
			xi = Double.parseDouble(x);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Los valores ingresados deben ser numeros, no se aceptan letras");
			System.exit(0);
		}
		
		Calculos calculos = new Calculos(cS, e, gL, xi);
		System.out.println(calculos.getP());

	}
	/**Fin metodo**/
	

}
