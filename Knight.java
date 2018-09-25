package edu.njit.Cryp71c;
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

public class Knight {

	public int[] checkMoves(boolean visitedArray[][], int currentX, int currentY) {
		
		//initiate the number of possible moves array
		int[] positionMoves = new int[8];
		int boardSizeX = visitedArray.length;
		int boardSizeY = visitedArray[0].length;
		
		//check all legal moves for all possible moves
		//check position 0
		if ( (currentX - 2) >= 0 && (currentY - 1) >= 0 ) {
			if ( visitedArray[currentX-2][currentY-1] == false ) {
				positionMoves[0] = possibleMoves(currentX-2, currentY-1, visitedArray);
			}else{
				positionMoves[0] = 0;
			}
		}else{
			positionMoves[0] = 0;
		}

		//check position 1
		if ( (currentX - 1) >= 0 && (currentY - 2) >= 0 ) {
			if ( visitedArray[currentX-1][currentY-2] == false ) {
				positionMoves[1] = possibleMoves(currentX-1, currentY-2, visitedArray);
			}else{
				positionMoves[1] = 0;
			}
		}else{
			positionMoves[1] = 0;
		}

		//check position 2
		if ( (currentX + 1) < boardSizeX && (currentY - 2) >= 0 ) {
			if ( visitedArray[currentX+1][currentY-2] == false ) {
				positionMoves[2] = possibleMoves(currentX+1, currentY-2, visitedArray);
			}else{
				positionMoves[2] = 0;
			}
		}else{
			positionMoves[2] = 0;
		}

		//check position 3
		if ( (currentX + 2) < boardSizeX && (currentY - 1) >= 0 ) {
			if ( visitedArray[currentX+2][currentY-1] == false ) {
				positionMoves[3] = possibleMoves(currentX+2, currentY-1, visitedArray);
			}else{
				positionMoves[3] = 0;
			}
		}else{
			positionMoves[3] = 0;
		}

		//check position 4
		if ( (currentX + 2) < boardSizeX && (currentY + 1) < boardSizeY ) {
			if ( visitedArray[currentX+2][currentY+1] == false ) {
				positionMoves[4] = possibleMoves(currentX+2, currentY+1, visitedArray);
			}else{
				positionMoves[4] = 0;
			}
		}else{
			positionMoves[4] = 0;
		}

		//check position 5
		if ( (currentX + 1) < boardSizeX && (currentY + 2) < boardSizeY ) {
			if ( visitedArray[currentX+1][currentY+2] == false ) {
				positionMoves[5] = possibleMoves(currentX+1, currentY+2, visitedArray);
			}else{
				positionMoves[5] = 0;
			}
		}else{
			positionMoves[5] = 0;
		}

		//check position 6
		if ( (currentX - 1) >= 0 && (currentY + 2) < boardSizeY ) {
			if ( visitedArray[currentX - 1][currentY + 2] == false ) {
				positionMoves[6] = possibleMoves(currentX-1, currentY+2, visitedArray);
			}else{
				positionMoves[6] = 0;
			}
		}else{
			positionMoves[6] = 0;
		}

		//check position 7
		if ( (currentX - 2) >= 0 && (currentY + 1) < boardSizeY ) {
			if ( visitedArray[currentX-2][currentY+1] == false ) {
				positionMoves[7] = possibleMoves(currentX-2, currentY+1, visitedArray);
			}else{
				positionMoves[7] = 0;
			}
		}else{
			positionMoves[7] = 0;
		}

		return positionMoves;
		
	}//end method
		
	public int possibleMoves(int locationX, int locationY, boolean[][] movesArray) {

		int possibleMoves = 0;
		int boundaryX = movesArray.length;
		int boundaryY = movesArray[0].length;

		if (((locationX - 2) >= 0) && ((locationY - 1) >= 0 )) {
			if ( movesArray[locationX-2][locationY-1] == false ) {
				possibleMoves++;
			}
		}

		if (((locationX - 1) >= 0) && ((locationY - 2) >= 0 )) {
			if ( movesArray[locationX-1][locationY-2] == false ) {
				possibleMoves++;
			}
		}

		if (((locationX + 1) < boundaryX) && ((locationY - 2) >= 0 )) {
			if ( movesArray[locationX+1][locationY-2] == false ) {
				possibleMoves++;
			}
		}

		if (((locationX + 2) < boundaryX) && ((locationY - 1) >= 0 )) {
			if ( movesArray[locationX+2][locationY-1] == false ) {
				possibleMoves++;
			}
		}

		if (((locationX + 2) < boundaryX) && ((locationY + 1) < boundaryY )) {
			if ( movesArray[locationX+2][locationY+1] == false ) {
				possibleMoves++;
			}
		}

		if (((locationX + 1) < boundaryX) && ((locationY + 2) < boundaryY )) {
			if ( movesArray[locationX+1][locationY+2] == false ) {
				possibleMoves++;
			}
		}

		if (((locationX - 1) >= 0) && ((locationY + 2) < boundaryY )) {
			if ( movesArray[locationX - 1][locationY + 2] == false ) {
				possibleMoves++;
			}
		}

		if (((locationX - 2) >= 0) && ((locationY + 1) < boundaryY )) {
			if ( movesArray[locationX-2][locationY+1] == false ) {
				possibleMoves++;
			}
		}

		return possibleMoves;
	}//end method
}//end class
