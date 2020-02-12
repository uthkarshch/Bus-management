package com.bms.daoimpl;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.bms.bean.Bus;
import com.bms.dao.BusDAO;
import com.bms.main.BusManagement;
import com.bms.menu.BusDetails;

import MyExceptions.InputExceptions;

class BusavailablityException extends RuntimeException{
	public BusavailablityException(String msg) {
		super(msg);
	}
}
class TicketavailabilityException extends RuntimeException{
	public TicketavailabilityException(String msg)
	{
		super(msg);
	}
}
public class BusDAOImpl implements BusDAO
{

	Scanner sc=new Scanner(System.in);
	
	
	static List<Bus> busList=new ArrayList<Bus>();
	static List<Bus> tempList=new ArrayList<Bus>();
	
	static int total=0;
	
	Bus b= null;
	 
	@Override
	public void addBus() 
	{
		
			int i = 1;
			while(i==1)
			{
			b=new Bus();
			System.out.println("Enter Bus ID:");
			b.setBid(sc.nextInt());
			
			System.out.println("Enter Bus Name:");
			b.setBname(sc.next());
			
			System.out.println("Enter Starting Location :");
			b.setFrom(sc.next());
			
			System.out.println("Enter Destination Location: ");
			b.setTo(sc.next());
			
			System.out.println("Enter Journey Date in 'dd-mm-yy' Format: ");
			b.setDate(sc.next());
			
			System.out.println("Enter time in 'HHMM' 24hrs Format");
			b.setTime(sc.nextDouble());
			
			System.out.println("Enter Fare: ");
			b.setFare(sc.nextInt());
			
			System.out.println("Total number of Seats available:");
			b.setNoOfSeats(sc.nextInt());
			
			
			total=b.getNoOfSeats();
			
			busList.add(b);
			
			
			
			
			System.out.println("Do you wanna add another bus?"+"\t"+"1)Yes"+"\t"+"2)N0");
			i=sc.nextInt();
		}
		System.out.println("---------------------");
		System.out.println("      Bus Added");
		System.out.println("---------------------");
		
	}

	
	
	@Override
	public Bus viewBus(int bid) 
	{
		Bus b=null;
		for(Bus b1: busList)
		{
			if(b1.getBid()==bid)
			{
				b=b1;
				break;
			}
			else
			{
				throw new BusavailablityException("Bus not Available please try with another ID");
			}
		}
		return b;
	}

	@Override
	public List<Bus> viewAllBusses() 
	{
			return busList;
	}
	
	@Override
	public void updateBus(int bid) // throws InputExceptions
	{
		tempList= new ArrayList<Bus>();
			for(Bus b:busList)
			{
				if(b.getBid()==bid)
				{
			
					System.out.println("===================================");
					System.out.println("What are details you wanna update?");
					System.out.println("1.Update Bus ID:");
					System.out.println("2.Update Bus Name:");
					System.out.println("3.Update Bus Statring Location:");
					System.out.println("4.Update Bus Destination:");
					System.out.println("5.Update Bus Journey Date:");
					System.out.println("6.Update Bus Timing:");
					System.out.println("7.Update Bus Fare:");
					System.out.println("8.Update Number of Seats in the Bus:");
					System.out.println("9.Back");
					System.out.println("=====================================");
					System.out.println("Enter your Chioce:");
					int ch=sc.nextInt();
					switch(ch)
					{
					case 1:
						System.out.println("Enter Updated Bus ID:");
						b.setBid(sc.nextInt());
						break;
						
					case 2:
						System.out.println("Enter Updated Bus Name:");
						b.setBname(sc.next());
						break;
					
					case 3:
						System.out.println("Enter Updated Starting Location :");
						b.setFrom(sc.next());
						break;
					
					case 4:
						System.out.println("Enter  Updated Destination Location: ");
						b.setTo(sc.next());
						break;
					
					case 5:
						System.out.println("Enter updated Journey Date in 'dd-mm-yy' format: ");
						b.setDate(sc.next());
						break;
					
					case 6:
						System.out.println("Enter updated time in 'HHMM' 24hrs Format: ");
						b.setTime(sc.nextDouble());
						break;
						
					case 7:
						System.out.println("Enter updated Fare: ");
						b.setFare(sc.nextInt());
						break;
						
					case 8:
						System.out.println("Total updated number of Seats available:");
						b.setNoOfSeats(sc.nextInt());
						break;
					case 9:
						BusDetails.adminMenu();
						break;
						
					//default:
						//System.out.println("Enter within the given range of 1-9");
					}
				
				tempList.add(b);
				System.out.println("Sucessfull");
				System.out.println();
			}
			else
			{
				throw new BusavailablityException("Bus not Available please try with another ID");
				
			}
		}	
			
		busList=new ArrayList<Bus>();
		for(Bus b:tempList)
		{
			busList.add(b);
		}
		//System.out.println("Sucessfull");
		System.out.println();
		
	}

	
	
	
	
	@Override
	public void deleteBus(int bid) 
	{
		tempList =new ArrayList<Bus>();
		for(Bus b:busList)
		{
			if(b.getBid()==bid)
			{
				
			}
			else
			{
				tempList.add(b);
			}
		}
		busList=new ArrayList<Bus>();
		for(Bus b:tempList)
		{
			busList.add(b);
		}
			System.out.println("Successfully Deleted");
	}
	
	
	
	
	
	
	
	@Override
	public void bookTicket() 
	{
		total=b.getNoOfSeats();
		System.out.println("Enter Bus ID");
		int bid=sc.nextInt();
		
		//b.setRemaining(b.getNoOfSeats());
		
		for(Bus b:busList)
		{
			if(b.getBid()==bid)
			{
				System.out.println();
				System.out.println("Bus found!");
				System.out.println();
				System.out.println("The Bus you've choose starts from "+b.getFrom()+" to "+b.getTo());
				System.out.println();
				System.out.println("Enter Number tickets needed:");
				int tickets=sc.nextInt();
				if(tickets<=total)
				{
					System.out.println("Your Journey Fare is : '"+b.getFare()*tickets+"' for  the journey dated on "+b.getDate());
					b.setNoOfSeats(total-tickets);
					System.out.println("--------Sucessfully Booked-----");
				}
				else
				{
					throw new TicketavailabilityException(" Ticket(s) not available ");
					
				}
			
			}		
			
		}
		
		System.out.println();
		System.out.println("ThankYou");
		System.out.println();
	}

	
	
	@Override
	public void cancelTicket(int bid) 
	{
		
		int remaining=total-b.getNoOfSeats();
		
			
			for(Bus b:busList)
			{
				if(b.getBid()==bid)
				{
					System.out.println("Enter number of tickets to be cancelled:");
					int count=sc.nextInt();
					if(count<=remaining)
					{
						b.setNoOfSeats(b.getNoOfSeats()+count);
						System.out.println();
						System.out.println("Ticket(s) Cancelled");
						System.out.println();
					}
					else if(count>remaining) 
					{
						System.out.println("Please enter VALID number of tickets");
					}
				}
				else
				{
					System.out.println("Enter valid BusID");
					break;
				}
			
			}
		System.out.println();
		System.out.println("ThankYou");
		System.out.println();
		
	}

	
	
	@Override
	public void back() {
		BusManagement.main(null);
		
	}

}
