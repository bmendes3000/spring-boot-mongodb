package org.br.spring.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * Class Main to start project.
 * @author Bruno Mendes
 * @since 1.0
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan (basePackages = {
		"org.br.spring.mongo.controllers",
		"org.br.spring.mongo.services",
		"org.br.spring.mongo.daos",
		"org.br.spring.mongo.vos"
})
public class Application {
	/**
	 * Method responsible start project.
	 * @param args {@link String}
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
