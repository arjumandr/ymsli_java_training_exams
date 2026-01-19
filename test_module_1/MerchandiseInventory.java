package test_module_1;

import java.util.Comparator;

class MerchandiseIdComparator implements Comparator<MerchandiseInventory>{

	@Override
	public int compare(MerchandiseInventory o1, MerchandiseInventory o2) {
		return o1.getItemCode().compareToIgnoreCase(o2.getItemCode());
	}
	
}
class MerchandisePriceComparator implements Comparator<MerchandiseInventory>{

	@Override
	public int compare(MerchandiseInventory o1, MerchandiseInventory o2) {
		return Double.compare(o2.getUnitPrice(), o1.getUnitPrice());
	}
	
}

public class MerchandiseInventory {
	private String itemCode;
	private int quantity;
	private double unitPrice;
	public MerchandiseInventory(String itemCode, int quantity, double unitPrice) {
		super();
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "MerchandiseInventory [itemCode=" + itemCode + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ "] \n";
	}
	
	
}
