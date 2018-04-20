package com.flight.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.flight.bean.Company;
import com.flight.bean.CompanyExample;
import com.flight.mapper.CompanyMapper;
import com.flight.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public List<String> getAllCompany() {
		List<String> list=new ArrayList<>();
		CompanyExample example=new CompanyExample();
		example.setDistinct(true);
		List<Company> companys = companyMapper.selectByExample(example);
		for (Company company : companys) {
			list.add(company.getName()+company.getCode());
		}
		return list;
	}

}
