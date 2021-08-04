package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ComplianceDao;

@Service
public class ComplianceService
{
	@Autowired
	ComplianceDao complianceDao;
}