import java.util.ArrayList;

public class Robot {
	private final int speed = 1;
	private int position;
	private int destination;
	private ArrayList<Integer> path;
	private int[] pathTaken;
	int turnNumber = 0;
	private Grid grid; 
	
	public Robot(int position,int destination, Grid grid){
		this.position = position;
		this.destination = destination;
		this.grid = grid; 
		//grid.setOccupiedVertice(position, true);
		findPath();
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getDestination(){
		return destination;
	}
	
	public ArrayList getPath(){
		return path;
	}
	
	
	public void setPosition(int pos){
		position = pos;
	}
	
	public void setDestination(int dest){
		destination = dest;
	}
	
	//if the next postition of the obstacles will not be in the optimal path, then move there. 
	//if they are going to be in the path, then stay put, 
	//if they are going to be in the path and in positon of the robot, find an alternate path. 
	public void move(int nextPosition1, int nextPosition2) {
		//if the next vertice in the path is not going to be occupied next turn more to it. 
		if(nextPosition1 != path.get(turnNumber) && nextPosition2 != path.get(turnNumber)) {
			//grid.setOccupiedVertice(position, false);
			position = path.get(turnNumber); 
			//grid.setOccupiedVertice(position, true);
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
	}
	
	private void findPath() {
		path = new ArrayList<Integer>(4);
		path.add(2);
		path.add(8);
		path.add(14);
		path.add(19);
		turnNumber = 1; 
		return; 
	}
	//finds the best move that still gets us closer to the destination. Also runds findPath to update the optimal path from the new location. 
	private boolean findAlternatePath() {
		int size = grid.getSize();
		int diff = position - path.get(turnNumber);
		int modDestination = destination % size; 
		int modPosition = position % size; 
		int nextPos;
		if(diff > 0) {
			if(modDestination > modPosition) {
				nextPos = position - size +1; 
				if(nextPos == path.get(turnNumber)) {
					nextPos = position - size; 
				}
			}
			else {
				nextPos = position - size -1; 
				if(nextPos == path.get(turnNumber)) {
					nextPos = position - size; 
				}
			}
		}
		else {
			if(modDestination > modPosition) {
				nextPos = position + size +1; 
				if(nextPos == path.get(turnNumber)) {
					nextPos = position + size; 
				}
			}
			else {
				nextPos = position + size -1; 
				if(nextPos == path.get(turnNumber)) {
					nextPos = position + size; 
				}
			}
		}
		position = nextPos;
		findPath();
		return true; 
	}
	
	public int gameOver() {
		if( grid.getVertices().get(position-1).getOccupied()) {
			System.out.println("How did this happen? The robot has been hit by and obstacle. Game over :("); 
			return 1; 
		}
		if(position == destination) {
			System.out.println("The RObot made it to its destination! Game over :)");
			return 2; 
		}
		return 0; 
	}
	
	public void gameWon() {
		System.out.println("The Robot won!");
	}
	
	public void gameLost() {
		System.out.println("The Robot was killed by an obstacle");
	}
}
