
public class Obstacle {
	private int position;
	private int speed;
	private int[] pathTaken;
	public Obstacle(int position,int speed){
		this.position = position;
		this.speed = speed;
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setPoisiton(int pos){
		position = pos;
	}
	
	public void setSpeed(int spe){
		speed = spe;
	}
}
