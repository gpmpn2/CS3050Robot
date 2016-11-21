
public class Obstacle {
	private int position;
	private int speed;
	private Direction direction; 
	private int[] pathTaken;
	private Grid grid; 
	private Direction nextDirection;
	private int nextPosition;
	
	public Obstacle(int position, int speed, Direction direction, Grid grid){
		this.position = position;
		this.speed = speed;
		this.direction = direction; 
		this.grid = grid;
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
	
	public void setPoisiton(int pos){
		position = pos;
	}
	
	public void setSpeed(int spe){
		speed = spe;
	}
	
	private void nextMove() {
		int size = grid.getSize();
		
		for(int i = 0; i< speed; i++) {
			int type = position % size;
			switch(direction) {
			case EAST:
				if( type == 0) {
					nextDirection = Direction.WEST; 
					nextPosition = position -1;
				}
				else {
					nextPosition = position +1; 
				}
				break;
			case WEST:
				if( type == 1 ) {
					nextDirection = Direction.EAST; 
					nextPosition = position +1;
				}
				else {
					nextPosition = position - 1; 
				}
				break;
			case NORTH:
				if( position <= size ) {
					nextDirection = Direction.SOUTH; 
					nextPosition = position + size;
				}
				else {
					nextPosition = position - size; 
				}
				break;
			case SOUTH:
				if( position >= ((size*size)-size) ) {
					nextDirection = Direction.NORTH; 
					nextPosition = position - size;
				}
				else {
					nextPosition = position + size; 
				}
				break;
			case NORTHEAST:
				if( position <= size) {
					if(type == 0) {
						nextDirection = Direction.SOUTHWEST;
						nextPosition = position + size -1;
					}
					else {
						nextDirection = Direction.SOUTHEAST; 
						nextPosition = position + size + 1;
					}
				}
				else if(type == 0) {
					nextDirection = Direction.NORTHWEST;
					nextPosition = position - size - 1;
				}
				else {
					nextPosition = position - size +1; 
				}
				break;
			case NORTHWEST:
				if( position <= size) {
					if(type == 1) {
						nextDirection = Direction.SOUTHEAST;
						nextPosition = position + size + 1;
					}
					else {
						nextDirection = Direction.SOUTHWEST; 
						nextPosition = position + size - 1;
					}
				}
				else if(type == 1) {
					nextDirection = Direction.NORTHEAST;
					nextPosition = position - size + 1;
				}
				else {
					nextPosition = position - size - 1; 
				}
				break;
			case SOUTHEAST:
				if( position >= ((size*size)-size)) {
					if(type == 0) {
						nextDirection = Direction.NORTHWEST;
						nextPosition = position - size -1;
					}
					else {
						nextDirection = Direction.NORTHEAST; 
						nextPosition = position - size + 1;
					}
				}
				else if(type == 0) {
					nextDirection = Direction.SOUTHWEST;
					nextPosition = position + size - 1;
				}
				else {
					nextPosition = position + size +1; 
				}
				break;
			case SOUTHWEST:
				if( position >= ((size*size)-size)) {
					if(type == 1) {
						nextDirection = Direction.NORTHEAST;
						nextPosition = position - size + 1;
					}
					else {
						nextDirection = Direction.NORTHWEST; 
						nextPosition = position - size - 1;
					}
				}
				else if(type == 1) {
					nextDirection = Direction.SOUTHEAST;
					nextPosition = position + size + 1;
				}
				else {
					nextPosition = position + size - 1; 
				}
				break;
			default:
				break;
			
			}
		}
		grid.setOccupiedVertice(position, true);
	}
	
	public void update() {
		grid.setOccupiedVertice(position, false);
		position = nextPosition;
		direction = nextDirection; 
		grid.setOccupiedVertice(position, true);
		nextMove();
	}
}
