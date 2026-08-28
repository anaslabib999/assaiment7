package all;

//import java.rmi.Remote;
import java.util.*;
import java.util.concurrent.ForkJoinTask;

import ENUMS.OrderStatus;

public class Order {
	private final int order_id;
	private String customer_name;
	private double total;
	private OrderStatus orderStatus;
	List <CartItem> cartItems = new ArrayList<>();
	public Order(int order_id, String customer_name) {
		this.order_id = order_id;
		this.customer_name = customer_name;
		this.total=0;
		this.orderStatus = OrderStatus.PENDING;
	}
	private int  findCartItem(int item_id) {
		for(int i = 0; i<cartItems.size();i++) {
			if(cartItems.get(i).getProduct().getId() == item_id) {
				return i;
			}
		}
		return -1 ;
	}
	private void calculateTotal() {
		double first_total =0;
		for(CartItem item : cartItems) {
			first_total += item.calculateSubtotal();
		}
		total = first_total;
	}

	public void addItem(CartItem cartItem) {
		if (orderStatus != OrderStatus.PENDING) {
		    System.out.println("You can only modify this order when it is PENDING.");
		    return;
		}
		int index = findCartItem(cartItem.getProduct().getId());

		if(index == -1) {
			cartItems.add(cartItem);
		}else {
			int fir_quantity= cartItems.get(index).getQuantity()+cartItem.getQuantity();
			cartItems.get(index).setQuantity(fir_quantity);
		}
		calculateTotal();
		
	}
	public void removeItem(int item_id) {
		if (orderStatus != OrderStatus.PENDING) {
		    System.out.println("You can only modify this order when it is PENDING.");
		    return;
		}
		int index = findCartItem(item_id);
		if(index == -1 ) {
			System.out.println("no matching id in your order");
			return;
		}
		cartItems.remove(index);
		System.out.println("remove is succsefull");
		calculateTotal();
	}
	
	public void updateStauts( int choice) {
	switch (choice) {
	 case 1:
	        orderStatus = OrderStatus.PENDING;
	        break;
	    case 2:
	        orderStatus = OrderStatus.SHIPPED;
	        break;
	    case 3:
	        orderStatus = OrderStatus.DELIVERED;
	        break;
	    case 4:
	        orderStatus = OrderStatus.CANCELLED;
	        break;
	    default:
	        System.out.println("Invalid choice.");
	        return;
	}
	 
	  System.out.println("Status updated to: " + orderStatus);

	}
	
	
	public void displayorder() {
		for(CartItem item : cartItems) {
			System.out.println(item.getProduct()+"-------->"+ item.getQuantity());
		}
		
		
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getOrder_id() {
		return order_id;
	}
	public double getTotal() {
		return total;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(order_id));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return order_id == other.order_id;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
	
	
	
	
	
	
	
	

