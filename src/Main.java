
public class Main {

	public static void main(String[] args) {
		
		StoreManager storeManager = new StoreManager();
		
		storeManager.receiveOrders();
		storeManager.addTaxToPurchasedElements();
		String receiptString = storeManager.getReceipt();
		System.out.println(receiptString);
		System.out.println("\n \n  *** END OF PROGRAM  ***");
	}

}
