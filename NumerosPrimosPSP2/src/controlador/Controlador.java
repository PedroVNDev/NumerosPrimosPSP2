package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
	public static void main(String[] args) {

		// Numeros primos que vamos a sacar
		int limitePrimos = 9624;

		// Pedimos el numero de hilos que se van a utilizar
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cuantos hilos vas a usar?: ");
		int hilos = teclado.nextInt();

		// Establecemos el limite de numeros
		final Primo[] Hilosp = new Primo[hilos];
		long tiempo = System.currentTimeMillis();
		for (int x = 0; x < hilos; x++) {
			Hilosp[x] = new Primo();
			Hilosp[x].limite = 2 + 10000 * x;
			Hilosp[x].start();

		}

		// Inicializamos
		try {
			for (int x = 0; x < hilos; x++) {
				Hilosp[x].join();
				System.out.println("Hilo " + (x + 1) + "  Inicializado ");
			}

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		// Guardamos los primos sacados por los hilos en una lista
		List<Integer> numerosPrimos = new ArrayList<>();
		for (Primo p : Hilosp) {
			numerosPrimos.addAll(p.Listaprimos);
		}

		// Mostramos el arraylist

		for (int x = 0; x < limitePrimos; x++) {
			System.out.println(numerosPrimos.get(x));

		}

		long tiempoFin = System.currentTimeMillis();

		long totalTiempo = tiempoFin - tiempo;
		System.out.println("Tardo: " + totalTiempo + "  MiliSegundos En sacar los numeros");
		System.out.println("Se sacaron: " + limitePrimos + " Numeros primos");

	}
}