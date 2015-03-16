package cs3750.stock.app.model;

public class Stock {
	private Integer stck_id;
	private String stck_symbl;
	private double stck_price;
	
	public Integer getStck_id() {
		return stck_id;
	}
	public String getStck_symbl() {
		return stck_symbl;
	}
	public void setStck_symbl(String stck_symbl) {
		this.stck_symbl = stck_symbl;
	}
	public double getStck_price() {
		return stck_price;
	}
	public void setStck_price(double stck_price) {
		this.stck_price = stck_price;
	}
	public void setStck_id(Integer stck_id) {
		this.stck_id = stck_id;
	}
}
