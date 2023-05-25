package imc_Array;
import javax.swing.JOptionPane;

public class Imc_Array {

		

	String nombres[];
	String telefono[];
	Double imcArray[];
	String resultadoImc[];

	
	public void menu() {
		
		int opcion = 0;

		
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción\n"
					+ "1.registrar\n" 
					+ "2.imprimir\n" 
					+ "3.salir\n\n"));

			proceso(opcion);
		}while(opcion != 3);
		
		
		
	}

	public void proceso(int opcion) {
		switch (opcion) {
		case 1:
			pedirDatos();
			break;
		case 2:
			imprimirDatos();
			break;
		case 3:
			salir();
			break;
		default:
			System.out.println("Opción incorrecta");
			break;
		}

	}
	
	public void pedirDatos() {
		
		double peso = 0;
		double altura = 0;
		
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de personas a registrar: "));
		
		nombres = new String[cantidad];
		telefono = new String[cantidad];
		resultadoImc = new String[cantidad];
		imcArray= new Double[cantidad];
		
		double imc = 0;
		
		String resultado;
		
		for (int i = 0; i < cantidad; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese su nombre: ");
			telefono[i] = JOptionPane.showInputDialog("Imgrese su número de telefono:");
			peso = Double.parseDouble(JOptionPane.showInputDialog("ingrese su peso: "));
			altura = Double.parseDouble(JOptionPane.showInputDialog("ingrese su altura: "));
			
			imc = obtenerImc(peso, altura);
			
			imcArray[i]=imc;
			
			resultado = obtenerResultado(imc);
			
			resultadoImc[i] = resultado;
			
		}
		
	}


	private void imprimirDatos() {
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("El nombre de la persona es: " +nombres[i] +
					"\n El N.telefonico es: "+ telefono[i] + "\n El resultado del examen es:"+ resultadoImc[i]+ "\n El IMC es: "+imcArray[i]);
		}
		
	}
	
	
	private void salir() {
		System.out.println("Gracias por usar nuestro programa");
		
		
	}


	private String obtenerResultado(double imc) {

		String resultado = "";

		if (imc < 18) {
			resultado = "Anorexia";
		} else if (imc >= 18 && imc < 20) {
			resultado = "Delgades";
		} else if (imc >= 20 && imc < 27) {
			resultado = "Normalidad";
		} else if (imc >= 27 && imc < 30) {
			resultado= "Obesidad grado 1";
		} else if (imc >= 30 && imc < 35) {
			resultado= "Obesidad grado 2";
		} else if (imc >= 35 && imc < 40) {
			resultado= "Obesidad grado 3";
		} else {
			resultado= "Obesidad morbida";
		}

		return resultado;

	}


	private double obtenerImc(double peso, double altura) {

		double imc = 0;

		imc = peso / (altura * altura);

		return imc;

	}

}
