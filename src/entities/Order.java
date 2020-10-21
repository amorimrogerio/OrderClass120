package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment; 
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order () {}
	
	public Order ( OrderStatus status, Client client) {
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void setClient ( Client client ) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void addItem (OrderItem item ) {
		items.add( item );
	}
	
	public void removeItem ( OrderItem item ) {
		items.remove( item );
	}
	
	public double total () {
		double sum=0;
		
		for ( OrderItem o : items ) {
			sum += o.subTotal();
		}
		return sum;
	}
	
	public void sumary() {
		SimpleDateFormat moment = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat dtBirth = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("");
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: "+ moment.format(this.moment));
		System.out.println("Order status: "+ this.status);
		System.out.println("Client: "+this.client.getName()+
				           " ("+dtBirth.format(this.client.getBirthDate())+") - "+
				             this.client.getEmail());
		System.out.println("Order items:");
		
		double sum=0;
		for ( OrderItem o : items) {
			double subtot = o.getProduct().getPrice() * o.getQuantity();
			sum+=subtot;
			System.out.printf(o.getProduct().getName()+", "+
					           "$ %.2f, "+
					           "Quantity: "+o.getQuantity()+", "+
					           "Subtotal: $ %.2f %n",o.getProduct().getPrice(),subtot);
		}
		System.out.printf("Total price: $ %.2f",sum);
		
		
	}

}
