package model;

import java.util.Random;

import android.net.ParseException;

public class TicTacToe {

	int holder[][] = new int[3][3];	//design behind the game
	
	int totalMoves = 0;	//number of moves played by player 1 & player 2/cpu
	int winnerType = -1;
	
	int currentMove = 0;
	int val1 = 0; //Value matching the player's letter o
	int val2 = 1; //Value matching the 2nd player's letter x
	int lastPlayed = 1; //Start assuming the 2nd player/cpu played last
	
	int p1Score = 0, p2Score = 0;
	
	//int a, b, c=1, d=1; //integers used to hold/remember coordinates of player's 2nd and last moves
	
	static int gameMode;	//0 for 1 player, 1 for two player
	
	Random rand = new Random();	//random number to generate computer's play position
	
	boolean haveWinner = false;	//boolean to determine whether switch turn or not
	
	//current player display
	String player1="Player 1's turn", player2="Player 2's turn", playerPc="CPU's turn";
	String gameOver = "";
	
	/*
	 * Getters and setters
	 */
	public int[][] getHolder() {
		return holder;
	}

	public void setHolder(int[][] holder) {
		this.holder = holder;
	}
	
	public int getP1Score() {
		return p1Score;
	}

	public void setP1Score(int p1Score) {
		this.p1Score = p1Score;
	}

	public int getP2Score() {
		return p2Score;
	}

	public void setP2Score(int p2Score) {
		this.p2Score = p2Score;
	}
	
	/*
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	*/
	
	public int getGameMode() {
		return gameMode;
	}

	public void setGameMode(int gameMode) {
		TicTacToe.gameMode = gameMode;
	}

	public String getPlayer1() {
		return player1;
	}

	public String getPlayer2() {
		return player2;
	}
	
	/*
	public String getPlayerPc() {
		return playerPc;
	}
	*/
	
	public boolean isHaveWinner() {
		return haveWinner;
	}

	public void setHaveWinner(boolean haveWinner) {
		this.haveWinner = haveWinner;
	}

	/*
	 * Game related methods
	 */
	public String displayPlayer(){
		/*
		if (gameMode == 0){
			if (lastPlayed == 1)
				return getPlayer1();
			else
				return getPlayerPc();
		}
		*/
		//else{
			if (lastPlayed == 1)
				return getPlayer1();
			else
				return getPlayer2();
		//}
	}
	
	public int arrayInput()	{		//select 0 or 1 to put in array
		if (lastPlayed == 0){
			lastPlayed = 1;
			return 1;
		}
		else	{
			lastPlayed = 0;
			return 0;
		}
	}
	
	public void play(int x, int y)	{		
		//if(gameMode ==1){
			currentMove = arrayInput();
			holder[x][y] = currentMove;
			totalMoves++;
			checkWinner(x, y, currentMove);
		//}
			/*
		else {
			cpuPlay();
			currentMove = arrayInput();
			holder[x][y] = currentMove;
			totalMoves++;
			checkWinner(x, y, currentMove);
			
		}
		*/
	}
	
	public void checkWinner(int x, int y, int z)	{		//checks if there is a winner yet
		int horizontal = holder[x][0] + holder[x][1] + holder[x][2];
		int vertical = holder[0][y] + holder[1][y] + holder[2][y];
		int diagonal1 = holder[0][0] + holder[1][1] + holder[2][2];
		int diagonal2 = holder[2][0] + holder[1][1] + holder[0][2];
		
		//0s are for 1st player and 1s for cpu/2nd Player		
			//Check corresponding rows and columns
			if((horizontal == z*3) || (vertical == z*3)){
				winnerType = z;
			}
			//Check corresponding diagonals
			 if ((diagonal1 == z*3) || (diagonal2 == z*3)){
				winnerType = z;
			}
			
			//if all has already been played
			if (totalMoves == 9) {
					winnerType = 9;
			}
			
			doWinner(winnerType);
	}
	
	public void doWinner(int winnerType){
		if (winnerType==0){
			//When either player 1 wins or there is a draw
			gameOver = " Player 1 wins !, play again ?";
			p1Score++;
			setHaveWinner(true);
		}
		else if (winnerType == 1){
			//When 2nd player wins
			gameOver = "Player 2 wins !, play again ?";
			p2Score++;
			setHaveWinner(true);			
		}
		else if (winnerType == 9){
			//When there is a draw
			gameOver = "Draw!, play again ?";
			setHaveWinner(true);
		}
	}
	
	public String gameOverMessage(){
		return gameOver;
	}
	
	/*
	public void cpuPlay()	{	//implementing the moves for the cpu
		if(lastPlayed == 0){
			play(0,2);
			
			a = c;//Assign old positions
			b = d;
			c = 0;//Assign current position
			d = 2;
		}		
	}
	*/
	
	public void reset()	{		//reset the values in the array
		holder[0][0]=-10;
		holder[0][1]=-10;
		holder[0][2]=-10;
		holder[1][0]=-10;
		holder[1][1]=-10;
		holder[1][2]=-10;
		holder[2][0]=-10;
		holder[2][1]=-10;
		holder[2][2]=-10;
		
		setHaveWinner(false);
		winnerType = -1;
		totalMoves = 0;
		
	}
	
	//Constructor
	public TicTacToe() {
		reset();
	}
	
}
