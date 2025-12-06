package Equipoo.Reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "Equipoo.Reservas.Client")
public class ReservasApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ReservasApplication.class, args);
	}
	/*
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	    
	}
	*/
	

}
