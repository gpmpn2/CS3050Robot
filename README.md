# CS3050Robot
CS3050 - Final Project
Rohit Chadha
Grant Maloney - Loading Functionality, Error Checking
Chris Whetsel - Movement Algorithms

# Pre-project Discussion
Before the project started, we got together and talked through how the project was to function. We also decided to create the project via Git. Git allowed us to simultaneously program on the project and then merge our code into one after pushing it to a repository. Our functionality was pretty straight forward and follows as such: Load/Parse data, Error check data, create a X by Y Grid, create Objects of type Robot and Obstacle, get the Robot from one Vertice to another Vertice without hitting an Obstacle. The first meeting over the project, all classes were created with their corrisponding constructors.

# Loading Sequence (Grant)
Going through the description file on Black Board, it was determined that the input file would always have the same layout. I created a "Configuration" class, the goal of this class was to store all of the data from the input file to be used throughout the program. Another file was created "LoadInput", the goal of this class was to run through the data inside the input file and store it in the corresponding data type inside the Configuration constructor. Having a constructor with all this data allowed us to get and set data easily, and only read the input file once. "LoadInput" also contains a method to find the corresponding Grid space, given an x and y coordinate. So if you were on coordinate 5,7 on a 10 x 10 Grid, the corresponding Grid space would be 47.

# Error Checking Sequence (Grant)
The main file used for error checking was "DataChecker" as well as some error checking inside the "LoadInput" class. "DataChecker" checks for comma's not positioned correctly, parentheses not at the beginning of the and end of the lines that need them. It also checks for numbers that are two big for the grid. For example, and grid of size 10 x 10 can only at most have an Object at position (10,10). So if there is a line with an Object at 11,10 for example, this would cause and error and is therefore checked in the "DataChecker" class. The "LoadInput" class also has some checking, such as checking to make sure that the size of the Grid is greater than 1, as you can't have a 1 x 1 Grid. 

# Movement Sequence (Chris)
The grid NxN grid was thought of as graph of N x N vertices with edges between all squares that are adjacent. The path was found from the robot's start vertex to the destination vertex using a DFS to find the shortest path to the destination. The findPath method starts at the position of the Robot when the method is called and proceeds to add the vertex numbers of each vertex it passes through to an ArrayList path. It is compexity of O(n) where n is the size of the grid. During the game, when the Robot is making its move, it moves to the next Vertex in the ArrayList path if no Obstacle is going to be there, stays put if there is going to be a Obstacle in its path, or calls findAlternatePath() if there will be an Obstacle in its path and in its current positoin. findAlternatePath() takes a constant time + O(n) where n is the size of Grid because it calls findPath(). It finds an alternate next Vertex to move to that gets the Robot closer to the destination that is not in the Path then calls findPath from that new Vertex. It continues this process until it reaches the destination or gets hit by an obstacle. The robot should never get hit by an obstacle because it knows the next location of the Obstacles and can avoid them if there are only two obstacles. 

The program handles the chance where the RObot gets stuck into a loop. If the destination vertex is occupied by a Obstacle for 4 turns in a row, that means the Obstacles are in a movement pattern that means there will always be an Obstacle on the destination, so the robot can never reach it. Also, the robot should take Theta(n) moves to reach the destination where n is the size of the grid, so if it is taking much longer than that the program also exits as a safe gaurd for it getting into a loop. We cut it off at 10 x n moves. The Robot's move method takes O(n) time if it has to call findAlternatePath otherwise it is a constant time. 

The Obstacles move methods takes O(s) where s is the speed of the Obstacle. It runs its mvoe method s times because the move method moves it one vertice in the direction the Obstacle is currently moving, handling it hitting walls. 

#Overall Complexity
The program runs in O(n^2) time where n is the size of the grid. The set up of the grid takes O(n^2) and moving the robot to the destination takes at worst n^2 time as well. Thus, the time complexity is O(n^2) where n is the size of the grid. 
