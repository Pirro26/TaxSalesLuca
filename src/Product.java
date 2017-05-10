
public class Product {
	
	private String name;
	private String type;
	private boolean imported;
	private double originalPrice;
	private double finalPrice; 
	
	public Product(String name,String type, boolean imported, double originalPrice){
		this.setName(name);
		this.setType(type);
		this.setImported(imported);
		this.setOriginalPrice(originalPrice);
		this.setFinalPrice(0);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getProductSpecs(){
		String result= "";
		result+= "nome:" + this.name + "--";
		result+= "tipologia:" + this.type + "--";
		result+= "prezzo:" + this.originalPrice;
		
		return result;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}

	
	
	
	
}
