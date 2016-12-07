import java.util.LinkedList;


public class Vertice {
	//private LinkedList<Edge> e;
	private boolean o;
	private VerticeType type;
	private int number; 
	
	public Vertice(VerticeType type, boolean occupied, LinkedList<Edge> edge, int num) {
		this.o = occupied;
		//this.e = edge;
		this.type = type; 
		number = num; 
	}
	
	/*public LinkedList<Edge> getEdge(){
		return e;
	}*/
	
	public boolean getOccupied(){
		return o;
	}
	public VerticeType VerticeType() {
		return type;
	}
	
	//public void setStartV(boolean occ){
	//	o = occ;
	//}
	
	/*public void setDestV(LinkedList<Edge> edge){
		e = edge;
	}*/
	public void setOccupied(boolean x) {
		o = x; 
	}
	public String toString() {
		return number+"\n";
	}
}
