package com.bms.main;

import java.util.Scanner;

import com.bms.menu.BusDetails;

import MyExceptions.InputExceptions;

public class BusManagement {

	private static Scanner sc;

	public static void main(String[] args) //throws InputExceptions 
	{
		sc = new Scanner(System.in);
		
		while (true) 
		{
			//try {
				System.out.println("-------------------------------");
				System.out.println("|  BUS MANAGEMENT SYSTEM      |");
				System.out.println("-------------------------------");
				System.out.println("|  1. ADMIN                   |");
				System.out.println("|  2. CUSTOMER                |");
				System.out.println("|  3. EIXT                    |");
				System.out.println("-------------------------------");
				System.out.println();
				System.out.println("Enter Your Choice ?");
				int choice = sc.nextInt();
				switch (choice) 
				{
				case 1:
					BusDetails.adminMenu();
					break;
				case 2:
					BusDetails.customerMenu();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Please select choice range 1-3 only");

				}
			
		}
		
		
	}

}
