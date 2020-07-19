package system.service;

import java.time.LocalDate;

import system.beans.DiagnosticCenter;
import system.beans.Person;
import system.beans.Test;

public interface IService {
	public boolean addCenter(DiagnosticCenter center);
	public boolean removeCenter(DiagnosticCenter center);
	public String addTest(Test test);
	public boolean approveAppointment();
	public String makeAppointment(Person person,DiagnosticCenter center,Test test,LocalDate date);
	public String registerUser(Person person);
	public boolean removeTest(Test test);

}
