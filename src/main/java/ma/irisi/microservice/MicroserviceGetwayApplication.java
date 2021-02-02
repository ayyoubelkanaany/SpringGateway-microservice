package ma.irisi.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGetwayApplication.class, args);
	}
	 @Bean
	 public RouteLocator customRouteLocator(RouteLocatorBuilder builder)  {
	 return builder.routes()
	  .route("path_route", r -> r.path("/budgets/**").uri("lb://BUDGET-SERVICE"))
	  .route("path_route", r -> r.path("/budgetcomptecomptable/**").uri("lb://BUDGETCOMPTECOMPTABLE-SERVICE"))
	  .route("path_route", r -> r.path("/departement/**").uri("lb://DEPARTEMENT-SERVICE"))
	  .route("path_route", r -> r.path("/budgetDepartements/**").uri("lb://BUDGETDEPARTEMENT-SERVICE"))
	  .route("path_route", r -> r.path("/CompteComptable/**").uri("lb://COMPTECOMPTABLE-SERVICE"))
	  .route("path_route", r -> r.path("/budgetDepartementCompteComptables/**").uri("lb://BUDGETDEPARTEMENTCOMPTECOMPTABLE-SERVICE"))
	  .build();
	 
	 }
	
}
