package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/getAllCompany")
	@ResponseBody
	public List<String> getAllCompany()
	{
		return companyService.getAllCompany();
	}
}
