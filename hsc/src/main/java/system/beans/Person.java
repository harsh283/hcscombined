package system.beans;

import java.util.HashMap;
import java.util.List;

public class Person {
private String userId;
//private List<DiagnosticCenter> centerList;
private String password;
private String userName;
private String userRole;
private String userMail;
public Person() {
	super();
	// TODO Auto-generated constructor stub
}
public Person(String userId,  String password, String userName, String userRole,
		String userMail) {
	super();
	this.userId = userId;
	//this.centerList = centerList;
	this.password = password;
	this.userName = userName;
	this.userRole = userRole;
	this.userMail = userMail;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
//public List<DiagnosticCenter> getCenterList() {
	//return centerList;
//}
//public void setCenterList(List<DiagnosticCenter> centerList) {
//	this.centerList = centerList;
//}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public String getUserMail() {
	return userMail;
}
public void setUserMail(String userMail) {
	this.userMail = userMail;
}
@Override
public String toString() {
	return "Person [userId=" + userId + " password=" + password + ", userName="
			+ userName + ", userRole=" + userRole + ", userMail=" + userMail + "]";
}

}
