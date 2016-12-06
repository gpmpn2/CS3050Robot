# CS3050Robot
CS3050 - Final Project
Rohit Chadha
Grant Maloney - Loading Functionality, Error Checking
Chris Whetsel - Movement Algorithms

# Pre-project Discussion
Before the project started, we got together and talked through how the project was to function. We also decided to create the project via Git. Git allowed us to simultaneously program on the project and then merge our code into one after pushing it to a repository. Our functionality was pretty straight forward and follows as such: Load/Parse data, Error check data, create a X by Y Grid, create Objects of type Robot and Obstacle, get the Robot from one Vertice to another Vertice without hitting an Obstacle. The first meeting over the project, all classes were created with their corrisponding constructors.

# Loading Sequence (Grant)
Going through the description file on Black Board, it was determined that the input file would always have the same layout. I created a "Configuration" class, the goal of this class was to store all of the data from the input file to be used throughout the program. Another file was created "LoadInput", the goal of this class was to run through the data inside the input file and store it in the corresponding data type inside the Configuration constructor. Having a constructor with all this data allowed us to get and set data easily, and only read the input file once. "LoadInput" also contains a method to find the corresponding Grid space, given an x and y coordinate. So if you were on coordinate 5,7 on a 10 x 10 Grid, the corresponding Grid space would be 65.

# Error Checking Sequence (Grant)
The main file used for error checking was "DataChecker" as well as some error checking inside the "LoadInput" class. "DataChecker" checks for comma's not positioned correctly, parentheses not at the beginning of the and end of the lines that need them. It also checks for numbers that are two big for the grid. For example, and grid of size 10 x 10 can only at most have an Object at position (10,10). So if there is a line with an Object at 11,10 for example, this would cause and error and is therefore checked in the "DataChecker" class. The "LoadInput" class also has some checking, such as checking to make sure that the size of the Grid is greater than 1, as you can't have a 1 x 1 Grid. 

# Movement Sequence (Chris)

