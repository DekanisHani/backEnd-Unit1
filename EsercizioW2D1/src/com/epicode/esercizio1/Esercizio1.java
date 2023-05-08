package com.epicode.esercizio1;

import java.util.Scanner;
import java.util.Random;

public class Esercizio1 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[] arrInteri = numeriCasuali();
		stampaArray(arrInteri);
		leggiPosizione(arrInteri);
	}
	
	private static void leggiPosizione(int[] arr) {
		int numero, posizione;
		boolean continua = true;
		do {
			System.out.print("Inserisci un numero. 0 per uscire: ");
			numero = Integer.parseInt(sc.nextLine());
			if(numero!=0) {
				System.out.print("Inserisci la posizione da sostituire: ");
				posizione = Integer.parseInt(sc.nextLine());
				try {
					arr[posizione] = numero;
				stampaArray(arr);
				}catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Errore posizione: " + posizione);
				}catch (NumberFormatException e) {
					System.out.println("valore errato: " + posizione);
				}
				
			}else {
				continua = false;
			}
		} while (continua);
	}
	
	
	private static void stampaArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.println("numero "+ arr[j] + "indice " + j);
			}
	}
	
	private static int[] numeriCasuali() {
		int[] arr = new int [5];
		Random rand = new Random();
		for (int i = 0; i<arr.length; i++) {
			arr[i] = rand.nextInt(11);
		}
		return arr;
	}

}
