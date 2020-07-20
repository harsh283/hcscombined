package system.dao;

import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import system.beans.Appointment;
import system.beans.DiagnosticCenter;
import system.beans.Person;
import system.beans.Test;

public class Dao implements IDao {
	public static Random rand=new Random();
	public static HashMap<String,Person> userList=new HashMap<String,Person>();
	public static List<DiagnosticCenter> centerList=new ArrayList();
	public static HashMap<String,String> admins=getMap();
	public static DiagnosticCenter center;
	public static String appoint;
	public Dao()
	{
		super();
	DiagnosticCenter center = new DiagnosticCenter();
	center.setCenterId("101");
	center.setCenterName("Hyderabad");
	Test test1=new Test();
	test1.setTestId("1");
	test1.setTestName("Blood Perssure");
	Test test2=new Test();
	test2.setTestId("2");
	test2.setTestName("Blood Sugar");
	Test test3=new Test();
	test3.setTestId("3");
	test3.setTestName("Blood Group");
	center.setListOfTests(Arrays.asList(test1,test2,test3));
	Person person =new Person();
	person.setUserId("101");
	person.setPassword("Ilovemom@12");
	person.setUserMail("harssh1999@gmail.com");
	person.setUserName("Harshkumar");
	person.setUserRole("admin");
	Appointment appointment1=new Appointment();
	appointment1.setAppointmentId("1");
	appointment1.setDate(LocalDate.now());
	appointment1.setTest(test1);
	appointment1.setUserId(person);
	appointment1.setApproved(true);
	Appointment appointment2=new Appointment();
	appointment2.setAppointmentId("2");
	appointment2.setDate(LocalDate.now());
	appointment2.setTest(test2);
	appointment2.setUserId(person);
	appointment2.setApproved(false);
	center.setAppointmentList(Arrays.asList(appointment1,appointment2));
	Dao.centerList.add(center);
	DiagnosticCenter center1=new DiagnosticCenter();
	center1.setCenterId("102");
	center1.setCenterName("Narsapur");
	center1.setListOfTests(Arrays.asList(test1,test2,test3));
	center1.setAppointmentList(Arrays.asList(appointment1,appointment2));
	Dao.centerList.add(center1);
	}
	public static HashMap<String,String> getMap()
	{
	HashMap<String,String> map=new HashMap<String,String>();
	map.put("Harssh", "Ilovemom@12");
	map.put("Rjn", "chandu");
	return map;
	}
	public boolean addCenter(DiagnosticCenter center) {
		// TODO Auto-generated method stub
		int id=rand.nextInt(1000);
		center.setCenterId(String.valueOf(id));
		centerList.add(center);
		
		return true;
	}

	public boolean removeCenter(DiagnosticCenter center) {
		boolean flag=false;
		if(centerList.contains(center))
		{
		centerList.remove(center);
		flag= true;
		}
		else
			flag= false;
		return flag;
	}

	public String addTest(Test test) {
		test.setTestId(String.valueOf(rand.nextInt(100)));
		
		List<Test> testList1=new ArrayList<Test>();
		testList1.add(test);
		testList1.addAll(center.getListOfTests());
		center.setListOfTests(testList1);
		return test.getTestId()+" "+test.getTestName();
		
	}
	public boolean removeTest(Test test) {
		boolean flag=false;
		List<DiagnosticCenter> cen=new ArrayList();

		List<Test> t=new ArrayList<Test>();
		List<Test> tests=centerList.get(0).getListOfTests();
		if(center.getListOfTests().contains(test))
		{
			
			for (DiagnosticCenter diagnosticCenter : Dao.centerList) {
				if(center.equals(diagnosticCenter))
				{
					if(test.getTestId().equals(center.getListOfTests().get(0).getTestId()))
					{
						diagnosticCenter.getAppointmentList().remove(Arrays.asList(test));
						diagnosticCenter.getListOfTests().remove(Arrays.asList(test));
						System.out.println(diagnosticCenter);
					flag=true;
					break;
					}
				}
			}
			System.out.println(Dao.centerList);
			flag=true;
			
		}
		return flag;
	}
	public boolean approveAppointment() {
		int num=0;
	for (DiagnosticCenter diagnosticCenter : centerList) {
		if(diagnosticCenter.getAppointmentList().get(num).getAppointmentId().equals(appoint))
		{
			diagnosticCenter.getAppointmentList().get(num).setApproved(true);
			return true;
		}
		num++;
	}
		return false;
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
