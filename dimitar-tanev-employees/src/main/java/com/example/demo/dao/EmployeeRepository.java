package com.example.demo.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeRepository {
	
	private static final DateTimeFormatter[] DATE_FORMATTERS = new DateTimeFormatter[] {
			DateTimeFormatter.BASIC_ISO_DATE, 
			DateTimeFormatter.ISO_DATE, 
			DateTimeFormatter.ISO_LOCAL_DATE, 
			DateTimeFormatter.ISO_OFFSET_DATE, 
			DateTimeFormatter.ISO_ORDINAL_DATE, 
			DateTimeFormatter.ISO_WEEK_DATE
			};
			
	public List<Employee> getRecords(InputStream fileStream) throws NumberFormatException, DateTimeParseException {
		List<String> records = new BufferedReader(new InputStreamReader(fileStream))
					  .lines().collect(Collectors.toList());
		List<Employee> employees = new ArrayList<>();
		for(String record : records) {
			String[] elements = record.trim().split("\\s*,\\s*");
			employees.add(new Employee(
					Integer.parseInt(elements[0]), 
					Integer.parseInt(elements[1]), 
					checkDifferentDateInputFormats(elements[2]), 
					checkDateToForNull(elements[3])));
		}
		return employees;
	}

	private LocalDate checkDateToForNull(String dateTo) {
		return dateTo.equals("NULL") ? LocalDate.now() : checkDifferentDateInputFormats(dateTo);
	}
	
	private LocalDate checkDifferentDateInputFormats(String dateTo) throws DateTimeParseException {
		for(DateTimeFormatter formatter : DATE_FORMATTERS) {
			try {				
				LocalDate date = LocalDate.parse(dateTo, formatter);
				return date;
			} catch (DateTimeParseException e) {
				// continue with loop
			}
		}
		// Tries to parse the the string and throws DateTimeParseException.
		return LocalDate.parse(dateTo);
	}

}
