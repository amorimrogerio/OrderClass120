package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Start {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner( System.in );
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.println("------------------");
		System.out.print("Name: ");String name = read.nextLine();
		System.out.print("Email: ");String email = read.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(read.next());
		
		Client client = new Client(name, email, birthDate);
		
		//System.out.println("");
		System.out.println("Enter order data:");
		//System.out.println("-----------------");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(read.next());
		
		Order order = new Order(status, client);		
		
		System.out.print("How many items to this order? ");
		int qtdItem = read.nextInt();
				
		for (int c=1 ; c<= qtdItem ; c++) {
			System.out.println("Enter # "+ c + " item data:");
			System.out.print("Product name: ");
			read.nextLine();
			String productName = read.nextLine();
			System.out.print("Product price: ");
			double price = read.nextDouble();
			System.out.print("Quantity: ");
			int quantity = read.nextInt();
			
			Product product = new Product(productName, price);
			OrderItem item = new OrderItem(quantity, price, product);
			
			order.addItem(item);
		}
		
		order.sumary();
		
		
		/*
		SimpleDateFormat moment = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: "+moment.format(order.getMoment()));
		System.out.println("Order status: "+order.getStatus());
		System.out.println("Client: "+order.getClient().getName()+
				           " ("+sdf.format(order.getClient().getBirthDate()+")")+
				           " - "+order.getClient().getEmail());
		System.out.println("Order items:");
		*/
		
		
		

		read.close();
	}

}
