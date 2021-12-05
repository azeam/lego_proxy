package com.azeam.lego;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.azeam.lego.lego.Lego;
import com.azeam.lego.lego.LegoRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class LegoApplication {

	@Autowired
	LegoRepository legoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LegoApplication.class, args);
	}

	@Bean
	public CommandLineRunner legoData() throws IOException {
		return args -> {
			File file = new ClassPathResource("static/themes.csv").getFile();
			FileReader filereader = new FileReader(file);
			CSVReader reader = new CSVReaderBuilder(filereader)
					.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
					.withSkipLines(1)
					.build();
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String name = nextLine[1].trim();
				if (legoRepository.findByName(name) == null) {
					legoRepository.save(new Lego(name));
				}
			}
		};
	}
}
