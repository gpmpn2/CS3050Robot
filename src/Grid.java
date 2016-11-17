
public class Grid {

	private Vertice[] v;
	private int size;
	public Grid(int size,Vertice[] vertices){
		this.size = size;
		this.v = vertices;
	}
	
	public int getSize(){
		return size;
	}
	
	public Vertice[] getVertices(){
		return v;
	}
	
	public void setStartV(int s){
		size = s;
	}
	
	public void setDestV(Vertice[] vert){
		v = vert;
	}

}
