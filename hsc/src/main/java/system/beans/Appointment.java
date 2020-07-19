package system.beans;

import java.time.LocalDate;

public class Appointment {

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
private Person person;
private String appointmentId;
private Test test;
private boolean approved;
private LocalDate date;
public Appointment(Person person, String appointmentId, Test test, boolean approved,
		LocalDate date) {
	super();
	this.person = person;
	this.appointmentId = appointmentId;
	this.test = test;
	this.approved = approved;
	this.date = date;
}
public Person getPerson() {
	return person;
}
public void setUserId(Person person) {
	this.person = person;
}
public String getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(String appointmentId) {
	this.appointmentId = appointmentId;
}
public Test getTest() {
	return test;
}
public void setTest(Test test) {
	this.test = test;
}
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}

public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
@Override
public String toString() {
	return "Appointment [person=" + person + ", appointmentId=" + appointmentId + ", test=" + test + ", approved="
			+ approved + ", date=" + date + "]";
}


}
