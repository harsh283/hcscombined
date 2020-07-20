package com.cg.eis.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Scanner scan = new Scanner(System.in);
		int n;
		do
		{
			try {
				n = scan.nextInt();
				if(n<3000)
				{
					throw new EmployeeException("Employee exception handled");
					
				}
				flag=true;
			}
			catch (InputMismatchException e) {
				// TODO: handle exception
			}
			catch (EmployeeException e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		while(!flag);

	}

}
