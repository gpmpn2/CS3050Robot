import java.util.LinkedList;

public class Vertice {
	private LinkedList<Edge> e;
	private boolean o;
	public Vertice(LinkedList<Edge> edge,boolean occupied){
		this.o = occupied;
		this.e = edge;
	}
	
	public LinkedList<Edge> getEdge(){
		return e;
	}
	
	public boolean getOccupied(){
		return o;
	}
	
	public void setStartV(boolean occ){
		o = occ;
	}
	
	public void setDestV(LinkedList<Edge> edge){
		e = edge;
	}
}
