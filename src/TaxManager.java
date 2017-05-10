
public class TaxManager {
	
	private static final double BASIC_TAX=0.10;
	private static final double IMPORTED_TAX=0.05;
	
	public void setFinalPrice(Product p){
		addBasicTaxToProduct(p);
		addImportedTaxToProduct(p);
		roundsTaxValue(p);
	}
	
	private void roundsTaxValue(Product p){
		double rounded = Math.round(p.getFinalPrice() * 20.0) / 20.0;
		p.setFinalPrice(rounded);
	}
	private void addBasicTaxToProduct(Product p){
		if(p.getType().equals("book") || p.getType().equals("food") || p.getType().equals("medical")){
			p.setFinalPrice(p.getOriginalPrice());
		} else {
			p.setFinalPrice(p.getOriginalPrice()+(p.getOriginalPrice()*BASIC_TAX));
		}
	}
	private void addImportedTaxToProduct(Product p){
		if(p.isImported()){
			p.setFinalPrice(p.getFinalPrice() + (p.getOriginalPrice()*IMPORTED_TAX));
		}
	}
}
