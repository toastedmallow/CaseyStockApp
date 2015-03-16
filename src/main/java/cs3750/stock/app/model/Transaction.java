package cs3750.stock.app.model;

public class Transaction implements java.io.Serializable{
	private Integer	trans_id;
	private Integer stck_id;
	private Integer user_id;
	private Integer stck_qnty;
	
	public Integer getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}
	public Integer getStck_id() {
		return stck_id;
	}
	public void setStck_id(Integer stck_id) {
		this.stck_id = stck_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getStck_qnty() {
		return stck_qnty;
	}
	public void setStck_qnty(Integer stck_qnty) {
		this.stck_qnty = stck_qnty;
	}
	
}
