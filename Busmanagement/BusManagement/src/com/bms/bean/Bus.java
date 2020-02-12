package com.bms.bean;

public class Bus 
{
	private int bid;
	private String bname;
	private String from;
	private String to;
	private String date;
	private double time;
	private int fare;
	private int noOfSeats;
	//private int remaining;
	
	
	public Bus(int bid, String bname, String from, String to, String date, double time, int fare, int noOfSeats/*,int remaining*/) 
	{
		//super();
		this.bid = bid;
		this.bname = bname;
		this.from = from;
		this.to = to;
		this.date = date;
		this.time = time;
		this.fare = fare;
		
		//this.remaining=noOfSeats;
		this.noOfSeats = noOfSeats;
	}


	public Bus() {
		// TODO Auto-generated constructor stub
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public double getTime() {
		return time;
	}


	public void setTime(double time) {
		this.time = time;
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	public int getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public String toString()
	{
		return bid+"\t"+bname+"\t"+from+"\t"+to+"\t"+date+"\t"+time+"\t"+fare+"\t"+noOfSeats+"\t"/*+remaining*/;
		
	}

/*
	public int getRemaining() {
		return noOfSeats;
	}


	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}*/
	
	
}
