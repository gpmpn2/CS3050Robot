
public class Robot {
	private final int speed = 1;
	private int position;
	private int destination;
	private int[] path;
	private int[] pathTaken;
	public Robot(int position,int destination,int[] path){
		this.position = position;
		this.destination = destination;
		this.path = path;
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getDestination(){
		return destination;
	}
	
	public int[] getPath(){
		return path;
	}
	
	public void setPosition(int pos){
		position = pos;
	}
	
	public void setDestination(int dest){
		destination = dest;
	}
	
	public void setPath(int[] root){
		path = root;
	}
}
