package com.fretes.lancamentofretes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.context.annotation.ComponentScan;

// import com.fretes.lancamentofretes.services.ClientesService;
// import com.fretes.lancamentofretes.view.controller.ClientesController;

// @ComponentScan(basePackageClasses = ClientesController.class)
// @ComponentScan(basePackageClasses = ClientesService.class)
@EnableWebMvc
@SpringBootApplication
public class LancamentofretesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LancamentofretesApplication.class, args);
	}

}
