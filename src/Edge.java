//edge class
public class Edge {
	private int startV;
	private int destV;
	public Edge(int startVert,int destVert){
		this.startV = startVert;
		this.destV = destVert;
	}
	
	public int getStartV(){
		return startV;
	}
	
	public int getDestV(){
		return destV;
	}
	
	public void setStartV(int startVert){
		startV = startVert;
	}
	
	public void setDestV(int destVert){
		destV = destVert;
	}
}
