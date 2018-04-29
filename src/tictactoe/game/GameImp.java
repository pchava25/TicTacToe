package tictactoe.game;

import javax.ws.rs.Path;

import tictactoe.bean.Board;
import tictactoe.bean.CellContent;
import tictactoe.bean.Move;
import tictactoe.bean.Player;
import tictactoe.evaluate.BoardEval;
import tictactoe.evaluate.BoardEvalImp;
import tictactoe.evaluate.MinMax;
import tictactoe.evaluate.MinMaxImp;

@Path("/game")
public class GameImp implements Game {
	 private Board board; 
	 private GameStatus currentStatus;
	 //private CellContent currentPlayer;
	 //private Players players;
	 private Player playerOne;
	 private Player playerTwo;
	 private BoardEval eval;
	 private MinMax minmax;
	 //private MinMax minmax;
	 //private NumberofPlayers numberOfPlayers;
	 private boolean isSinglePlayer;
	
	// private Move move;
	 
	 public GameImp() {
		 this(3,new Player(),false);
	 }
	 public GameImp(int size,Player playerOne,boolean isSinglePlayer) {
		 board = new Board(size);  
		 initGame(playerOne,isSinglePlayer);
		 eval=new BoardEvalImp(board);
		 
		 minmax=new MinMaxImp(board);
		 if(this.isSinglePlayer) {
		 minmax.setComputerPlayer(playerTwo);
		 minmax.setOpponentPlayer(playerOne);
		 }
	 }

	 /* (non-Javadoc)
	 * @see tictactoe.Game#initGame(tictactoe.Players)
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#initGame(tictactoe.Player)
	 */
	@Override
	public void initGame(Player playerOne , boolean isSinglePlayer) {
		 board.clearBoard();
	     this.setSinglePlayer(isSinglePlayer);
	     this.playerOne=playerOne;
	     if(isSinglePlayer) {
	    	 if(this.playerOne.getPlayerSign()==CellContent.CROSS) {
	    		 this.playerTwo=new Player(CellContent.NOUGHT);
	    	 }
	    	 else {
	    		 this.playerTwo=new Player(CellContent.CROSS);
	    	 }
	    	 this.playerTwo.setComputer(true);
	     }
	     else {
	    	 this.playerTwo=playerOne.getOpponentPlayer();
	     }
	     this.playerOne.setCurrentPlayer(true);
	     currentStatus = GameStatus.PLAYING;
	   }
	 /* (non-Javadoc)
	 * @see tictactoe.Game#gameMove(tictactoe.CellContent, tictactoe.Move)
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#gameMove(tictactoe.CellContent, tictactoe.Move)
	 */
	@Override
	public boolean gameMove(Player player,Move move) {
		if(this.isSinglePlayer && this.getCurrentPlayer().isComputer()) {
			 
			 move=minmax.findBestMove();
		 } 
		if (move.getRow() >= 0 && move.getRow() < board.getSize() && move.getColumn() >= 0 && move.getColumn() < board.getSize()
           && board.getCells()[move.getRow()][move.getColumn()].getContent() == CellContent.EMPTY) {
			 
			board.setCell(player.getPlayerSign(),move );
			//board.setCurrentMove(move);
			return true;
			 
			 //else {
			 //board.setCell(player.getPlayerSign(),move);
			 //board.setCurrentMove(move);
			 //return true;
			 //}
		 } 
		 else {
			 return false;
		 }    
	 }
	/* (non-Javadoc)
	 * @see tictactoe.Game#gameUpdate(tictactoe.CellContent)
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#gameUpdate(tictactoe.CellContent)
	 */
	@Override
	public void gameUpdate(Player player) {
		if (eval.gameWon(player)) {  
			currentStatus = (player.getPlayerSign() == CellContent.CROSS) ? GameStatus.CROSS_WON : GameStatus.NOUGHT_WON;
	    }
		else if (eval.gameTie()) { 
	        currentStatus = GameStatus.TIE;
	      }
	 }
	
	/* (non-Javadoc)
	 * @see tictactoe.Game#switchPlayer()
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#switchPlayer()
	 */
	@Override
	public Player switchPlayer() {
//		currentPlayer = (currentPlayer == CellContent.CROSS) ? CellContent.NOUGHT : CellContent.CROSS;
  //      return currentPlayer;
		//CellContent currentPlayer =(this.getPlayers().getCurrentPlayer()== CellContent.CROSS) ? CellContent.NOUGHT : CellContent.CROSS;
        //this.getPlayers().setCurrentPlayer(currentPlayer);
        //return this.getPlayers().getCurrentPlayer();
		if(this.playerOne.isCurrentPlayer()) {
			this.playerOne.setCurrentPlayer(false);
			this.playerTwo.setCurrentPlayer(true);
			return this.playerOne;
		}
		else {
			this.playerTwo.setCurrentPlayer(false);
			this.playerOne.setCurrentPlayer(true);
			return this.playerTwo;
		}
		
	}
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
	/* (non-Javadoc)
	 * @see tictactoe.Game#getBoard()
	 */
	@Override
	public Board getBoard() {
		return board;
	}
	/* (non-Javadoc)
	 * @see tictactoe.Game#setBoard(tictactoe.Board)
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#setBoard(tictactoe.Board)
	 */
	@Override
	public void setBoard(Board board) {
		this.board = board;
	}
	/* (non-Javadoc)
	 * @see tictactoe.Game#getCurrentStatus()
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#getCurrentStatus()
	 */
	@Override
	public GameStatus getCurrentStatus() {
		return currentStatus;
	}
	/* (non-Javadoc)
	 * @see tictactoe.Game#setCurrentStatus(tictactoe.GameStatus)
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#setCurrentStatus(tictactoe.GameStatus)
	 */
	@Override
	public void setCurrentStatus(GameStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
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
	/* (non-Javadoc)
	 * @see tictactoe.Game#getEval()
	 */
	@Override
	public BoardEval getEval() {
		return eval;
	}
	/* (non-Javadoc)
	 * @see tictactoe.Game#setEval(tictactoe.BoardEvalImp)
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#setEval(tictactoe.BoardEvalImp)
	 */
	@Override
	public void setEval(BoardEval eval) {
		this.eval = eval;
	}
	/* (non-Javadoc)
	 * @see tictactoe.Game#getNumberOfPlayers()
	 */
	/* (non-Javadoc)
	 * @see tictactoe.Game#getNumberOfPlayers()
	 */
	
	public Player getPlayerOne() {
		return playerOne;
	}
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	public Player getPlayerTwo() {
		return playerTwo;
	}
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	public Player getCurrentPlayer() {
		if(this.playerOne.isCurrentPlayer()) {
			return this.playerOne;
		}
		else {
			return this.playerTwo;
		}
	}
	public boolean isSinglePlayer() {
		return isSinglePlayer;
	}
	public void setSinglePlayer(boolean isSinglePlayer) {
		this.isSinglePlayer = isSinglePlayer;
	}
	 
}
