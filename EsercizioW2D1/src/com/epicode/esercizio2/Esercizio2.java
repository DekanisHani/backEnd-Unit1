package com.epicode.esercizio2;

import java.util.Scanner;

public class Esercizio2 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Inserire i km: ");
		int kmPercorsi =Integer.parseInt(sc.nextLine());
		System.out.print("Inserire il consumo: : ");
		int consumo =Integer.parseInt(sc.nextLine());
		
		try {
			int distanza = kmPercorsi/consumo;
		System.out.println("Consumi " + distanza + " km al litro");
		}catch(ArithmeticException e) {
			System.out.println("Nessun consumo, errore.");
		}catch (Exception e) {
			System.out.println("ERRORE!");
		}
		
		

	}

}
