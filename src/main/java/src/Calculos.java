/**
 * Clase encargada de realizar todos los calculos para, finalmente, retornar el valor de p
 * @author Miguel Angel Quintero P
 * @version 03/04/2017
 */
public class Calculos {
	/**Variables de la clase**/
	private double numeroSegmentos;
	private double error;
	private double gradosDeLibertad;
	private double x;
	private double p;
	private double constante;
	
	
	/**
	 * Constructor de la clase
	 * @param numeroSegmentos Cantidad de segmentos en los que se va a dividir la funcion
	 * @param error Valor de tolerancia de error
	 * @param gradosDeLibertad Grados de libertad para el calculo del valor
	 * @param x Valor de x sobre el cual iterara el metodo simpson
	 */
	public Calculos(double numeroSegmentos, double error, double gradosDeLibertad, double x) {//Declaracion metodo
		this.numeroSegmentos = numeroSegmentos;
		this.error = error;
		this.gradosDeLibertad = gradosDeLibertad;
		this.x = x;
		calcularConstante();
		calcularP();
	}
	/**Fin del metodo**/
	
	/**
	 * Calcula el factorial de un numero 
	 * @param numero Numero al que se va a realizar el calculo del factorial
	 * @return Factorial del numero 
	 */
	private double calcularGammaFactorial(double numero){//Declaracion metodo
		if (numero == 0)
			return 1;
		else
			return numero * calcularGammaFactorial(numero-1);		
	}
	/**Fin del metodo**/
	
	
	/**
	 * Retorna el calculo de gamma para valores no enteros
	 * @param numero Numero al que se le hara el calculo de gamma
	 * @return Valor de gamma calculado
	 */
	private double calcularGammaIterado(double numero){//Declaracion metodo
		if (numero == 1){
			return 1;
		}else if (numero == 0.5) {
			return Math.sqrt(Math.PI);
		}else{
			return (numero -1) * calcularGammaIterado(numero - 1);
		}		
	}
	/**Fin del metodo**/
	
	/**
	 * Calcula el valor de la constante para el calculo de p
	 */
	private void calcularConstante(){//Declaracion metodo
		double numerador = 0;
		double denominador = 0;
		
		if( ((this.gradosDeLibertad + 1) / 2.0) - 1 % 1 == 0 ){
			numerador = calcularGammaFactorial( ((this.gradosDeLibertad + 1) / 2.0) - 1 );
		}else{
			numerador = calcularGammaIterado( (this.gradosDeLibertad + 1) / 2.0 );
		}
		
		if( (this.gradosDeLibertad / 2) % 1 == 0 ){
			denominador = Math.pow((this.gradosDeLibertad * Math.PI), 0.5) * calcularGammaFactorial((this.gradosDeLibertad / 2.0) - 1);
		}else{
			denominador = Math.pow((this.gradosDeLibertad * Math.PI), 0.5) * calcularGammaIterado(this.gradosDeLibertad / 2.0);
		}
		
		this.constante = numerador / denominador;
	}
	/**Fin del metodo**/
	
	/**
	 * Calcula Fx para cada valor de Xi
	 * @return Valor de Fx
	 */
	private double calcularFX(double xi){//Declaracion metodo
		double primerTermino = 0;
		double segundoTermino = 0;
		
		primerTermino = 1 + ( Math.pow(xi, 2) / this.gradosDeLibertad );
		segundoTermino = Math.pow(primerTermino, - ( (this.gradosDeLibertad + 1) / 2)  );
		return this.constante * segundoTermino;		
	}
	/**Fin del metodo**/
	
	/**
	 * Calcula sumatoria
	 */
	private double calcularSumatoria(){//Declaracion metodo
		double w = this.x / this.numeroSegmentos;
		double sumatoria = 0;
		double xi = 0;
		double multiplicador;
		
		for(int i = 0; i<= this.numeroSegmentos ; i++){
			
			if(i == 0 || i == this.numeroSegmentos){
				multiplicador = 1;
			}else if (i % 2 == 0 ) {
				multiplicador = 2;
			}else{
				multiplicador = 4;
			}
			
			sumatoria = sumatoria + ((w/3) * multiplicador * calcularFX(xi));			
			xi = xi + w;
		}
		
		return sumatoria;
		
		
	}
	/**Fin del metodo**/
	
	/**
	 * Calcula el valor de p
	 */
	private void calcularP(){//Declaracion metodo
		double sumatoriaAnterior = calcularSumatoria();
		double sumatoriaActual = calcularSumatoria();
		double diferencia = 1000;
		
		while (this.error < diferencia) {
			this.numeroSegmentos = this.numeroSegmentos * 2;
			sumatoriaActual = calcularSumatoria();
			diferencia = sumatoriaActual - sumatoriaAnterior;
		}
		
		this.p = sumatoriaActual;
		
	}
	/**Fin metodo**/
	
	/**
	 * Retorna el valor de p calculado
	 * @return Valor de p
	 */
	public double getP(){//Declaracion metodo
		return this.p;
	}
	/**Fin metodo**/	
}
