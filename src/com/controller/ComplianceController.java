package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.ComplianceService;

@Controller
public class ComplianceController
{
	@Autowired
	ComplianceService complianceService;
}