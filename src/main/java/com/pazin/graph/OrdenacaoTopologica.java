package com.pazin.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Algoritmo de ordenação topológica (Topological Sort) baseado no exemplo da
 * página da Wikipedia ( <a
 * href="https://en.wikipedia.org/wiki/Topological_sorting"
 * >https://en.wikipedia.org/wiki/Topological_sorting</a> )
 * <p>
 * Uma ordenação topológica é uma ordenação dos vértices de um grafo onde para
 * cada vértice v, todos os ancestrais de v aparecem antes dele. Essa ordenação
 * é muito útil para modelar tarefas que dependem da conclusão de outras
 * tarefas.
 * <p>
 * Algoritmo original : "Edge-Disjoint Spanning Trees and Depth-First Search"
 * 
 * @author pazin
 */
public class OrdenacaoTopologica {
	
	
	/**
	 * Dado um grafo orientado (que não tenha ciclos) esse método retorna a
	 * lista de elementos dentro dos vértices em ordem Topológica.
	 * <p>
	 * Caso o grafo passado tenha ciclos, uma exceção será lançada.
	 * 
	 * @param dag
	 * @return
	 */
	public static <T> List<T> sort(GrafoOrientado<T> dag){
		
		// primeiro vamos inverter o grafo original
		GrafoOrientado<T> invertido = inverteGrafo(dag);
		
		List<T> result = new ArrayList<T>();
		Set<T> visitados = new HashSet<T>();
		
		/*
		 * Esse set é importante para ir determinado se conseguimos expandir
		 * todos os vértices. Caso um vértice tenha sido visitado porém não foi
		 * totalmente expandido, significa que o grafo tem um ciclo.
		 */
		Set<T> expandidos = new HashSet<T>();
		
		/*
		 * Explora recursivamente (DFS)
		 */
		for (T vertice : invertido)
			explora( vertice, invertido, result, visitados, expandidos );
		
		return result;
	}
	
	private static <T> void explora(T verticeAtual, GrafoOrientado<T> grafoInvertido, List<T> ordenacao, Set<T> visitados, Set<T> expandidos){

		if ( visitados.contains( verticeAtual ) ){
			/**
			 * Temos que verificar se esse vértice já foi expandido. Caso não
			 * tenha sido expandido ainda é porque estamos em um ciclo e temos
			 * que dar exceção.
			 */
			
			if (expandidos.contains( verticeAtual ))  
				return;   // OK
			else
				throw new UnsupportedOperationException("Grafo tem um ciclo!");
		}
		
		visitados.add( verticeAtual );
		
		for (T predecessor : grafoInvertido.arestasAPartirDe( verticeAtual ))
			explora( predecessor, grafoInvertido, ordenacao, visitados, expandidos );
		
		// Ordenação Topológica aqui...
		ordenacao.add( verticeAtual );
		
		// Esse controle dos expandidos é necessário para detectar ciclos no grafo.
		expandidos.add( verticeAtual );
	}
	
	
	/**
	 * Retorna o grafo invertido (com as arestas apontando no sentido contrário)
	 * 
	 * @param dag
	 * @return
	 */
	private static <T> GrafoOrientado<T> inverteGrafo(GrafoOrientado<T> dag){
		
		GrafoOrientado<T> result = new GrafoOrientado<T>();
		
		for (T vertice : dag)
			result.adicionaVertice( vertice );
		
		// Varrendo todos os vértices para construir o outro grafo porém com as arestas todas invertidas (do Destino PARA a Origem)
		for (T vertice : dag)
			for (T destino : dag.arestasAPartirDe( vertice ) )
				result.adicionaAresta( destino, vertice );
		
		return result;
	}

}
