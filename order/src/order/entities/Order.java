package order.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import order.enums.OrderStatus;

public class Order {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private final static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrdemItem> items = new ArrayList<>();

	public Order() {
		super();
	}

	public Order(OrderStatus status, Client client) {
		super();
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrdemItem> getItems() {
		return items;
	}

	// Métodos
	public void addItem(OrdemItem item) {
		items.add(item);
	}

	public void removeItem(OrdemItem item) {
		items.remove(item);
	}

	public double total() {
		double sum = 0;

		for (OrdemItem item : items) {
			sum += item.subTotal();
		}

		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Sumário do pedido\n");
		sb.append("Momento do pedido: " + sdf2.format(getMoment()) + "\n");
		sb.append("Status do pedido: " + getStatus() + "\n");
		sb.append("Cliente: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		sb.append("Items do pedido:\n");
		for(OrdemItem item : items) {
			sb.append(item.getProduct().getName() + ", R$");
			sb.append(item.getProduct().getPrice() + ", Quantity: ");
			sb.append(item.getQuantity() + ", Subtotal: R$" + item.subTotal() + "\n");
			sb.append("Preço total R$: " + total());
		}
		
		return sb.toString();
	}

}
