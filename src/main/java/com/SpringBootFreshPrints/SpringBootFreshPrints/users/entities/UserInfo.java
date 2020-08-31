package com.SpringBootFreshPrints.SpringBootFreshPrints.users.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USER_INFO")
public class UserInfo {

	@Id
	@Column(name="user_name")
	private String userName;

	@Column(name="password")
	private String password;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="phone_no")
	private long phoneNo;
	
	@Column(name="email")
	private String email;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String userName, String password, String fullName,long phoneNo,String email) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
