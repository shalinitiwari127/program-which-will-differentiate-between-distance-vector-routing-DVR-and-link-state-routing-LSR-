

import java.util.Scanner;


class Graph 
{ 
    class Edge { 
        int src, dest, weight; 
        Edge() { 
            src = dest = weight = 0; 
        } 
    }; 
  
    int V, E; 
    Edge edge[]; 
  
    Graph(int v, int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[e]; 
        for (int i=0; i<e; ++i) 
            edge[i] = new Edge(); 
    } 
  
    void BellmanFord(Graph graph,int src) 
    { 
        int V = graph.V, E = graph.E; 
        int dist[] = new int[V]; 
        int hop[]=new int[V];
       
        for (int i=0; i<V; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        dist[src] = 0; 
  
        int flag=0;
        for (int i=1; i<V; ++i) 
        { 
            
            for (int j=0; j<E; ++j) 
            { 
                int u = graph.edge[j].src; 
                int v = graph.edge[j].dest; 
                int weight = graph.edge[j].weight; 
                if (dist[u]!=Integer.MAX_VALUE && 
                    dist[u]+weight<dist[v]){ 
                    dist[v]=dist[u]+weight;
                    hop[v]=u;
                }
                
            } 
        } 
  
     
        for (int j=0; j<E; ++j) 
        { 
            int u = graph.edge[j].src; 
            int v = graph.edge[j].dest; 
            int weight = graph.edge[j].weight; 
            if (dist[u] != Integer.MAX_VALUE && 
                dist[u]+weight < dist[v]) 
              System.out.println("Graph contains negative weight cycle"); 
        } 
        printArr(dist, V, hop,src); 
    } 
  
    void printArr(int dist[], int V, int hop[],int src) 
    { 
            System.out.println("Destination   Cost      Next hop "); 
         int c=0; 
        for (int i=0; i<V; ++i){
            if(i!=src){
                c=hop[i];            
                    while(hop[c]!=src && hop[c]!=i){
                        c=hop[c];
                    }
                System.out.println("     "+i+"\t\t"+dist[i]+"\t   "+c);
            }
        }
    } 



}


class Dij{
    //--------------------------------------Methods for dijkstra---------------------------------------------
    int NO_PARENT=-1;
     static  void dijkstra(int[][] adjacencyMatrix, int startVertex) 
       { 
        int nVertices = adjacencyMatrix[0].length; 
  
        // shortestDistances[i] will hold the shortest distance from src to i   
        int[] shortestDistances = new int[nVertices]; 
        boolean[] added = new boolean[nVertices]; 

        for (int vertexIndex = 0; vertexIndex < nVertices;  vertexIndex++)                                       
        { 
            shortestDistances[vertexIndex] = Integer.MAX_VALUE; 
            added[vertexIndex] = false; 
        } 
          
        // Distance of source vertex from itself is always 0
        shortestDistances[startVertex] = 0; 
        int[] parents = new int[nVertices]; 
        int NO_PARENT=-1;
        parents[startVertex] = NO_PARENT; 
  
        // Find shortest path for all  vertices
        for (int i = 1; i < nVertices; i++) 
        { 
  
            // Pick the minimum distance vertex 
            // from the set of vertices not yet 
            // processed. nearestVertex is  
            // always equal to startNode in  
            // first iteration. 
            int nearestVertex = -1; 
            int shortestDistance = Integer.MAX_VALUE; 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
            { 
                if (!added[vertexIndex] &&  shortestDistances[vertexIndex] < shortestDistance)     
                { 
                    nearestVertex = vertexIndex; 
                    shortestDistance = shortestDistances[vertexIndex];                        
                    // System.out.println("updated value of neighbouring vertex"+vertexIndex+":"+ shortestDistance);     
                }                 
            } 
   // Mark the picked vertex as processed 
            added[nearestVertex] = true; 
  
            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)            
            { 
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];                   
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))          
                { 
                    parents[vertexIndex] = nearestVertex; 
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;  
                   //  System.out.println("updated value of neighbouring vertex"+vertexIndex+":"+ shortestDistances[vertexIndex]);                                       
                } 
            } 
        } 
  
        printSolution(startVertex, shortestDistances, parents, adjacencyMatrix); 
    } 

   

     static void printSolution(int startVertex, int[] distances, int[] parents, int adjacencyMatrix[][]) {
        int nVertices = distances.length; 
        System.out.print("Vertex\t Distance");           
        for (int vertexIndex = 0;vertexIndex < nVertices; vertexIndex++)        
        { 
            if (vertexIndex != startVertex && adjacencyMatrix[startVertex][vertexIndex]!=0)  
            { 
                System.out.print("\n" + startVertex + " -> "); 
                System.out.print(vertexIndex + " \t    "); 
                System.out.print(distances[vertexIndex] + "\t\t"); 
               // printPath(vertexIndex, parents); 
               // System.out.println("-1"); 
                System.out.println("");
            } 
        }         
    }
      static void printPath(int currentVertex, int[] parents) {
         int NO_PARENT=-1;
         if (currentVertex == NO_PARENT) 
            return;
         System.out.print(currentVertex +"<="); 
        printPath(parents[currentVertex], parents); 
       
    }
      static  void dijkstra1(int[][] adjacencyMatrix, int startVertex) 
       { 
        int nVertices = adjacencyMatrix[0].length; 
  
        // shortestDistances[i] will hold the shortest distance from src to i   
        int[] shortestDistances = new int[nVertices]; 
        boolean[] added = new boolean[nVertices]; 

        for (int vertexIndex = 0; vertexIndex < nVertices;  vertexIndex++)                                       
        { 
            shortestDistances[vertexIndex] = Integer.MAX_VALUE; 
            added[vertexIndex] = false; 
        } 
          
        // Distance of source vertex from itself is always 0
        shortestDistances[startVertex] = 0; 
        int[] parents = new int[nVertices]; 
        int NO_PARENT=-1;
        parents[startVertex] = NO_PARENT; 
  
        // Find shortest path for all  vertices
        for (int i = 1; i < nVertices; i++) 
        { 
  
            // Pick the minimum distance vertex 
            // from the set of vertices not yet 
            // processed. nearestVertex is  
            // always equal to startNode in  
            // first iteration. 
            int nearestVertex = -1; 
            int shortestDistance = Integer.MAX_VALUE; 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
            { 
                if (!added[vertexIndex] &&  shortestDistances[vertexIndex] < shortestDistance)     
                { 
                    nearestVertex = vertexIndex; 
                    shortestDistance = shortestDistances[vertexIndex];                        
                    // System.out.println("updated value of neighbouring vertex"+vertexIndex+":"+ shortestDistance);     
                }                 
            } 
   // Mark the picked vertex as processed 
            added[nearestVertex] = true; 
  
            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)            
            { 
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];                   
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))          
                { 
                    parents[vertexIndex] = nearestVertex; 
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;  
                   //  System.out.println("updated value of neighbouring vertex"+vertexIndex+":"+ shortestDistances[vertexIndex]);                                       
                } 
            } 
        } 
  
        printSolution1(startVertex, shortestDistances, parents, adjacencyMatrix); 
    } 

   

     static void printSolution1(int startVertex, int[] distances, int[] parents, int adjacencyMatrix[][]) {
        int nVertices = distances.length; 
        System.out.print("Vertex\t Distance");           
        for (int vertexIndex = 0;vertexIndex < nVertices; vertexIndex++)        
        { 
            if (vertexIndex != startVertex)  
            { 
                System.out.print("\n" + startVertex + " -> "); 
                System.out.print(vertexIndex + " \t    "); 
                System.out.print(distances[vertexIndex] + "\t\t"); 
                printPath1(vertexIndex, parents); 
                System.out.println("0"); 
                System.out.println("");
            } 
        }         
    }
      static void printPath1(int currentVertex, int[] parents) {
         int NO_PARENT=-1;
         if (currentVertex == NO_PARENT) 
            return;
         System.out.print(currentVertex +"<="); 
        printPath1(parents[currentVertex], parents); 
       
    }
     
}

public class CNAssignment {
    
    public static void main(String[] args) {
         int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("The Graph for the following Assignment is:");
         int[][] adjacencyMatrix = {{ 0, 5, 3, 1, 0, 0, 0}, 
                                    { 5, 0, 1, 0, 1, 0, 0}, 
                                    { 3, 1, 0, 2, 3, 0, 0}, 
                                    { 1, 0, 2, 0, 0, 1, 0}, 
                                    { 0, 1, 3, 0, 0, 0, 2}, 
                                    { 0, 0, 0, 1, 0, 0, 2},
                                    { 0, 0, 0, 0, 2, 2, 0}};
         System.out.print("  ");
         for(int i=0;i<adjacencyMatrix[0].length;i++)
         {
             System.out.print(" "+i);
         }
         System.out.println("");
          for(int i=0;i<adjacencyMatrix[0].length;i++)
         {
             System.out.print("--");
         }
          System.out.println("");
          
         for(int i=0;i<adjacencyMatrix[0].length;i++){
             System.out.print(i+"| ");
             for(int j=0;j<adjacencyMatrix[0].length;j++){
                    System.out.print(adjacencyMatrix[i][j]+" ");
             }
             System.out.println("");
         }
        do{
         System.out.println("Choose the form of routing:-");
         System.out.println("1.Link State Routing     2. Distance Vector Routing");
         int ch;
         ch=sc.nextInt();
         
         switch(ch){
             case 1:
                 for(int i=0;i<adjacencyMatrix[0].length;i++)
                    Dij.dijkstra(adjacencyMatrix,i); 
                Dij.dijkstra1(adjacencyMatrix, 0);
                 break;  
                 
             case 2: 
                 int V = 7;  
                 int E = 20;
                 Graph graph = new Graph(V, E);                  
                 int e=0;
                  for(int i=0;i<adjacencyMatrix[0].length;i++){
                      for(int j=0;j<adjacencyMatrix[0].length;j++){
                          if(adjacencyMatrix[i][j]!=0){
                            graph.edge[e].src=i;
                            graph.edge[e].dest=j;
                            graph.edge[e].weight=adjacencyMatrix[i][j];
                            e++;
                          }
                      }
                  }
                                    
                  graph.BellmanFord(graph, 0); 
                break; 
                 
         }
            System.out.println("Do you want to continue(press 1 for yes)");
            choice=sc.nextInt();
            System.out.println("____________________________________________");
        }while(choice==1);
        
    }   
}
