

import java.io.*;
import java.util.Map.Entry;
import java.util.*;


/**
 * Adjacency matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class AdjMatrix <T extends Object> implements FriendshipGraph<T>
{

	/**
	 * Contructs empty graph.
	 */
	int size;
	boolean[][] aM;
	Map<String,Integer> m;
	
	
	@SuppressWarnings("unchecked")
	public AdjMatrix() {
    	size = 0;
    	m = new HashMap();
    	aM = new boolean[size][size];
    } // end of AdjMatrix()
    
    private boolean[][] copyMatrix(boolean[][] m){
    	boolean[][] newMatrix = new boolean[size][size];
    	for(int x=0; x<size-1; x++){
    		for(int y=0; y<size-1; y++){
    			newMatrix[x][y] = m[x][y];
    		}
    	}
    	return newMatrix;
    }
	
	public void addVertex(T vertLabel) {
    	if(size == 0){
	        m.put((String)vertLabel, size);
	        size++;
	    	aM = new boolean[size][size];
	    	
    	}
    	else{
    		m.put((String)vertLabel, size);
    		size++;
    		aM = copyMatrix(aM);
    	}
    	
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
    	int tar = (int)m.get((String)tarLabel),
    		src = (int)m.get((String)srcLabel);
    	
    	if(aM[src][tar] != true){
    		if(srcLabel == tarLabel){
	    		aM[src][tar] = true;
	    	}
	    	else{
				aM[src][tar] = true;
				aM[tar][src] = true;
	    	}
    	}
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
        
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        for(Map.Entry e : m.entrySet()){
        	
        	String key = (String)e.getKey();
        	
        	if(key.matches((String)vertLabel)){
        		int index = (int)e.getValue();
        		
        		for(int x=(index-1); x>=0; x--){
        			for(int y=(index-1); y>=0; y--){
        				aM[x][y] = aM[x+1][y+1];
        			}
        		}
        		m.remove(key);
            	break;
        	}
        }

    	
    	
    	
    	
    	
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
    	int tar = (int)m.get((String)tarLabel),
    		src = (int)m.get((String)srcLabel);
    	
    	if(aM[src][tar] != false){
    		
	    	if(srcLabel == tarLabel){
	    		aM[src][tar] = false;
	    	}
	    	else{
				aM[src][tar] = false;
				aM[tar][src] = false;
	    	}
    	}

    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
    	for(Map.Entry entry : m.entrySet()){
    		os.print(entry.getKey()+" ");
    	}
    	os.println();
    } // end of printVertices()
	
    
    @SuppressWarnings("rawtypes")
	public void printEdges(PrintWriter os) {
		int x, y;
		
		for(Map.Entry entry: m.entrySet()){
			x = (int)entry.getValue();
			os.print(entry.getKey()+" ");
			for(Map.Entry entry2: m.entrySet()){
				y = (int)entry2.getValue();
				if(aM[x][y] == true && aM[y][x] == true){
					os.print(entry2.getKey()+" ");
				}
			}
			os.println();
		}
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class AdjMatrix