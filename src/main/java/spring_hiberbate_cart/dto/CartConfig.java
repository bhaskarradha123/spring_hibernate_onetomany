package spring_hiberbate_cart.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"spring_hiberbate_cart.dto","spring_hiberbate_cart.dao"})
public class CartConfig {
	     @Bean
		public EntityManager getEntityManager() {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("radha");
			return factory.createEntityManager();
		}


}
