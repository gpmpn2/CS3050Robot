

public class Run {
	
	public static void main(String args[]){
		
		//addition
		Grid grid = new Grid(5); 
		//grid.printGrid();
		Robot robot = new Robot(2, 19, grid);
		Obstacle obstacle1 = new Obstacle(1, 1, Direction.NORTH, grid);
		Obstacle obstacle2 = new Obstacle(3, 1, Direction.WEST, grid);
		
		int turnNumber = 1;
		int gameStatus;
		grid.printGameState(robot.getPosition(), obstacle1.getPosition(), obstacle2.getPosition(), turnNumber);
		while((gameStatus = robot.gameOver()) == 0) {
			//this order is important because the robot uses the next position of the obstacles to plan 
			//its move. so it has to move first before the robots update their next Positions
			robot.move(obstacle1.getNextPosition(), obstacle2.getNextPosition());
			obstacle1.update();
			obstacle2.update();
			grid.printGameState(robot.getPosition(), obstacle1.getPosition(), obstacle2.getPosition(), turnNumber);
			turnNumber++;
		}
		if (gameStatus == 2) {
			robot.gameWon(); 
			System.exit(0);
		}
		else {
			robot.gameLost(); 
			System.exit(1);
		}
	}
}
