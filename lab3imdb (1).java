package mbarrera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.io.IOException;
import java.lang.String;
import bridges.base.SLelement;
import bridges.base.GraphAdjListSimple;
import bridges.base.Edge;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;
import bridges.validation.RateLimitException;


public class lab3imdb {

		
		  public static void main(String[] args) throws IOException, RateLimitException, InterruptedException {

					// TODO Auto-generated method stub
					/*
			
					 */
		
				// initialize Bridges, set credentials
				Bridges bridges = new Bridges(9930,"mbarreranc", "448543506431");
				
				// set a title
				bridges.setTitle("IMDB Actor/movie graph.");
				// set  description
				bridges.setDescription("Demonstrate advanced features of graphs, traversal of adjacency lists, use of iterators");
				//create access to the datasource  
				DataSource ds = bridges.getDataSource();
					
				// Get a List of ActorMovieIMDB objects from Bridges
				List<ActorMovieIMDB> movielist = ds.getActorMovieIMDBData(1813);
				
				GraphAdjListSimple<String> graph = new GraphAdjListSimple<String>();
				
				//construct the graph
				
				for(int i = 0; i < movielist.size(); i++){
				ActorMovieIMDB item = movielist.get(i);
				String actorN = item.getActor();
				String movieT = item.getMovie();
				
				if(graph.getVertex(actorN) == null) {
					graph.addVertex(actorN,actorN);
				}
				
				if(graph.getVertex(movieT) == null) {
					graph.addVertex(movieT,movieT);
				}
				
				else
					graph.addEdge(actorN,movieT);
					graph.addEdge(movieT,actorN);
				
			}
				
				System.out.println(graph.getVertices());
				// Pass the graph object to BRIDGES
				bridges.setDataStructure(graph);

				// Finaly we call the visualize function
				bridges.visualize();
			
	}


		
}


