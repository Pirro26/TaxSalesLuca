import java.util.ArrayList;
import java.util.Scanner;


public class StoreManager {
	
	private ArrayList<Product> purchasedProducts;
	private Scanner scan;
	private TaxManager taxManager = new TaxManager();
	
	public StoreManager(){
		this.purchasedProducts = new ArrayList<Product>();
		this.scan = new Scanner(System.in);
	}
	public ArrayList<Product> getPurchasedProducts() {
		return purchasedProducts;
	}
	public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}
	public void addProductToCart(String name, String type, boolean imported, double price){
		Product product = new Product(name, type, imported, price);
		this.purchasedProducts.add(product);
		System.out.println("\n*** product '"+ name + "' added to cart ***\n");
	}
	public void receiveOrders(){
		do{
			System.out.println("insert Product Name");
			String name = scan.next();
			
			System.out.println("insert Product Type ( book | medical | food | misc)");
			String type = getTypeProduct();
			
			System.out.println("is Product Imported? (y) or (n)");
			boolean isImported = isProductImported();
			
			System.out.println("insert Product Price");
			double price = scan.nextDouble();
			
			this.addProductToCart(name, type, isImported, price);
			
		}while(otherProduct());
	}
	public String getReceipt(){
		int i=0;
		String result = "--------------RECEIPT-------------- \n\n";
		for(Product p : this.purchasedProducts ){
			i++;
			result+="--item"+i+": ";
			result+= p.getName() + " - ";
			//result+= p.getType() + " - ";
			//result+= p.getOriginalPrice() + "€" + " --> ";
			result+= p.getFinalPrice()+ "€";
			result+="\n";
		}
		result+= "TOTAL:" + getTotalCostsPurchaseItems() + "€" ;
		result+= "\nTAX PAID:" + getTotalTaxPaid() + "€";
		result+= ("\n-----------------------------------\n");
		return result;
	}
	public void addTaxToPurchasedElements(){
		for(Product p : this.purchasedProducts){
			taxManager.setFinalPrice(p);
		}
	}
	
	private String getTypeProduct(){
		String type = "";
		boolean error = false;
		do{
			type = scan.next();
			if(type.equals("book")    || 
			   type.equals("medical") || 
			   type.equals("food")    || 
			   type.equals("misc")){
				return type;
			}else{
				System.out.println("\n Wrong Input! please insert correct info");
				error = true;
			}
		}while(error);
		
		return type;
	}
	private boolean isProductImported(){
		String answ = "";
		boolean error = false;
		boolean response = false;
		do{
			answ = scan.next();
			if(answ.equals("y") || answ.equals("Y")){
				response = true;
			} else 
			if(answ.equals("n") || answ.equals("N")){
				response = false;
			} else {
				System.out.println("wrong Input! please insert Right info!");;
				error = true;
			}
		}while(error);
		
		return response;
	}
	private boolean otherProduct(){
		boolean error = false;
		do {
				System.out.println("would you add other products ? (y) or (n)");
				String response = scan.next();

				
				
				if(response.equals("y") || response.equals("Y")){
					return true;
				}else 
				if(response.equals("n") || response.equals("N")){
					return false;
				}else {
					error = true;
				}
		}while(error);
		
		return false;
		
	}
	private double getTotalCostsPurchaseItems(){
		double total = 0;
		double rounded = 0;
		for(Product p : purchasedProducts){
			total+= p.getFinalPrice();
		}
		rounded = Math.round(total * 20.0) / 20.0;
		return rounded;
	}
	private double getTotalTaxPaid(){
		double totalTax = 0;
		double rounded = 0;
		for(Product p : purchasedProducts){
			totalTax+= (p.getFinalPrice() - p.getOriginalPrice());
		}
		 rounded = Math.round(totalTax * 20.0) / 20.0;
		return rounded;
	}
}
