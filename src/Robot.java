
public class Robot {
	private final int speed = 1;
	private int position;
	private int destination;
	private int[] path;
	private int[] pathTaken;
	int turnNumber = 0;
	private Grid grid; 
	
	public Robot(int position,int destination,int[] path, Grid grid){
		this.position = position;
		this.destination = destination;
		this.path = path;
		this.grid = grid; 
		grid.setOccupiedVertice(position, true);
		findPath();
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
	//if the next postition of the obstacles will not be in the optimal path, then move there. 
	//if they are going to be in the path, then stay put, 
	//if they are going to be in the path and in positon of the robot, find an alternate path. 
	private void move(int nextPosition1, int nextPosition2) {
		//if the next vertice in the path is not going to be occupied next turn more to it. 
		if(nextPosition1 != path[turnNumber] && nextPosition2 != path[turnNumber]) {
			grid.setOccupiedVertice(position, false);
			position = path[turnNumber]; 
			grid.setOccupiedVertice(position, true);
			turnNumber++; 
		}
		else if(nextPosition1 != position && nextPosition2 != position) {
			return; 
		}
		else {
			if(!findAlternatePath()) {
				System.out.println("No alternate path could be found. The Robot is trapped and accepts its imminate death.");
				return;
			}
			
			
		}
		if(grid.getVertices().get(path[turnNumber]).getOccupied()) {
			
		}
	}
	
	private void findPath() {
		return; 
	}
	//finds the best move that still gets us closer to the destination. Also runds findPath to update the optimal path from the new location. 
	private boolean findAlternatePath() {
		int diff = position - path[turnNumber];
		findPath();
		return true; 
	}
}
