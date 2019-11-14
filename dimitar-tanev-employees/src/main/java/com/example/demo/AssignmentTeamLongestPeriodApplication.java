package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.EmployeesPair;
import com.example.demo.service.PairService;

@SpringBootApplication
public class AssignmentTeamLongestPeriodApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AssignmentTeamLongestPeriodApplication.class, args);
		logLongestTeamPair(context);
	}

	private static void logLongestTeamPair(ConfigurableApplicationContext context) {
		Logger logger = LoggerFactory.getLogger(AssignmentTeamLongestPeriodApplication.class);
		Path path = Paths.get("src/main/resources/testData.txt");
		try {
			PairService pairService = context.getBean(PairService.class);
			EmployeesPair pair = pairService.findLongestTeamPair(Files.newInputStream(path));
			logger.info("Longest team pair is: " + pair);
		} catch (IOException e) {
			logger.info("There is a problem with file \"" + path.getFileName().toString() + "\"");
			e.printStackTrace();
		}
	}

}
