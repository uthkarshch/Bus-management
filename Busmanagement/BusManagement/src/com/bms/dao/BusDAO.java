package com.bms.dao;

import java.util.List;
import com.bms.bean.Bus;

import MyExceptions.InputExceptions;

public interface BusDAO 
{
	

	public void addBus();
	public Bus viewBus(int bid);
	public List<Bus> viewAllBusses();
	public void updateBus(int bid); //throws InputExceptions;
	public void deleteBus(int bid);
	public void bookTicket();
	public void cancelTicket(int bid);
	public void back();
}
