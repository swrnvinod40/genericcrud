package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.daoimpl.GenericDAOImpl;

@SpringBootApplication
public class GenericcrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GenericcrudApplication.class, args);
	}

	@Autowired
	GenericDAOImpl genericDAOImpl;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		genericDAOImpl.testTVP();
	}
}
