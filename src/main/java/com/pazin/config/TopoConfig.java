package com.pazin.config;

import org.jgrapht.EdgeFactory;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.ClassBasedEdgeFactory;
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
	

	

	
	@Bean("grafoDependencia1")
	public DirectedAcyclicGraph<String, String> getGrafo(){

		String sete = "7";
		String tres = "3";
		String dez = "10";
		String cinco = "5";
		String onze = "11";
		String nove = "9";
		String dois = "2";
		String oito = "8";
		
		EdgeFactory<String, String> factory = new ClassBasedEdgeFactory<String, String>(String.class);
		
		DirectedAcyclicGraph<String, String> dag = new DirectedAcyclicGraph<String, String>( factory );

		dag.addVertex( tres );
		dag.addVertex( sete );
		dag.addVertex( oito );
		dag.addVertex( cinco );
		dag.addVertex( onze );
		dag.addVertex( dez );
		dag.addVertex( dois );
		dag.addVertex( nove );
		
		try
		{
			dag.addDagEdge( cinco, onze );
			dag.addDagEdge( sete, onze );
			dag.addDagEdge( tres, oito );
			dag.addDagEdge( sete, oito );

			dag.addDagEdge( onze, dois );
			dag.addDagEdge( onze, nove );
			dag.addDagEdge( onze, dez );

			dag.addDagEdge( oito, nove );
			
			dag.addDagEdge( tres, dez );
		}
		catch ( CycleFoundException e )
		{
			e.printStackTrace();
		}
		
		return dag;
	}
	
	
	/**
	 * 
	 * ESSE AQUI DEU ERRADO USANDO O JGRAPHT
	 * 
	 * @return
	 */
	@Bean("grafoDependencia2")
	public DirectedAcyclicGraph<String, String> getGrafo2(){

		String um = "1";
		String dois = "2";
		String tres = "3";
		String quatro = "4";
		String cinco = "5";
		String seis = "6";
		String sete = "7";
		
		EdgeFactory<String, String> factory = new ClassBasedEdgeFactory<String, String>(String.class);
		
		DirectedAcyclicGraph<String, String> dag = new DirectedAcyclicGraph<String, String>( factory );

		dag.addVertex( sete );
		dag.addVertex( seis );
		dag.addVertex( cinco );
		dag.addVertex( quatro );
		dag.addVertex( tres );
		dag.addVertex( dois );
		dag.addVertex( um );
		
		try
		{
			dag.addDagEdge( um, quatro );
			dag.addDagEdge( um, tres );

			dag.addDagEdge( dois, quatro );
			dag.addDagEdge( dois, cinco );

			dag.addDagEdge( tres, seis );

			dag.addDagEdge( quatro, tres );
			dag.addDagEdge( quatro, seis );
			dag.addDagEdge( quatro, sete );

			dag.addDagEdge( cinco, quatro );
			dag.addDagEdge( cinco, sete );
			
			dag.addDagEdge( tres, seis );
		}
		catch ( CycleFoundException e )
		{
			e.printStackTrace();
		}
		
		return dag;
	}


	@Bean("grafoDependencia3")
	public DirectedAcyclicGraph<String, String> getGrafo3(){

		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		String f = "f";
		
		EdgeFactory<String, String> factory = new ClassBasedEdgeFactory<String, String>(String.class);
		
		DirectedAcyclicGraph<String, String> dag = new DirectedAcyclicGraph<String, String>( factory );

		dag.addVertex( a );
		dag.addVertex( b );
		dag.addVertex( c );
		dag.addVertex( d );
		dag.addVertex( e );
		dag.addVertex( f );
		
		try
		{
			dag.addDagEdge( d, c );
			dag.addDagEdge( d, b );

			dag.addDagEdge( e, c );
			dag.addDagEdge( e, f );

			dag.addDagEdge( b, a );

			dag.addDagEdge( a, f );

		}
		catch ( CycleFoundException ex )
		{
			ex.printStackTrace();
		}
		
		return dag;
	}


	@Bean("grafoDependencia4")
	public DirectedAcyclicGraph<String, String> getGrafo4(){

		String undershorts = "undershorts";
		String socks = "socks";
		String watch = "watch";
		String pants = "pants";
		String shoes = "shoes";
		String belt = "belt";
		String shirt = "shirt";
		String tie = "tie";
		String jacket = "jacket";
		
		EdgeFactory<String, String> factory = new ClassBasedEdgeFactory<String, String>(String.class);
		
		DirectedAcyclicGraph<String, String> dag = new DirectedAcyclicGraph<String, String>( factory );

		dag.addVertex( undershorts );
		dag.addVertex( socks );
		dag.addVertex( watch );
		dag.addVertex( pants);
		dag.addVertex( shoes );
		dag.addVertex( belt );
		dag.addVertex( shirt );
		dag.addVertex( tie );
		dag.addVertex( jacket );
		
		try
		{
			dag.addDagEdge( undershorts, shoes );
			dag.addDagEdge( undershorts, pants );

			dag.addDagEdge( socks, shoes );

			dag.addDagEdge( pants, shoes );
			dag.addDagEdge( pants, belt );

			dag.addDagEdge( shirt, belt );
			dag.addDagEdge( shirt, tie );

			dag.addDagEdge( belt, jacket );

			dag.addDagEdge( tie, jacket );

		}
		catch ( CycleFoundException ex )
		{
			ex.printStackTrace();
		}
		
		return dag;
	}



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
