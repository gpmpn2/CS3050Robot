import java.util.ArrayList;

public class Robot {
	private final int speed = 1;
	private int position;
	private int destination;
	private ArrayList<Integer> path;
	private ArrayList<Integer> pathTaken;
	private int moveNumber = 1;
	private Grid grid; 
	
	public Robot(int position,int destination, Grid grid){
		this.position = position;
		this.destination = destination;
		this.grid = grid; 
		path = new ArrayList<Integer>();
		pathTaken = new ArrayList<Integer>(); 
		//grid.setOccupiedVertice(position, true);
		findPath();
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getDestination(){
		return destination;
	}
	
	public ArrayList<Integer> getPath(){
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
	private int stagnantCount;
	public void move(int nextPosition1, int nextPosition2) {
		//if the next vertice in the path is not going to be occupied next turn more to it. 
		if(nextPosition1 != path.get(moveNumber) && nextPosition2 != path.get(moveNumber)) {
			position = path.get(moveNumber); 
			moveNumber++;
		}
		else if(nextPosition1 != position && nextPosition2 != position) {
			if(stagnantCount < 4){
				pathTaken.add(moveNumber, position);
				stagnantCount +=1;
				return; 
			}
		}
		else {
			if(!findAlternatePath()) {
				System.out.println("No alternate path could be found. The Robot is trapped and accepts its imminate death.");
				return;
			}
			
		}
		pathTaken.add(position);
	}
	
	private void findPath() {
		path.clear();
		path.add(position);
		
		int nextNum = position; 
		int size = grid.getSize();
		int rangeStart, rangeEnd; 
		int modDestination = destination % size; 
		int diff = position - destination; 
		while(nextNum != destination) {
			int modNextNum = nextNum % size; 
			rangeStart = nextNum - modNextNum + 1; 
			rangeEnd = rangeStart + size -1; 
			if(destination >= rangeStart && destination <= rangeEnd ) {
				if(destination > nextNum) {
					nextNum++; 
				}
				else if(destination < nextNum) {
					nextNum--;
				}
			}
			else {
				if(diff >0) {
			
					if(modDestination > modNextNum) {
						nextNum = nextNum - size + 1;
					}
					else if(modDestination < modNextNum) {
						nextNum = nextNum - size - 1; 
					}
					else {
						nextNum = nextNum - size;
					}
				}
				else {
					if(modDestination > modNextNum) {
						nextNum = nextNum + size + 1;
					}
					else if(modDestination < modNextNum) {
						nextNum = nextNum + size - 1; 
					}
					else {
						nextNum = nextNum + size;
					}
				}
			}
			path.add(nextNum); 
		}
		
		pathTaken.add(position);
		moveNumber = 1; 
		return; 
	}
	
	//finds the best move that still gets us closer to the destination. Also runds findPath to update the optimal path from the new location. 
	private boolean findAlternatePath() {
		int size = grid.getSize();
		int diff = position - path.get(moveNumber);
		int modDestination = destination % size; 
		int modPosition = position % size; 
		int nextPos;
		if(diff > 0) {
			if(modDestination > modPosition) {
				nextPos = position - size +1; 
				if(nextPos == path.get(moveNumber)) {
					nextPos = position - size; 
				}
			}
			else {
				nextPos = position - size -1; 
				if(nextPos == path.get(moveNumber)) {
					nextPos = position - size; 
				}
			}
		}
		else {
			if(modDestination > modPosition) {
				nextPos = position + size +1; 
				if(nextPos == path.get(moveNumber)) {
					nextPos = position + size; 
				}
			}
			else {
				nextPos = position + size -1; 
				if(nextPos == path.get(moveNumber)) {
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
			System.out.println("The Robot made it to its destination! Game over :)");
			return 2; 
		}
		if(stagnantCount >=4){
			System.out.println("Escape is futile. Game over!");
			return 1;
		}
		return 0; 
	}
	
	private void printPathTaken() {
		System.out.print("The Robot took path: [");
		for(Integer temp: pathTaken) {
			System.out.print(grid.convertPosToOrderedPair(temp) + " ");
		}
		System.out.print("]\n");
	}
	
	public void gameWon() {
		System.out.println("The Robot won!");
		printPathTaken();
	}
	
	public void gameLost() {
		System.out.println("The Robot was killed by an obstacle");
		printPathTaken();
	}
	
}
