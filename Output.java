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

public class Output {
	
	public static void main(String[] args) {
		int boardSizeX = 24;
		int boardSizeY = 24;
		int startX = 2;
		int startY = 3;

		Warnsdorff testObject = new Warnsdorff();

		int[][] outputMoves= new int[boardSizeX*boardSizeY][2];
		outputMoves = testObject.TourSolve(boardSizeX, boardSizeY, startX, startY);

		for (int i=(outputMoves.length-1); i>=0;i--) {
			System.out.println("#" + i + ":(" + outputMoves[(i)][0] + "," + outputMoves[(i)][1] + ")");
		}
	}
}
