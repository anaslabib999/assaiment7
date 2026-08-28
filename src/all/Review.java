package all;

public class Review {
	private int product_id; 
	private String customer_name;
	private String comment;
	
	public Review(int product_id, String customer_name, String comment) {
		super();
		this.product_id = product_id;
		this.customer_name = customer_name;
		this.comment = comment;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [product_id=" + product_id + ", customer_name=" + customer_name + ", comment=" + comment + "]";
	}
	
	
}
