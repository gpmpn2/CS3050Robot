import java.util.ArrayList;

public class Obstacle {
	private static int numObstacles = 0;
	private String name;
	private int position;
	private int speed;
	private Direction direction; 
	private ArrayList<Integer> pathTaken;
	private Grid grid; 
	private Direction nextDirection;
	private int nextPosition;
	
	public Obstacle(int position, int speed, Direction direction, Grid grid){
		numObstacles++;
		this.position = position;
		this.speed = speed;
		this.direction = direction; 
		this.grid = grid;
		this.name = "Obstacle " + numObstacles;
		pathTaken = new ArrayList<Integer>(); 
		pathTaken.add(position);
		grid.setOccupiedVertice(position, true);
		nextMove();
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getNextPosition() {
		return nextPosition; 
	}
	
	public ArrayList<Integer> getPathTaken() {
		return pathTaken;
	}
	
	public void setPoisiton(int pos){
		position = pos;
	}
	
	public void setSpeed(int spe){
		speed = spe;
	}
	
	private void nextMove() {
		int size = grid.getSize();
		int posHolder = position; 
		Direction dirHolder = direction;
		
		for(int i = 0; i< speed; i++) {
			int type = position % size;
			switch(direction) {
			case EAST:
				if( type == 0) {
					direction = Direction.WEST; 
					position = position -1;
				}
				else {
					position = position +1; 
				}
				break;
			case WEST:
				if( type == 1 ) {
					direction = Direction.EAST; 
					position = position +1;
				}
				else {
					position = position - 1; 
				}
				break;
			case NORTH:
				if( position <= size ) {
					direction = Direction.SOUTH; 
					position = position + size;
				}
				else {
					position = position - size; 
				}
				break;
			case SOUTH:
				if( position >= ((size*size)-size) ) {
					direction = Direction.NORTH; 
					position = position - size;
				}
				else {
					position = position + size; 
				}
				break;
			case NORTHEAST:
				if( position <= size) {
					if(type == 0) {
						direction = Direction.SOUTHWEST;
						position = position + size -1;
					}
					else {
						direction = Direction.SOUTHEAST; 
						position = position + size + 1;
					}
				}
				else if(type == 0) {
					direction = Direction.NORTHWEST;
					position = position - size - 1;
				}
				else {
					position = position - size +1; 
				}
				break;
			case NORTHWEST:
				if( position <= size) {
					if(type == 1) {
						direction = Direction.SOUTHEAST;
						position = position + size + 1;
					}
					else {
						direction = Direction.SOUTHWEST; 
						position = position + size - 1;
					}
				}
				else if(type == 1) {
					direction = Direction.NORTHEAST;
					position = position - size + 1;
				}
				else {
					position = position - size - 1; 
				}
				break;
			case SOUTHEAST:
				if( position >= ((size*size)-size)) {
					if(type == 0) {
						direction = Direction.NORTHWEST;
						position = position - size -1;
					}
					else {
						direction = Direction.NORTHEAST; 
						position = position - size + 1;
					}
				}
				else if(type == 0) {
					direction = Direction.SOUTHWEST;
					position = position + size - 1;
				}
				else {
					position = position + size +1; 
				}
				break;
			case SOUTHWEST:
				if( position >= ((size*size)-size)) {
					if(type == 1) {
						direction = Direction.NORTHEAST;
						position = position - size + 1;
					}
					else {
						direction = Direction.NORTHWEST; 
						position = position - size - 1;
					}
				}
				else if(type == 1) {
					direction = Direction.SOUTHEAST;
					position = position + size + 1;
				}
				else {
					position = position + size - 1; 
				}
				break;
			default:
				break;
			
			}
		}
		nextPosition = position; 
		nextDirection = direction; 
		position = posHolder; 
		direction = dirHolder; 
	}
	
	public void update() {
		grid.setOccupiedVertice(position, false);
		position = nextPosition;
		direction = nextDirection; 
		grid.setOccupiedVertice(position, true);
		pathTaken.add(position);
		nextMove();
	}
	public void printPathTaken() {
		System.out.print(name + " took path: [");
		for(Integer temp: pathTaken) {
			System.out.print(grid.convertPosToOrderedPair(temp) + " ");
		}
		System.out.print("]\n");
	}

}
