package tictactoe.evaluate;

import tictactoe.bean.Move;
import tictactoe.bean.Player;

public interface MinMax {

	boolean isMovesLeft();

	//int evaluate();

	//int minimax(int depth, boolean isMax);

	Move findBestMove();

	
	Player getComputerPlayer();
	 

	void setComputerPlayer(Player computerPlayer);

	Player getOpponentPlayer();

	void setOpponentPlayer(Player opponentPlayer);


	//CellContent getCurrentPlayer();

	//void setCurrentPlayer(CellContent currentPlayer);


	BoardEval getEval();

	void setEval(BoardEval eval);

}