package com.bili.beans;

public class Schedule {
	private int month;
	private double balance;
	private double prin_pmt;
	private double int_pmt;
	private double totalInterest;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getPrin_pmt() {
		return prin_pmt;
	}
	public void setPrin_pmt(double prin_pmt) {
		this.prin_pmt = prin_pmt;
	}
	public double getInt_pmt() {
		return int_pmt;
	}
	public void setInt_pmt(double int_pmt) {
		this.int_pmt = int_pmt;
	}
	public double getTotalInterest() {
		return totalInterest;
	}
	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}
}
