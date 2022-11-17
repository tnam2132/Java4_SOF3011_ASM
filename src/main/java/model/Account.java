package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column(length = 50, nullable = false)
	private String hoten;
	
	@Column(length = 16, nullable = true)
	private String password;
	
	@Column(nullable = true)
	private AccountRole role;

	public Account() {

	}

	public Account(Integer id, String username, String hoten, String password, AccountRole role) {
		this.id = id;
		this.username = username;
		this.hoten = hoten;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountRole getRole() {
		return role;
	}

	public void setRole(AccountRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", hoten=" + hoten + ", password=" + password
				+ ", role=" + role + "]";
	}
	

	
}
