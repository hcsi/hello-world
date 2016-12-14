package com.bili.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bili.beans.Schedule;
import com.bili.beans.Loan;
import com.bili.beans.LoanInfo;

@Component
public class Calculator {
	public LoanInfo calculate(Loan loan){
		LoanInfo loanInfo = new LoanInfo();
		// monthly interest rate
		double r = loan.getInterest()/12;
		// total months for payment
		int months = loan.getYear()*12;
		// monthly payment
		double payment = loan.getPrincipal()/months;
		loanInfo.setPayment(payment);
		// original balance or debt
		double balance = loan.getPrincipal();
		// set up the ArrayList for monthly schedule
		loanInfo.setSchedule(new ArrayList<Schedule>());
		// set up initial interest to pay as 0, then gradually add it up monthly
		double totalInterest = 0;
		// set up monthly schedule payment details for table
		for(int i = 1; i <= months; i++){
			Schedule s = new Schedule();
			s.setMonth(i);
			double intPmt = balance*r;
			s.setInt_pmt(intPmt);
			s.setPrin_pmt(payment);
			balance = balance - payment;
			s.setBalance(balance);
			totalInterest += intPmt;
			s.setTotalInterest(totalInterest);
			loanInfo.addSchedule(s);
		}
		loanInfo.setTotalInterest(totalInterest);
		return loanInfo;
	}
	
}
