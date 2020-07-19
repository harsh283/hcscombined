package system.dao;

import java.time.LocalDate;

import system.beans.DiagnosticCenter;
import system.beans.Person;
import system.beans.Test;

public interface IDao {
	public boolean addCenter(DiagnosticCenter center);
	public boolean removeCenter(DiagnosticCenter center);
	public boolean removeTest(Test test);
	public String addTest(Test test);
	public boolean approveAppointment();
	public String makeAppointment(Person person,DiagnosticCenter center,Test test,LocalDate date);
	public String registerUser(Person person);

}
