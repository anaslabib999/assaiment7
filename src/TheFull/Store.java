package TheFull;

import java.lang.ScopedValue.Carrier;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import ENUMS.OrderStatus;
import all.CartItem;
import all.Order;
import all.Product;
import all.Review;

public class Store {
	LinkedHashMap<Integer, Product> products = new LinkedHashMap<>();
	HashMap<Integer, Order> orders = new HashMap<>() ;
	Set<String> categorys = new HashSet<>();
	Queue<Order> shiping_orders = new ArrayDeque<>();
	LinkedHashMap<Integer, Order> deleverd_orders = new LinkedHashMap<>();
	List<Review> reviews = new ArrayList<>();
	
	private void removeProductFromEveryWher(int product_id) {
		products.remove(product_id);
	}
	public void addProduct(int id, String name, double price, String category, int stock_quantity) {
		Product product = new Product(id, name, price, category, stock_quantity);
		if(products.containsKey(product.getId())) {
			System.out.println("the product already found or problem with the id");
			return;
		}
		products.put(product.getId(), product);
		categorys.add(category);
		
		
	}
	public void removeProduct(int product_id) {
		if(products.isEmpty()) {
			System.out.println("thier is no product add to the store yet");
			return;
		}
		if(!products.containsKey(product_id)) {
			System.out.println("the proeduct not found pleas check id id");
			return;
		}
		removeProductFromEveryWher(product_id);
	}
	public void DisplayAllProducts() {
		if(products.isEmpty()) {
			System.out.println("thier is no product add to the store yet");
			return;
		}
		for(Product p : products.values()) {
			System.out.println(p);
		}
	}
	public void SearchProductByID(int product_id) {
		if(products.isEmpty()) {
			System.out.println("thier is no product add to the store yet");
			return;
		}
		if(!products.containsKey(product_id)) {
			System.out.println("the proeduct not found pleas check id id");
			return;
		}else {
			System.out.println(products.get(product_id));
		}
	}
	public void ShowAllCategories() {
		for(String str : categorys) {
			System.out.println(str);
		}
	}
	public void DisplayProductsOrderedByPrice() {
		if(products.isEmpty()) {
			System.out.println("thier is no product add to the store yet");
			return;
		}
		List<Product> sorted_products = new ArrayList<>(products.values());
		Collections.sort(sorted_products);
		for(Product p : sorted_products) {
			System.out.println(p);
		}
		
		
	}
	public void createOrder(int order_id,String customar_name  ) {
		Order order = new Order(order_id, customar_name);
		if(orders.containsKey(order.getOrder_id())) {
			System.out.println("this oredr already exist pleas enter the corect id");
			return;
		}
		orders.put(order.getOrder_id(), order);
	}
	public void AddItemTorder(int order_id,int product_id,int quantity) {
		if(quantity <=0) {
			System.out.println("the quantity must be biggier than 0 ");
			return;
		}
		if( !orders.containsKey(order_id)) {
			System.out.println("pleas check if you oredr exist in the system");
			return;
		}
		if(! products.containsKey(product_id)) {
			System.out.println("pleas check if you product exist in the system");
			return;
		}
		if(products.get(product_id).getStock_quantity()<quantity) {
			System.out.println("thier is no anuf stock left from this preoduct");
			return;
		}
		CartItem cartItem = new CartItem(products.get(product_id), quantity);
		orders.get(order_id).addItem(cartItem);
		System.out.println("item add it succsefull");
		products.get(product_id).setStock_quantity(products.get(product_id).getStock_quantity()-quantity);
		
	
	}
	public void RemoveItemFromOrder(int order_id,int product_id ) {
		if( !orders.containsKey(order_id)) {
			System.out.println("pleas check if you oredr exist in the system");
			return;
		}
		orders.get(order_id).removeItem(product_id);
	}
	public void DisplayOrder(int order_id) {
		if( !orders.containsKey(order_id)) {
			System.out.println("pleas check if you oredr exist in the system");
			return;
		}
		orders.get(order_id).displayorder();
	}
	public void AddOrderToTheShippingList(int order_id) {
		if( !orders.containsKey(order_id)) {
			System.out.println("pleas check if you oredr exist in the system");
			return;
		}
		Order ore = orders.get(order_id);
		if( ore.getOrderStatus()== OrderStatus.SHIPPED ||ore.getOrderStatus()== OrderStatus.DELIVERED) {
			System.out.println("you oredr already is shipped alredy ones");
			return;
		}
		if(ore.getCartItems().isEmpty()|| ore.getOrderStatus()== OrderStatus.CANCELLED) {
			System.out.println("you oredr is empty of items  or it is alredy canceld ");
			return;
		}
		shiping_orders.offer(ore);
		ore.setOrderStatus(OrderStatus.SHIPPED);
		
	}
	public void ShipNextOrder() {
		if(shiping_orders.isEmpty()) {
			System.out.println("their is no oredrs ready to be shieped yet");
			return;
		}
		if(shiping_orders.peek().getCartItems().isEmpty()) {
			System.out.println("this order is hase no cart item plaes add it to it first");
			return;
		}
		Order order=shiping_orders.poll();
		order.setOrderStatus(OrderStatus.DELIVERED);
		orders.get(order.getOrder_id()).setOrderStatus(OrderStatus.DELIVERED);
		if(!deleverd_orders.containsKey(order.getOrder_id())) {
			deleverd_orders.putIfAbsent(order.getOrder_id(), order);
		}else {
			System.out.println("your order is alredy deleverd");
			return;
		}
		
		
	}
	public void CancelOrder(int order_id) {
		if(!orders.containsKey(order_id)) {
			System.out.println("order no found");
			return;
		}
		if(orders.get(order_id).getOrderStatus() == OrderStatus.CANCELLED||orders.get(order_id).getOrderStatus() == OrderStatus.DELIVERED) {
			System.out.println("your order is already cnasseled or deleverded");
			return;
		}
		orders.get(order_id).setOrderStatus(OrderStatus.CANCELLED);
		shiping_orders.remove(orders.get(order_id));
		
	}
	public void SearchOrderByID(int order_id) {
		if(orders.containsKey(order_id)) {
			System.out.println(orders.get(order_id));
		}else {
			System.out.println("your order not found pleas entert the corect id");
		}
		
	}
	public void AddReviewToAProduct(int product_id) {
		Scanner scanner = new Scanner(System.in);
		if(!products.containsKey(product_id)) {
			System.out.println("product not found pleas enter the corect id");
			return;
		}
		String name = scanner.next();
		String comment = scanner.next();
		Review review =new Review(product_id, name, comment);
		reviews.add(review);
	}
	public void ShowAllReviewsForAProduct(int product_id) {
		for(Review review : reviews) {
			if(review.getProduct_id() == product_id)
			System.out.println(review);
		}
		
	}
	public void RemoveOutOfStockProducts() {
		Iterator<Map.Entry<Integer, Product>> iterator = products.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Product> entry = iterator.next(); 
			if(entry.getValue().getStock_quantity()<=0) {
				System.out.println("this "+ entry.getValue() +"is out from stock so it will be delet it");
				iterator.remove();
			}
			
		}
		
	}
	public void DisplayOrdersOrderedByTotal() {
		List<Order> total_sordet_products = new ArrayList<>(orders.values());
		total_sordet_products.sort(Comparator.comparing(Order :: getTotal));
		for(Order order : total_sordet_products) {
			System.out.println(order);
		}

	}
	
	
	
	
	
	
	
	
	
	
	

}

