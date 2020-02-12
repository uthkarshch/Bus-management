package com.bms.menu;

import java.util.List;
import java.util.Scanner;

import com.bms.bean.Bus;
import com.bms.daoimpl.BusDAOImpl;

import MyExceptions.InputExceptions;

public class BusDetails {

	static Scanner sc=new Scanner(System.in);
	static BusDAOImpl BusDAO=new BusDAOImpl();

	public static void adminMenu()// throws InputExceptions
	{
		
		System.out.println("-----------------------");
		System.out.println("|   ADMIN MAIN MENU   |");
		System.out.println("-----------------------");
		System.out.println("| 1.ADD BUS           |");
		System.out.println("| 2.VIEW BUS          |");
		System.out.println("| 3.VIEW ALL BUSSES   |");
		System.out.println("| 4.UPDATE BUS        |");
		System.out.println("| 5.DELLETE BUS       |");
		System.out.println("| 6.BACK              |");
		System.out.println("-----------------------");
		
		System.out.println();
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) 
		{
		
		case 1:
			BusDAO.addBus();
			adminMenu();
			break;
			
		case 2:
			System.out.println("Enter Bus ID to search");
			Bus b=BusDAO.viewBus(sc.nextInt());
			System.out.println("BID"+"\t"+"BusName"+"\t"+"From"+"\t"+"To"+"\t"+"Date"+"\t"+"Time"+"\t"+"Fare"+"\t"+"No.of Seats");
			System.out.println("-------------------------------------------------------------");
			System.out.println(b);
			adminMenu();
			break;
		
		case 3:
			List<Bus> BusList=BusDAO.viewAllBusses();
			System.out.println("BID"+"\t"+"BusName"+"\t"+"From"+"\t"+"To"+"\t"+"Date"+"\t"+"Time"+"\t"+"Fare"+"\t"+"No.of Seats");
			System.out.println("---------------------------------------------------------------");
			for(Bus b1: BusList)
				System.out.println(b1);
			adminMenu();
			break;
		
		case 4:
			System.out.println("Enter the Bus Id that you want to update:");
			BusDAO.updateBus(sc.nextInt());
			adminMenu();
			break;
		
		case 5:
			System.out.println("Enter Bus ID to delete:");
			BusDAO.deleteBus(sc.nextInt());
			adminMenu();
			break;
		
		case 6:
			BusDAO.back();
			break;
			
		default:
			System.out.println("Please select your choice range 1-6 only");
		}
	}
	
	public static void customerMenu()
	{
		System.out.println("-----------------------");
		System.out.println("|  CUSTOMER MAIN MENU |");
		System.out.println("-----------------------");
		System.out.println("| 1.VIEW BUS          |");
		System.out.println("| 2.VIEW ALL BUSSES   |");
		System.out.println("| 3.BOOK TICKET       |");
		System.out.println("| 4.CANCEL TICKET     |");
		System.out.println("| 5.BACK              |");
		System.out.println("-----------------------");
		System.out.println();
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter Bus ID to view");
			Bus b=BusDAO.viewBus(sc.nextInt());
			System.out.println("BID"+"\t"+"BusName"+"\t"+"From"+"\t"+"To"+"\t"+"Date"+"\t"+"Time"+"\t"+"Fare"+"\t"+"No.of Seats");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println(b);
			customerMenu();
			break;
		case 2:
			List<Bus> BusList=BusDAO.viewAllBusses();
			System.out.println("BID"+"\t"+"BusName"+"\t"+"From"+"\t"+"To"+"\t"+"Date"+"\t"+"Time"+"\t"+"Fare"+"\t"+"No.of Seats");
			System.out.println("------------------------------------------------------------------------------------------");
			for(Bus b1: BusList)
				System.out.println(b1);
			customerMenu();
			break;
			
		case 3:
			BusDAO.bookTicket();
			customerMenu();
			break;
		case 4:
			System.out.println("Enter BusID to cancel from:");
			int bid=sc.nextInt();
			BusDAO.cancelTicket(bid);
			customerMenu();
			break;
		case 5:
			BusDAO.back();
			break;
		default:
			System.out.println("Please select your choice range 1-5 only");
		}
		
	}
}
