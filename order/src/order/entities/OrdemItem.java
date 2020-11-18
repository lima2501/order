package order.entities;

public class OrdemItem {

	private Integer Quantity;
	private Double price;
	private Product product;

	public OrdemItem() {

	}

	public OrdemItem(Integer quantity, Product product) {
		Quantity = quantity;
		this.price = product.getPrice();
		this.product = product;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	// Métodos
		public double subTotal() {
			return Quantity * price;
		}

}
