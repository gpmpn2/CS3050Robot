

public class Run {
	
	public static void main(String args[]){
		//Creating an empty config
		Configuration config = new Configuration(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, -1, -1, -1);
		if(!LoadInput.readFile(config,args[0])){
			return;
		}
		
		int turnNumber = 1;
		int gameStatus = 0;
		
		int destination = LoadInput.findGridSpace(config, config.getEndX(), config.getEndY()); 
		int startR = LoadInput.findGridSpace(config, config.getStartX(), config.getStartY()); 
		int startO1 = LoadInput.findGridSpace(config, config.getStartObX(), config.getStartObY());
		int startO2 = LoadInput.findGridSpace(config, config.getStartObXTwo(), config.getStartObYTwo()); ;
		
		Grid grid = new Grid(config.getSize()); 
		grid.printGrid(startR, destination, startO1, startO2);
		
		Robot robot = new Robot(startR, destination, grid);
		Obstacle obstacle1 = new Obstacle(startO1, config.getSpeedOb(), config.determineDirection(config.getObDirNS(), config.getObDirEW()), grid);
		Obstacle obstacle2 = new Obstacle(startO2, config.getSpeedObTwo(), config.determineDirection(config.getObDirNSTwo(), config.getObDirEWTwo()), grid);
		
		
		grid.printGameState(robot.getPosition(), obstacle1.getPosition(), obstacle2.getPosition(), turnNumber);
		while((gameStatus = robot.gameOver()) == 0) {
			//this order is important because the robot uses the next position of the obstacles to plan 
			//its move. so it has to move first before the obstacles update their next Positions
			robot.move(obstacle1.getNextPosition(), obstacle2.getNextPosition());
			obstacle1.update();
			obstacle2.update();
			turnNumber++;
			grid.printGameState(robot.getPosition(), obstacle1.getPosition(), obstacle2.getPosition(), turnNumber);
		}
		if (gameStatus == 2) {
			robot.gameWon(); 
			System.out.println("Obstacle 1 took path " + obstacle1.getPathTaken());
			System.out.println("Obstacle 2 took path " + obstacle2.getPathTaken());
			System.exit(0);
		}
		else {
			robot.gameLost(); 
			System.out.println("Obstacle 1 took path " + obstacle1.getPathTaken());
			System.out.println("Obstacle 2 took path " + obstacle2.getPathTaken());
			System.exit(1);
		}
	}
}
