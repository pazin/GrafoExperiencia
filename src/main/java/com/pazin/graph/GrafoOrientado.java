package com.pazin.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;


/**
 * Implementação de um Grafo Orientado para utilização em Ordenação Topológica.
 * <p>
 * A ordenação topológica é baseada no algorítmo da página da Wikipédia
 * (Depth-first search) {@link }
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Topological_sorting">https://en.wikipedia.org/wiki/Topological_sorting</a>
 * @author Fernando Pazin
 */
public class GrafoOrientado<T> implements Iterable<T> {
	
	private final Map<T, Set<T>> mapaInterno = new HashMap<T, Set<T>>();
	
	
	
	/**
	 * Adiciona um novo vértice ao Grafo.
	 * <p>
	 * Caso já exista ele simplesmente retorna falso;
	 * 
	 * @param vertice
	 * @return
	 */
	public boolean adicionaVertice(T vertice){
		if (mapaInterno.containsKey( vertice ))
			return false;
		
		mapaInterno.put( vertice, new HashSet<T>() );
		return true;
	}
	
	
	
	/**
	 * Baseado em um vértice de Origem e um de Destino esse método vai adicionar
	 * uma aresta ligando os dois.
	 * <p>
	 * Se essa aresta já existir o método simplesmente não faz nada.
	 * <p>
	 * Se algum dos vértices ainda não existir dentro do grafo esse método
	 * silenciosamente vai inserí-los automaticamente.
	 * 
	 * @param de
	 *            O vértice de origem
	 * @param para
	 *            O vértice de destino
	 */
	public void adicionaAresta(T origem, T destino){
		
		// O custo de verificar se o vértice existe é um lookup simples no mapa.
		// Caso já exista não faz mal nenhum.
		adicionaVertice( origem );
		adicionaVertice( destino );
		
		mapaInterno.get( origem ).add( destino );
	}
	
	
	/**
	 * Remove a aresta que parte da origem para o destino do Grafo.
	 * <p>
	 * Se a aresta não existir simplesmente não faz nada.
	 * <p>
	 * Ao contrário do método de adicionar aresta, nesse caso se os vértices não
	 * existirem ele vai lançar uma exceção. Os dois vértices precisam existir.
	 * 
	 * @param origem
	 * @param destino
	 */
	public void removeAresta(T origem, T destino){
		
		if (!mapaInterno.containsKey( origem ) || !mapaInterno.containsKey( destino ))
			throw new NoSuchElementException( "Os dois vértices precisam existir no grafo!" );
		
		mapaInterno.get( origem ).remove( destino );
	}
	
	
	/**
	 * Dados dois vértices, retorna se a aresta ligando os dois existe.
	 * <p>
	 * Como esse grafo é orientado, a direção da aresta é imporante (ou seja,
	 * ela aponta da origem PARA o destino)
	 * <p>
	 * Esse método não é silencioso como o adicionaAresta e caso algum Vértice
	 * não exista ele vai lançar exceção.
	 * 
	 * @param origem
	 * @param destino
	 * @return
	 */
	public boolean arestaExiste(T origem, T destino){
		
		if (!mapaInterno.containsKey( origem ) || !mapaInterno.containsKey( destino ))
			throw new NoSuchElementException( "Os dois vértices precisam existir no grafo!" );

		return mapaInterno.get( origem ).contains( destino );
	}
	
	
	
	/**
	 * Dado um vértice, esse método retorna uma visão imutável das arestas que
	 * partem dele.
	 * 
	 * @param vertice
	 * @return
	 */
	public Set<T> arestasAPartirDe(T vertice){
		Set<T> arestas = mapaInterno.get( vertice );
		
		if (arestas == null)
			throw new NoSuchElementException( "Vértice passado não existe no grafo" );
		
		return Collections.unmodifiableSet( arestas );
	}
	
	

	/**
	 * Usando o próprio iterator das chaves do mapa.
	 * Para a Ordenação Topológica será implementado em uma classe separada.
	 */
	@Override
	public Iterator<T> iterator()
	{
		return mapaInterno.keySet().iterator();
	} 
	
	
	public int size(){
		return mapaInterno.size();
	}

	
	public boolean isEmpty(){
		return mapaInterno.isEmpty();
	}



	/**
	 * Vai exportar esse grafo para ser desenhado pelo GraphViz usando a notação DOT
	 * 
	 * @return
	 */
	public String exportaDOTNotation(){
		
		StringBuilder result = new StringBuilder();
		
		

		return result.toString();
	}
}
