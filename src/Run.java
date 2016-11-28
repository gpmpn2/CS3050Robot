

public class Run {
	
	public static void main(String args[]){
		//Creating an empty config
		Configuration config = new Configuration(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, -1, -1, -1);
		LoadInput.readFile(config,"input.txt");
		int turnNumber = 1;
		int gameStatus = 0;
		int destination = LoadInput.findGridSpace(config, config.getStartX(), config.getStartY()); 
		int startR = config.getStartX(), startO1 = LoadInput.findGridSpace(config, config.getStartObX(), config.getStartObY()), startO2 = LoadInput.findGridSpace(config, config.getStartObXTwo(), config.getStartObYTwo()); ;
		
		Grid grid = new Grid(config.getSize()); 
		grid.printGrid(startR, destination, startO1, startO2);
		
		Robot robot = new Robot(startR, destination, grid);
		Obstacle obstacle1 = new Obstacle(startO1, config.getSpeedOb(), Direction.NORTH, grid);
		Obstacle obstacle2 = new Obstacle(startO2, config.getSpeedObTwo(), Direction.WEST, grid);
		
		
		grid.printGameState(robot.getPosition(), obstacle1.getPosition(), obstacle2.getPosition(), turnNumber);
		while((gameStatus = robot.gameOver()) == 0) {
			//this order is important because the robot uses the next position of the obstacles to plan 
			//its move. so it has to move first before the robots update their next Positions
			robot.move(obstacle1.getNextPosition(), obstacle2.getNextPosition());
			obstacle1.update();
			obstacle2.update();
			turnNumber++;
			grid.printGameState(robot.getPosition(), obstacle1.getPosition(), obstacle2.getPosition(), turnNumber);
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
