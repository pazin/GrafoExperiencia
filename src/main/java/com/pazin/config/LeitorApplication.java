package com.pazin.config;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.pazin.graph.GrafoOrientado;
import com.pazin.graph.OrdenacaoTopologica;

@SpringBootApplication
public class LeitorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LeitorApplication.class, args);
		
//		DirectedAcyclicGraph<String, String> dag = (DirectedAcyclicGraph<String, String>) context.getBean( "grafoDependencia4" );
		
//		for (Iterator<String> iterator = dag.iterator(); iterator.hasNext(); ){
//			String s = iterator.next();
//			
//			System.out.println(s);
//		}
		
		GrafoOrientado<String> dag = (GrafoOrientado<String>) context.getBean( "grafoCaseiro4" );

		List<String> result = OrdenacaoTopologica.sort( dag );
		
		result.forEach( s -> System.out.println(s) );
		
	}
}
