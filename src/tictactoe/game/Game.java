package tictactoe.game;

import tictactoe.bean.Board;
import tictactoe.bean.Move;
import tictactoe.bean.Player;
import tictactoe.evaluate.BoardEval;

public interface Game {

	/* (non-Javadoc)
	 * @see tictactoe.Game#initGame(tictactoe.Players)
	 */
	void initGame(Player playerOne,boolean isSinglePlayer);

	/* (non-Javadoc)
	 * @see tictactoe.Game#gameMove(tictactoe.CellContent, tictactoe.Move)
	 */
	boolean gameMove(Player player, Move move);

	/* (non-Javadoc)
	 * @see tictactoe.Game#gameUpdate(tictactoe.CellContent)
	 */
	void gameUpdate(Player player);

	/* (non-Javadoc)
	 * @see tictactoe.Game#switchPlayer()
	 */
	Player switchPlayer();
	/*
	public CellContent getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(CellContent currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	*/

	/* (non-Javadoc)
	 * @see tictactoe.Game#getBoard()
	 */
	Board getBoard();

	/* (non-Javadoc)
	 * @see tictactoe.Game#setBoard(tictactoe.Board)
	 */
	void setBoard(Board board);

	/* (non-Javadoc)
	 * @see tictactoe.Game#getCurrentStatus()
	 */
	GameStatus getCurrentStatus();

	/* (non-Javadoc)
	 * @see tictactoe.Game#setCurrentStatus(tictactoe.GameStatus)
	 */
	void setCurrentStatus(GameStatus currentStatus);

	/* (non-Javadoc)
	 * @see tictactoe.Game#getPlayers()
	 *//*
		@Override
		public Players getPlayers() {
		return players;
		}
		/* (non-Javadoc)
		* @see tictactoe.Game#setPlayers(tictactoe.Players)
		*/
	/*
	@Override
	public void setPlayers(Players players) {
		this.players = players;
	}
	/*
	/* (non-Javadoc)
	 * @see tictactoe.Game#getEval()
	 */
	BoardEval getEval();

	/* (non-Javadoc)
	 * @see tictactoe.Game#setEval(tictactoe.BoardEvalImp)
	 */
	void setEval(BoardEval eval);

	/* (non-Javadoc)
	 * @see tictactoe.Game#getNumberOfPlayers()
	 */
	
	
	Player getPlayerOne() ;
	void setPlayerOne(Player playerOne) ;
	Player getPlayerTwo() ;
	void setPlayerTwo(Player playerTwo);
	Player getCurrentPlayer();
	boolean isSinglePlayer();
	void setSinglePlayer(boolean isSinglePlayer);

}