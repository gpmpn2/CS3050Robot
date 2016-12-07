import java.util.ArrayList;
import java.util.LinkedList;


public class Grid {

	private ArrayList<Vertice> v;
	private int size;
	private int destinationVertex; 
	private int loopCounter = 0; 
	
	public Grid(int size, int dest){
		this.size = size;
		destinationVertex = dest;
		setUpGraph();
	}
	
	public int getSize(){
		return size;
	}
	
	public ArrayList<Vertice> getVertices(){
		return v;
	}
	
	public void printGrid(int startR, int destination, int startO1, int startO2) {
			//System.out.println(v);
		int x = 1; 
		for(int i = 1; i<=size; i++) {
			for(int j = 1; j<=size; j++) {
				if(x == startR) {
					System.out.print("R ");
					x++;
				}
				else if (x == destination) {
					System.out.print("D ");
					x++;
				}
				else if (x == startO1) {
					System.out.print("O ");
					x++;
				}
				else if (x == startO2) {
					System.out.print("O ");
					x++;
				}
				else {
					System.out.print(x + " ");
					x++;
				}
			}
			System.out.println("");
		}
	}
	
	public void setOccupiedVertice(int position, boolean occupied) {
		v.get(position-1).setOccupied(occupied); 
	}
	
	private void setUpGraph() {
		v = new ArrayList<Vertice>(this.size);
		int n = size*size; 
		LinkedList<Edge> edge = null; 
		
		
		for(int i = 1; i<=n; i++) {
			VerticeType type = determineEdgeType(i);
			//edge = setUpEdgeList(type, i); 
			v.add(new Vertice(type, false, edge, i));
			
			
		}
	}
	
	
	
	/* determines if the Vertice to be added is a corner, edge, or middle Vertice */
	private VerticeType determineEdgeType(int i) {
		
		int mod = i%size;
		
		if(mod == 1) {
			if(i==1) {
				//it is the top corner
				return VerticeType.TOPLEFT;
			}
			if( i == (((size*size) - size) +1 )) {
				//it is the bottom left corner 
				return VerticeType.BOTTOMLEFT;
			}
			//else it is a left edge
			return VerticeType.LEFTEDGE;
		}
		else if( mod == 0) {
			if( i == size) {
				return VerticeType.TOPRIGHT;
			}
			if(i== (size*size)) {
				return VerticeType.BOTTOMRIGHT;
			}
			return VerticeType.RIGHTEDGE; 
		}
		else {
			if( i < size) {
				return VerticeType.TOPEDGE;
			}
			else if( (i > (((size*size) - size) +1 )) && (i < (size*size)) ) {
				return VerticeType.BOTTOMEDGE; 
			}
			else {
				return VerticeType.MIDDLE; 
			}
		}
	}



private LinkedList<Edge> setUpEdgeList(VerticeType type, int i) {
	LinkedList<Edge> edges = new LinkedList<>();
	/*
	if(size == 1) {
		edges.add(new Edge(1,1));
		return edges; 
	}
	switch(type) {
	case BOTTOMEDGE: 
		edges.add(new Edge(i, i-1)); 
		edges.add(new Edge(i, i-size-1)); 
		edges.add(new Edge(i, i-size)); 
		edges.add(new Edge(i, i-size+1)); 
		edges.add( new Edge(i, i+1)); 
		break;
	case BOTTOMLEFT:
		edges.add(new Edge(i, i-size)); 
		edges.add(new Edge(i, i-size+1)); 
		edges.add( new Edge(i, i+1)); 
		break;
	case BOTTOMRIGHT:
		edges.add(new Edge(i, i-size)); 
		edges.add(new Edge(i, i-size-1)); 
		edges.add( new Edge(i, i-1)); 
		break;
	case LEFTEDGE:
		edges.add(new Edge(i, i-size)); 
		edges.add(new Edge(i, i+1-size)); 
		edges.add(new Edge(i, i+1)); 
		edges.add(new Edge(i, i+1+size)); 
		edges.add( new Edge(i, i+size)); 
		break;
	case MIDDLE:
		edges.add(new Edge(i, i-1)); 
		edges.add(new Edge(i, i-size-1)); 
		edges.add(new Edge(i, i-size)); 
		edges.add(new Edge(i, i-size+1)); 
		edges.add( new Edge(i, i+1)); 
		edges.add(new Edge(i, i+size+1)); 
		edges.add(new Edge(i, i+size)); 
		edges.add( new Edge(i, i+size-1)); 
		break;
	case RIGHTEDGE:
		edges.add(new Edge(i, i-size)); 
		edges.add(new Edge(i, i-1-size)); 
		edges.add(new Edge(i, i-1)); 
		edges.add(new Edge(i, i-1+size)); 
		edges.add( new Edge(i, i+size)); 
		break;
	case TOPEDGE:
		edges.add(new Edge(i, i-1)); 
		edges.add(new Edge(i, i+size-1)); 
		edges.add(new Edge(i, i+size)); 
		edges.add(new Edge(i, i+size+1)); 
		edges.add( new Edge(i, i+1)); 
		break;
	case TOPLEFT:
		edges.add(new Edge(i, i+size)); 
		edges.add(new Edge(i, i+size+1)); 
		edges.add( new Edge(i, i+1)); 
		break;
	case TOPRIGHT:
		edges.add(new Edge(i, i+size)); 
		edges.add(new Edge(i, i+size-1)); 
		edges.add( new Edge(i, i-1)); 
		break;
	default:
		break;
	
	}*/
	return edges; 
}

	public boolean checkForInfiniteLoop() {
		if(v.get(destinationVertex-1).getOccupied() == true) {
			loopCounter++;
			if(loopCounter > 3) {
				return true;
			}
		}
		else {
			loopCounter = 0; 
		}
		return false; 
	}
	
	public void printGameState(int robotPos, int obstaclePos1, int obstaclePos2, int turnNumber) {
		System.out.println(turnNumber + "-> " + "Robot: " + convertPosToOrderedPair(robotPos) + " Obstacle1: " + convertPosToOrderedPair(obstaclePos1) + " Obstacle2: " + convertPosToOrderedPair(obstaclePos2) );
	}
	
	public String convertPosToOrderedPair(int pos) {
		String OP; 
		int x, y, mod;
		y = pos%size; 
		x = ((int)pos/size) +1; 
		if(y == 0) {
			y = size; 
			x = (int) (pos/size); 
		}
		
		
		OP ="(" + x + "," + y + ")"; 
		return OP; 
	}
}