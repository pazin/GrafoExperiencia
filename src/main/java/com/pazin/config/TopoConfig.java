package com.pazin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.pazin.graph.GrafoOrientado;


@Configuration
@ComponentScan(basePackages={"com.pazin.*"})
public class TopoConfig {
	
	@Autowired
	private Environment env;
	

	@Bean("grafoCaseiro")
	public GrafoOrientado<String> getGrafoCaseiro(){
		
		
		GrafoOrientado<String> dag = new GrafoOrientado<String>();
		
		String um = "1";
		String dois = "2";
		String tres = "3";
		String quatro = "4";
		String cinco = "5";
		String seis = "6";
		String sete = "7";
		
		dag.adicionaAresta( um, quatro );
		dag.adicionaAresta( um, tres );

		dag.adicionaAresta( dois, quatro );
		dag.adicionaAresta( dois, cinco );

		dag.adicionaAresta( tres, seis );

		dag.adicionaAresta( quatro, tres );
		dag.adicionaAresta( quatro, seis );
		dag.adicionaAresta( quatro, sete );

		dag.adicionaAresta( cinco, quatro );
		dag.adicionaAresta( cinco, sete );
		
		dag.adicionaAresta( tres, seis );
		
		// ORDEM ESPERADA 1 2 5 4 3 6 7 
		
		
		return dag;
	}


	@Bean("grafoCaseiro2")
	public GrafoOrientado<String> getGrafoCaseiro2(){
		
		GrafoOrientado<String> dag = new GrafoOrientado<String>();
		
		String um = "1";
		String dois = "2";
		String tres = "3";
		String quatro = "4";
		String cinco = "5";
		String seis = "6";
		String sete = "7";
		
		dag.adicionaAresta( um, cinco );
		dag.adicionaAresta( um, quatro );
		dag.adicionaAresta( um, sete );

		dag.adicionaAresta( dois, tres );
		dag.adicionaAresta( dois, seis );
		dag.adicionaAresta( dois, cinco );

		dag.adicionaAresta( tres, cinco );
		dag.adicionaAresta( tres, quatro );

		dag.adicionaAresta( quatro, cinco );

		dag.adicionaAresta( cinco, seis );
		dag.adicionaAresta( cinco, sete );

		dag.adicionaAresta( seis, sete );
		
		
		// ORDEM ESPERADA 1 2 3 4 5 6 7
		
		return dag;
	}



	@Bean("grafoCaseiro3")
	public GrafoOrientado<String> getGrafoCaseiro3(){

		GrafoOrientado<String> dag = new GrafoOrientado<String>();

		String undershorts = "undershorts";
		String socks = "socks";
		String watch = "watch";
		String pants = "pants";
		String shoes = "shoes";
		String belt = "belt";
		String shirt = "shirt";
		String tie = "tie";
		String jacket = "jacket";
		
		dag.adicionaVertice( watch );
		
		dag.adicionaAresta( undershorts, shoes );
		dag.adicionaAresta( undershorts, pants );

		dag.adicionaAresta( socks, shoes );

		dag.adicionaAresta( pants, shoes );
		dag.adicionaAresta( pants, belt );

		dag.adicionaAresta( shirt, belt );
		dag.adicionaAresta( shirt, tie );

		dag.adicionaAresta( belt, jacket );

		dag.adicionaAresta( tie, jacket );
		
		return dag;
	}



	@Bean("grafoCaseiro4")
	public GrafoOrientado<String> getGrafoCaseiro4(){

		GrafoOrientado<String> dag = new GrafoOrientado<String>();

		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		String f = "f";
		

		dag.adicionaAresta( d, c );
		dag.adicionaAresta( d, b );

		dag.adicionaAresta( e, c );
		dag.adicionaAresta( e, f );

		dag.adicionaAresta( b, a );

		dag.adicionaAresta( a, f );

		return dag;
	}

}
