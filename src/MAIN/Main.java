package MAIN;

import java.util.Scanner;

import TheFull.Store;

public class Main {

	public static void main(String[] args) {
		 Store store = new Store();
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	

	        do {
	            System.out.println("1.  Add Product");
	            System.out.println("2.  Remove Product");
	            System.out.println("3.  Display All Products");
	            System.out.println("4.  Search Product by ID");
	            System.out.println("5.  Show All Categories");
	            System.out.println("6.  Display Products Ordered by Price");
	            System.out.println("7.  Create Order");
	            System.out.println("8.  Add Item to Order");
	            System.out.println("9.  Remove Item from Order");
	            System.out.println("10. Display Order");
	            System.out.println("11. Add Order to the Shipping List");
	            System.out.println("12. Ship Next Order");
	            System.out.println("13. Cancel Order");
	            System.out.println("14. Search Order by ID");
	            System.out.println("15. Add Review to a Product");
	            System.out.println("16. Show All Reviews for a Product");
	            System.out.println("17. Remove Out-of-Stock Products");
	            System.out.println("18. Display Orders Ordered by Total");
	            System.out.println("19. Exit");
	            System.out.print("Enter your choice (1-19): ");

	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    
	                    System.out.print("enter product id: ");
	                    int product_id = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.print("enter product Name: ");
	                    String product_name = scanner.nextLine();
	                    System.out.print("enter product: ");
	                    double product_price = scanner.nextDouble();
	                    scanner.nextLine();
	                    System.out.print("enter Category: ");
	                    String product_category = scanner.nextLine();
	                    System.out.print("enter stock quantity: ");
	                    int stock_quantity = scanner.nextInt();
	                    scanner.nextLine();

	                    store.addProduct(product_id, product_name, product_price, product_category, stock_quantity);
	                    break;

	                case 2:
	                    System.out.print("enter product id  ");
	                    int remove_product_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.removeProduct(remove_product_id);
	                    break;

	                case 3:
	                    store.DisplayAllProducts();
	                    break;

	                case 4:
	                    System.out.print("enter product id: ");
	                    int search_product_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.SearchProductByID(search_product_id);
	                    break;

	                case 5:
	                    store.ShowAllCategories();
	                    break;

	                case 6:
	                    store.DisplayProductsOrderedByPrice();
	                    break;

	                case 7:
	                    System.out.print("enter order id: ");
	                    int order_id = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.print("enter customer name: ");
	                    String customer_name = scanner.nextLine();
	                    store.createOrder(order_id, customer_name);
	                    break;

	                case 8:
	                    System.out.print("enter order id: ");
	                    int add_order_id = scanner.nextInt();
	                    System.out.print("enter Product id: ");
	                    int add_product_id = scanner.nextInt();
	                    System.out.print("enter qantity: ");
	                    int item_quantity = scanner.nextInt();
	                    scanner.nextLine();
	                    store.AddItemTorder(add_order_id, add_product_id, item_quantity);
	                    break;

	                case 9:
	                    System.out.print("enter order id: ");
	                    int remove_order_id = scanner.nextInt();
	                    System.out.print("enter product id to remove: ");
	                    int remove_item_product_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.RemoveItemFromOrder(remove_order_id, remove_item_product_id);
	                    break;

	                case 10:
	                    System.out.print("enter order id ");
	                    int display_order_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.DisplayOrder(display_order_id);
	                    break;

	                case 11:
	                    System.out.print("Enter Order ID: ");
	                    int ship_order_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.AddOrderToTheShippingList(ship_order_id);
	                    break;

	                case 12:
	                    store.ShipNextOrder();
	                    break;

	                case 13:
	                    System.out.print("enter order id: ");
	                    int cancel_order_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.CancelOrder(cancel_order_id);
	                    break;

	                case 14:
	                    System.out.print("enter order id: ");
	                    int search_order_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.SearchOrderByID(search_order_id);
	                    break;

	                case 15:
	                    System.out.print("enter product id: ");
	                    int review_product_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.AddReviewToAProduct(review_product_id);
	                    break;

	                case 16:
	                    System.out.print("enter product id ");
	                    int show_review_product_id = scanner.nextInt();
	                    scanner.nextLine();
	                    store.ShowAllReviewsForAProduct(show_review_product_id);
	                    break;

	                case 17:
	                    store.RemoveOutOfStockProducts();
	                    break;

	                case 18:
	                    store.DisplayOrdersOrderedByTotal();
	                    break;

	                case 19:
	                    System.out.println("\nThank you for using the E-Commerce ");
	                    break;

	                default:
	                    System.out.println("Invalid choice the chioesw is starting with 1 and end to  19.");
	            }

	        } while (choice != 19);

	        
	    }

	}


