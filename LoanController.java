package com.bili.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bili.beans.LoanInfo;
import com.bili.beans.Loan;
import com.bili.util.Calculator;

@Controller
public class LoanController {
	@Autowired
	private Calculator cal;
	
	@RequestMapping(value="/cal", method=RequestMethod.POST)
	@ResponseBody
	public LoanInfo postOut(@RequestBody Loan loan){
		LoanInfo info = cal.calculate(loan);
		return info;
	}
	
	@RequestMapping(value="/cal", method=RequestMethod.GET)
	@ResponseBody
	public LoanInfo getIn(HttpServletRequest request){
		Loan loan = new Loan();
		loan.setPrincipal(Double.parseDouble(request.getParameter("amount")));
		loan.setInterest(Double.parseDouble(request.getParameter("rate")));
		loan.setYear(Integer.parseInt(request.getParameter("year")));
		LoanInfo info = cal.calculate(loan);
		return info;
	}
	
	
	
	
}
