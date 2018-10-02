# ArtificialIntelligence
This is a project by Ethan Malo, Zan Rost-Montieth, and Colter Fretwell for CSCI 446 Artificial Intellence at Montana State University.
The objective of this project is to search input mazes with various search algorithms.
The algorithms used in this project are breadth first search, depth first search, greedy best-first search, and A* search.
This project was developed using java in the Intellij IDEA.

Assignment:
Description
1.1 Basic pathfinding
Consider the problem of finding the shortest path from a given start state to the one star or "food pellet". 
The image at the top of this page illustrates th e simple scenario of a single food pellet, which in this case can be viewed as the unique goal state. 
The maze layout will be given to you in a simple text format, where '%' stands for walls, 'P' for the starting position, and '*' for the food pellet/star.  
All step costs are equal to one.Implement the state representation, transition model, and goal test needed for solving the problem. 
For the state representation, besides your current position in the maze, is there anything else you need to keep track of? 
Next, implement a unified top-level search routine that can work with all of the following search strategies, as covered in class:
•Depth-first search;
•Breadth-first search;
•Greedy best-first search;
•A* search.
For this part of the assignment, use the Manhattan distance from the current position to the goal as the heuristic function for greedy and A* search.
