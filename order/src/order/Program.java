package order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import order.entities.Client;
import order.entities.OrdemItem;
import order.entities.Order;
import order.entities.Product;
import order.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String name = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Data de nascimento (DD/MM/AAAA): ");
		Date birthDate = sdf.parse(scan.next());
		scan.nextLine();
		System.out.println("Entre com os dados do pedido");
		System.out.print("Status: ");
		String status = scan.nextLine();
		status = status.toUpperCase();
		
		Order order = new Order(OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		System.out.print("Quantos items vai ter no pedido? ");
		int n = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < n; i++) {
			System.out.println("Entre com dos dados do pedido #" + (i+1));
			System.out.print("Nome do produto: ");
			String productName = scan.nextLine();
			System.out.print("Preço do produto R$: ");
			Double productPrice = scan.nextDouble();
			System.out.print("Quantidade: ");
			Integer quantity = scan.nextInt();
			scan.nextLine();
			
			OrdemItem item = new OrdemItem(quantity, new Product(productName, productPrice));
			
			order.addItem(item);
			
		}
		
		System.out.println(order);
		
		scan.close();
	}
	
}
