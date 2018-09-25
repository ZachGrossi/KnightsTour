package edu.njit.Cryp71c;

import java.util.Stack;

/***************************
 * 
 * @author Zach Grossi
 * ID#:21839997
 * CS-288
 * Sect.: 102
 * Started On: 1/30/2012
 * "Finished" On: 2/13/2012
 *
 **************************/

public class Warnsdorff {

	public int[][] TourSolve(int boardSizeX, int boardSizeY, int startX, int startY) {
	
		//creates the move and position stacks as well as a top index
		Stack<Integer> moveStackX = new Stack<Integer>();
		Stack<Integer> moveStackY = new Stack<Integer>();
		Stack<Integer> positionStack = new Stack<Integer>();
		int topIndex = 0;
		
		//initiate multidimensional visited array and set all values to "false"
		boolean[][] visitedArray = new boolean[boardSizeX][boardSizeY];

		for (int x=0; x<boardSizeX; x++) {
			for (int y=0; y<boardSizeY; y++) {
				visitedArray[x][y] = false;
			}
		}
		
		//create the knight object
		Knight knight = new Knight();
		int currentX = startX;
		int currentY = startY;
		visitedArray[startX][startY] = true;
		moveStackX.push(currentX);
		moveStackY.push(currentY);
		topIndex++;
		int numMoves = 1;
		
		boolean differentPosition = false;
		int[] positionMoves = new int[8];
		
		//start navigating the board
		while ((numMoves < (boardSizeX * boardSizeY)) && (numMoves !=0)) {
			
			positionMoves = knight.checkMoves(visitedArray,currentX, currentY);
			
			//creates variables to store the values of the lowest number of moves and its position
			int lowestMovePos = -1;
			int tempLowest = 9;
			int previousPosition = -1;
			
			if (differentPosition) {
				previousPosition = positionStack.peek();
			}
			 
			//System.out.println("New");
			//System.out.println("diff: " + differentPosition);
			//System.out.println("temp low: " + tempLowest);

			for (int i=0; i<8; i++) {
				//System.out.println("i: " + i);
				//System.out.println("# moves: " + positionMoves[i]);
				if ((positionMoves[i] <= tempLowest) && (positionMoves[i] != 0) && (positionMoves[i] != -1) && (!differentPosition)) {
					tempLowest = positionMoves[i];
					lowestMovePos = i;
					
					//System.out.println("i: " + i);
				}
				if (differentPosition) {
					//System.out.println("previous " + previousPosition);
					if ((positionMoves[i] <= tempLowest) && (positionMoves[i] != 0) && (positionMoves[i] != -1) && (i != previousPosition)) {
						tempLowest = positionMoves[i];
						lowestMovePos = i;
					}
				}
			}
			
			//System.out.println("lowest move: " + lowestMovePos);			
			
			if (lowestMovePos != -1) {
				//position 0 = x-2, y-1
				if (lowestMovePos == 0) {
					currentX = currentX-2;
					currentY = currentY-1;
				}
				//position 1 = x-1, y-2
				if (lowestMovePos == 1) {
					currentX = currentX-1;
					currentY = currentY-2;
				}
				//position 2 = x+1, y-2
				if (lowestMovePos == 2) {
					currentX = currentX+1;
					currentY = currentY-2;
				}
				//position 3 = x+2, y-1
				if (lowestMovePos == 3) {
					currentX = currentX+2;
					currentY = currentY-1;
				}
				//position 4 = x+2, y+1
				if (lowestMovePos == 4) {
					currentX = currentX+2;
					currentY = currentY+1;
				}
				//position 5 = x+1, y+2
				if (lowestMovePos == 5) {
					currentX = currentX+1;
					currentY = currentY+2;
				}
				//position 6 = x-1, y+2
				if (lowestMovePos == 6) {
					currentX = currentX-1;
					currentY = currentY+2;
				}
				//position 7 = x-2, y+1
				if (lowestMovePos == 7) {
					currentX = currentX-2;
					currentY = currentY+1;
				}
				
				//adjust the necessary variables
				moveStackX.push(currentX);
				moveStackY.push(currentY);
				positionStack.push(lowestMovePos);
				visitedArray[currentX][currentY] = true;
				differentPosition = false;
				numMoves = numMoves + 1;
				topIndex = topIndex +1;
			}
	
			//System.out.print("num: " + numMoves + " X:" + currentX);
			//System.out.println(" Y:" + currentY);
			//System.out.println("");
			
			//check to see if there are no valid moves
			if (lowestMovePos == -1) {
				differentPosition = true;
				visitedArray[currentX][currentY] = false;
				currentX = moveStackX.peek();
				currentY = moveStackY.peek();
				topIndex = topIndex - 1;
			}
			
			if (moveStackX.isEmpty()) {
				topIndex = -7;
			}
			
		}
		
		//initiate single-dimensional final tour array
		int[][] finalTour = new int[boardSizeX * boardSizeY][2];
		
		if (topIndex == -7) {
			for (int x=0; x<(boardSizeX*boardSizeY);x++) {
				for (int y=0; y<2; y++) {
					finalTour[x][y] = 0;
				}
			}
		}else{
			//System.out.println("Length: " + moveStackX.size());
			
			for (int x=0; x<((boardSizeX*boardSizeY));x++) {
				finalTour[x][0] = moveStackX.pop();
				finalTour[x][1] = moveStackY.pop();
			}
			finalTour[(boardSizeX*boardSizeY)-1][0] = startX;
			finalTour[(boardSizeX*boardSizeY)-1][1] = startY;
		}
		
		return finalTour;
	}//end method
	
}//end class
