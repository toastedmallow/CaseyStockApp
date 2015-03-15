package cs3750.stock.app.model;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private double balance;
	private String username;
	
	public User(){
		
	}
	
	public User(String firstName, String lastName, String username, double balance, int userId){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.balance = balance;
		this.userId = userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getUsername(){
		return username;
	}
	
}
