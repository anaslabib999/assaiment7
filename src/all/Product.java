package all;

//import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

public class Product implements Comparable<Product> {
	
	private final int id;
	private String name;
	private double prices;

	private String catogory;
	private int stock_quantity;
	public Product(int id, String name, double prices, String catogory, int stock_quantity) {
		this.id = id;
		this.name = name;
		this.prices = prices;
		this.catogory = catogory;
		this.stock_quantity = stock_quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}
	public String getCatogory() {
		return catogory;
	}
	public void setCatogory(String catogory) {
		this.catogory = catogory;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", prices=" + prices + ", catogory=" + catogory
				+ ", stock_quantity=" + stock_quantity + "]";
	}
	@Override
	public int compareTo(Product o) {
		
		return Double.compare(this.prices,o.prices);

	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Integer.hashCode(id);
	}
	@Override
	public boolean equals(Object obj) {
		Product product =  (Product)obj;
		return this.id == product.id ;
		
	}
	
	


	
	

}
