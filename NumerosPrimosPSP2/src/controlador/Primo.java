package controlador;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primo extends Thread {
	public int contador = 0;
	public int limite;
	public ArrayList<Integer> Listaprimos = new ArrayList<>();

	// Sacamos los numeros primos y los guardamos en el arraylist
	public void run() {
		for (int x = limite; x <= limite + 110000; x++) {
			BigInteger primo = BigInteger.valueOf(x);
			if (primo.isProbablePrime(1)) {
				contador++;
				Listaprimos.add(x);
			}
		}
	}
}