package logic;



public class User {

	

	private int userId;

	private String name;

	private String username;

	private String password;

	

	public User(int userId,String name, String username, String password) {

		this.userId = userId;

		this.name = name;

		this.username = username;

		this.password = password;

	}

	

	public int getUserId() {

		return userId;

	}

	public String getUsername() {

		return username;

	}

	public String getName() {

		return name;

	}

	public String getPassword() {

		return password;

	}

	public void setUserId(int userId) {

		this.userId = userId;

	}

	public void setName(String name) {

		this.name = name;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public void setPassword(String password) {

		this.password = password;

	}





	public String toString() {

		return "User [userId=" + userId + ",name="+name+", username=" + username + ", password=" + password + "]";

	}

	

	

	



}