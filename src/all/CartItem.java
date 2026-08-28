package all;

public class CartItem {

	private Product product;
	private int quantity;
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public double calculateSubtotal() {
		return product.getPrices()*quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int checkStockQuantity() {
		return product.getStock_quantity();
	}
	
}
