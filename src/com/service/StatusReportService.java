package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StatusReportDao;

@Service
public class StatusReportService
{
	@Autowired
	StatusReportDao statusreportDao;
}