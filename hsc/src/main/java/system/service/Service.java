package system.service;

import java.time.LocalDate;

import system.beans.DiagnosticCenter;
import system.beans.Person;
import system.beans.Test;
import system.dao.Dao;
import system.dao.IDao;

public class Service implements IService {

IDao dao=new Dao();	

	public boolean addCenter(DiagnosticCenter center) {
		// TODO Auto-generated method stub
		
		return dao.addCenter(center) ;
	}

	public boolean removeCenter(DiagnosticCenter center) {
		// TODO Auto-generated method stub
		return dao.removeCenter(center);
	}
	public boolean removeTest(Test test) {
		// TODO Auto-generated method stub
		return dao.removeTest(test);
	}

	public String addTest(Test test) {
		// TODO Auto-generated method stub
		return dao.addTest(test);
	}

	public boolean approveAppointment() {
		// TODO Auto-generated method stub
		
		return dao.approveAppointment();
	}

	public String makeAppointment(Person person, DiagnosticCenter center, Test test, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	public String registerUser(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
