package aplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		Scanner read = new Scanner( System.in );
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy")
		
		System.out.println("Enter client data:");
		System.out.println("------------------");
		System.out.println("Name: ");String name = read.nextLine();
		System.out.println("Email: ");String email = read.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");Date birthDate = sdf.parse(read.next());
		System.out.println("Enter order data:");
		System.out.println("-----------------");
		
		

		read.close();
	}

}
