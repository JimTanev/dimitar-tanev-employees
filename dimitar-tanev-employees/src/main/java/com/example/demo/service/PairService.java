package com.example.demo.service;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeesPair;

@Service
public class PairService {
	
	@Autowired
	private EmployeeRepository empDao;
	
	public EmployeesPair findLongestTeamPair(InputStream fileStream) throws NumberFormatException, DateTimeParseException {
		EmployeesPair pair = null;
		List<Employee> employees = empDao.getRecords(fileStream);
		if(employees.size() < 2) {
			return pair;
		}
		long daysMax = 0;
		for(int i = 0; i < employees.size() - 1; i++) {
			Employee first = employees.get(i);
			for(int j = i+1; j < employees.size(); j++) {
				Employee second = employees.get(j);
				if(first.getProjectID() == second.getProjectID() && first.getDateFrom().isBefore(second.getDateTo())) {
					LocalDate initialDate = first.getDateFrom().isAfter(second.getDateFrom()) ? first.getDateFrom() : second.getDateFrom();
					LocalDate finalDate = first.getDateTo().isBefore(second.getDateTo()) ? first.getDateTo() : second.getDateTo();
					long days = ChronoUnit.DAYS.between(initialDate, finalDate);
					if(days > daysMax) {
						daysMax = days;
						pair = new EmployeesPair(first.getEmpID(), second.getEmpID(), first.getProjectID(), daysMax);
					}
				}
			}
		}
		return pair;
	}

}
