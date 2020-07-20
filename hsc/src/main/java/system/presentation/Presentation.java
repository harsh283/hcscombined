package system.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import system.beans.DiagnosticCenter;
import system.beans.Test;
import system.dao.Dao;
import system.exception.InvalidCenterNameException;
import system.service.IService;
import system.service.Service;

public class Presentation {
	public static Scanner scan;
	public static IService service = new Service();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {

			int choice = 0;
			boolean flag = false;
			do {
				scan = new Scanner(System.in);
				System.out.println("Welcome to HCS");
				System.out.println("Press 1 for Admin");
				System.out.println("Press 2 for customer");
				try {
					choice = scan.nextInt();
					flag = true;
				} catch (InputMismatchException e) {
					// TODO: handle exception
					flag = false;
					System.out.println("Enter valid Digit");
				}

			} while (!flag);
			int choice1 = 0;
			switch (choice) {
			case 1:
				System.out.println("Please enter your credentials below");
				System.out.println("Enter the name");
				String name = scan.next();
				System.out.println(Dao.admins);
				System.out.println("Enter the password");
				String password = scan.next();
				flag = false;
				if (Dao.admins.containsKey(name) && Dao.admins.containsValue(password)) {

					do {
						System.out.println("Enter your choice in the digits 1-5 ");
						System.out.println("1.Add Center");
						System.out.println("2.Add Test");
						System.out.println("3.Remove Center");
						System.out.println("4.Remove Test");
						System.out.println("5.Approve Appointment");
						try {
							choice1 = scan.nextInt();
							flag = true;
						} catch (InputMismatchException e) {
							// TODO: handle exception
							flag = false;
							System.out.println("Enter digits from above provided");
						}
						break;
					} while (!flag);

				}

			}
			switch (choice1) {
			case 1:
				addCenter();
				break;
			case 2:
				addTest();
				break;
			case 3:
				removeCenter();
				break;
			case 4:
				removeTest();
				break;
			case 5:
				try {
					approveAppointment();
				} catch (InvalidCenterNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private static void addCenter() {
		DiagnosticCenter center1 = new DiagnosticCenter();
		System.out.println("Enter the center name to be added");
		String name = scan.next();
		center1.setCenterName(name);
		center1.setListOfTests(Dao.centerList.get(0).getListOfTests());
		service.addCenter(center1);
		System.out.println("Center with id " + center1.getCenterId() + " added Successfully");
		System.out.println(Dao.centerList);

	}

	private static void addTest() {
		Test test = new Test();
		boolean flg = false;
		// System.out.println("Enter the center id of the center where the tests have to
		// be added");
		System.out.println("List Of centers of HCS");
		for (DiagnosticCenter center : Dao.centerList) {
			System.out.println(center.getCenterId() + " ---------------" + center.getCenterName());
		}

		do {
			System.out.println("Enter the Test name of the test to be added");
			String name = scan.next();
			test.setTestName(name);

			System.out.println("Choose the center Id of the corresponding center where the test is to be added");
			String id = scan.next();

			for (DiagnosticCenter center : Dao.centerList) {
				if (center.getCenterId().equals(id)) {
					Dao.center = center;
					System.out.println(service.addTest(test));
					flg = true;
					break;
				}

			}
			if (!flg) {
				System.err.println("Enter the valid centerID");
			}
		} while (!flg);
	}

	public static void removeCenter() {
		DiagnosticCenter center = null;
	
		boolean flg = false;
	
		do {
			System.out.println("Enter the center Id of the center");
			String id = scan.next();
			for (DiagnosticCenter iterable_element : Dao.centerList) {
				if (iterable_element.getCenterId().equals(id)) {
					center = iterable_element;
					
					break;
				}
			}
			if (service.removeCenter(center)) {
				System.out.println("Center removed");
				System.out.println(Dao.centerList);
				flg = true;
			} else {
				System.out.println("Enter valid Id");
				flg=false;
				break;
			}
		} while (!flg);

	}
	public static void removeTest()
	{
		scan=new Scanner(System.in);
	
		Test test=null;
		boolean flag=false;
		System.out.println("Enter the center id ");
		String cId=scan.next();
		for (DiagnosticCenter center : Dao.centerList) {
			if(center.getCenterId().equals(cId))
			{
				Dao.center=center;
				flag=true;
				break;
			}
		}
		boolean internalFlag=false;
		if(flag)
		{
		System.out.println("The List of tests in this center are "+Dao.center.getListOfTests());
		System.out.println("Enter the Test  which is to be deleted");
		String id = scan.next();
		for (Test tests: Dao.center.getListOfTests()) {
			if(tests.getTestId().equals(id))
			{
				test=tests;
				internalFlag=true;
				break;
			}
			}
		if(internalFlag==true)
		{
			if(service.removeTest(test))
			System.out.println("Test removed successfully "+Dao.centerList);
			else
				System.out.println("Hello"); 
		}
		else
		{
			System.out.println(Dao.center.getListOfTests());
			System.out.println(internalFlag);
			System.out.println("Enter the valid name of the test");
		}
		
	}
		
}

	private static void approveAppointment() throws InvalidCenterNameException 
	{
		boolean flag5=false;
		int number;
		String name="";
		String appId="";
		do {
			scan = new Scanner(System.in);
			System.out.println("Choose the diagnostic center where the appointment has to be approved kindly enter the center name");
			for(DiagnosticCenter center : Dao.centerList)
			{
				System.out.println(center.getCenterName()+" "+center.getCenterId());
			}
			name=scan.nextLine();
			
			flag5=true;
			boolean methodFlag=false;
			for (DiagnosticCenter center : Dao.centerList) {
				if(name.equalsIgnoreCase(center.getCenterName()))
				{
					Dao.center=center;
					methodFlag=true;
					break;
				}
			}
			if(methodFlag==true)
			{
				System.out.println("Enter the appId");
				appId=scan.next();
				int n=0;
				
				for (DiagnosticCenter iterable_element : Dao.centerList) {
				
					if(iterable_element.getAppointmentList().get(n).getAppointmentId().equals(appId))
					{
						Dao.appoint=appId;
						if(service.approveAppointment())
						{
							System.out.println("Appointment approved Successfully");
							System.out.println(Dao.centerList);
							break;
						}
					}
					n++;
				}
				
			}
			else {
				
				throw new InvalidCenterNameException("Enter from the above displayed ones");
			}
		}
		while(!flag5);
	}
	

}
