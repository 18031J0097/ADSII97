package week2pc;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

class Edge 

{
	int v; int w;

	 double weight;
	 Edge(int v, int w, double weight)
	 {
	 this.v = v;
	 this.w = w;
	 this.weight = weight;
	 }
	 public int v() 
	 { 
		 return v; 
		 }

	 public int w()

	 {
		 return w;
		 }

	 public double weight()

	 { 
		 return  weight; 
		 }

@Override

	public String toString() {

		return  " "+v + "-" + w + "  " + (float)weight +"0000"+"  ";

	}

}

class Graph

{
  int V,c=0;
  ArrayList<Edge>[] adj;
  public Graph(int V)
  {
	  this.V = V;
	  adj = (ArrayList<Edge>[]) new ArrayList[V+1];
	  for (int v = 0; v <=V; v++)
		  adj[v] = new ArrayList<Edge>();
	  }

 public void addEdge(int v,int w,double w2)
 {
	 c++;
	 Edge e=new Edge(v,w,w2);
	 Edge e1=new Edge(v,w,w2);
	 int v1 = e.v();
	 int w1=e.v();
	 int wa1=e.w();
	 adj[v1].add(e);
	 adj[wa1].add(e1);
 }

 public Iterable<Edge> adj(int v)
 { 
	 return adj[v]; 
	 }

 int V()
 {
	  return V;
 }

 public void display()

 {
	 System.out.println(V+" vertices "+c+" edges");

	 for(int i = 0;i<V-1;i++)
	 {
		 System.out.print(i +" :");

		 for(int j=adj[i].size()-1;j>=0;j--)

		 {
			System.out.print(adj[i].get(j));
		 }
		 System.out.println();
	 }
 }
 void floydWarshall(int graph[][]) 
 { 
     int dist[][] = new int[V][V]; 
     int i, j, k; 


     for (i = 0; i < V; i++) 
         for (j = 0; j < V; j++) 
             dist[i][j] = graph[i][j]; 

    
     for (k = 0; k < V; k++) 
     { 
    
         for (i = 0; i < V; i++) 
         { 
           
             for (j = 0; j < V; j++) 
             { 

                 if (dist[i][k] + dist[k][j] < dist[i][j]) 
                     dist[i][j] = dist[i][k] + dist[k][j]; 
             } 
         } 
     } 

     printSolution(dist); 
 } 

 void printSolution(int dist[][]) 
 { 
	 int INF=9999;
     System.out.println("The following matrix shows the shortest "+ "distances between every pair of vertices"); 
     for (int i=0; i<V; ++i) 
     { 
         for (int j=0; j<V; ++j) 
         { 
             if (dist[i][j]==INF) 
                 System.out.print("INF "); 
             else
                 System.out.print(dist[i][j]+"   "); 
         } 
         System.out.println(); 
     } 
 } 

}

public class Solution {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
	     int n1 = sc.nextInt();
	     int n2 = sc.nextInt();
	     Graph g = new Graph(n1);
	     String str[] = new String[3];
	     for(int i=0;i<=n2;i++)
	     {
	    	 String s = sc.nextLine();
	    	 if(!s.equals("")) {
				 str = s.split(" ");}
	    	 if(str[0]!=null&&str[1]!=null&&str[2]!=null) {
	    	 g.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
	    	 }

	     }

	     String op= sc.nextLine();

	     switch(op)

			{

				case "Graph":
				{
		    	     g.display();
		             break;
				}
				case "DirectedPaths":
				{
					break;
				}
				case "ViaPaths":
				{
					break;
				}
			}
	}
}
