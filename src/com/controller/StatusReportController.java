package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.StatusReportService;

@Controller
public class StatusReportController
{
	@Autowired
	StatusReportService statusreportService;
}