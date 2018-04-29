package tictactoe.evaluate;

import tictactoe.bean.Board;
import tictactoe.bean.CellContent;
import tictactoe.bean.Move;
import tictactoe.bean.Player;

public class MinMaxImp implements MinMax {
	private Board board;
	private Player computerPlayer;

	private Player opponentPlayer;

	private BoardEval eval;

	public MinMaxImp(Board board, Player player) {
		this.board = board;
		this.computerPlayer = player;
		this.computerPlayer.setComputer(true);
		this.opponentPlayer = computerPlayer.getOpponentPlayer();
		this.eval = new BoardEvalImp(board);
	}

	public MinMaxImp() {

		this(new Board(3), new Player());
	}

	public MinMaxImp(Board board) {

		this(board, new Player());
	}

	@Override
	public boolean isMovesLeft() {
		if (eval.gameTie()) {
			return false;
		}
		return true;
	}

	// @Override
	public int minimax(int depth, boolean isMax) {
		int score = eval.minMaxeval(this.getComputerPlayer());
		Move move = new Move();
		if (score == +10) {
			return (score-depth);
		}
		if (score == -10) {
			return (score+depth);
		}
		if (isMovesLeft() == false) {
			return 0;
		}

		// If this maximizer's move
		if (isMax) {
			int best = -1000;

			// Traverse all cells
			for (int row = 0; row < board.getSize(); row++) {
				for (int column = 0; column < board.getSize(); column++) {
					move.setRow(row);
					move.setColumn(column);
					// Check if cell is empty
					if (board.getCells()[row][column].getContent() == CellContent.EMPTY) {
						// Make the move
						board.setCell(computerPlayer.getPlayerSign(), move);

						// Call minimax recursively and choose
						// the maximum value
						best = Math.max(best, minimax(depth + 1, !isMax));


						// Undo the move
						board.setCell(CellContent.EMPTY, move);

					}
				}
			}

			return best;
		}

		// If this minimizer's move
		else {
			int best = 1000;

			// Traverse all cells
			for (int row = 0; row < board.getSize(); row++) {
				for (int column = 0; column < board.getSize(); column++) {
					move.setRow(row);
					move.setColumn(column);
					// Check if cell is empty
					if (board.getCells()[row][column].getContent() == CellContent.EMPTY) {
						// Make the move
						board.setCell(opponentPlayer.getPlayerSign(), move);

						// Call minimax recursively and choose
						// the minimum value
						best = Math.min(best, minimax(depth + 1, !isMax));

						// Undo the move
						board.setCell(CellContent.EMPTY, move);

					}
				}
			}
			return best;
		}
	}

	public int minimax(int depth, boolean isMax,int alpha,int beta) {
		int score = eval.minMaxeval(this.getComputerPlayer());
		Move move = new Move();
		if (score == +10) {
			return (score-depth);
		}
		if (score == -10) {
			return (score+depth);
		}
		if (isMovesLeft() == false) {
			return 0;
		}

		// If this maximizer's move
		if (isMax) {
			int best = -1000;

			// Traverse all cells
			for (int row = 0; row < board.getSize(); row++) {
				for (int column = 0; column < board.getSize(); column++) {
					move.setRow(row);
					move.setColumn(column);
					// Check if cell is empty
					if (board.getCells()[row][column].getContent() == CellContent.EMPTY) {
						// Make the move
						board.setCell(computerPlayer.getPlayerSign(), move);

						// Call minimax recursively and choose
						// the maximum value
						best = Math.max(best, minimax(depth + 1, !isMax,alpha,beta));
						alpha = Math.max( alpha, best);
					    
						// Undo the move
						board.setCell(CellContent.EMPTY, move);
						if (beta <= alpha) {
					    	break;
					    }


					}
				}
				 if (beta <= alpha) {
				    	break;
				    }
			}

			return best;
		}

		// If this minimizer's move
		else {
			int best = 1000;

			// Traverse all cells
			for (int row = 0; row < board.getSize(); row++) {
				for (int column = 0; column < board.getSize(); column++) {
					move.setRow(row);
					move.setColumn(column);
					// Check if cell is empty
					if (board.getCells()[row][column].getContent() == CellContent.EMPTY) {
						// Make the move
						board.setCell(opponentPlayer.getPlayerSign(), move);

						// Call minimax recursively and choose
						// the minimum value
						best = Math.min(best, minimax(depth + 1, !isMax,alpha,beta));
						beta = Math.min( beta, best);
						
						// Undo the move
						board.setCell(CellContent.EMPTY, move);
						if(beta <= alpha) {
				            break;
						}

					}
				}
				if(beta <= alpha) {
		            break;
				}
			}
			return best;
		}
	}

	@Override
	public Move findBestMove() {
		int bestVal = -1000;
		int min=-1000;
		int max=+1000;
		Move bestMove = new Move();
		
		Move currentMove = new Move();
		bestMove.setRow(-1);
		bestMove.setColumn(-1);

		// Traverse all cells, evalutae minimax function for
		// all empty cells. And return the cell with optimal
		// value.
		for (int row = 0; row < board.getSize(); row++) {
			for (int column = 0; column < board.getSize(); column++) {
				currentMove.setRow(row);
				currentMove.setColumn(column);
				// Check if cell is empty
				if (board.getCells()[row][column].getContent() == CellContent.EMPTY) {
					// Make the move
					board.setCell(computerPlayer.getPlayerSign(), currentMove);
					 //System.out.println("best move:");
					 //System.out.println("ROW: "+bestMove.getRow()+" COL: "+
					 //bestMove.getColumn());
					// compute evaluation function for this
					// move.
					//int moveVal = minimax(0, false);
					int moveVal = minimax(0, false,min,max);
					// Undo the move
					board.setCell(CellContent.EMPTY, currentMove);
					// If the value of the current move is
					// more than the best value, then update
					// best/
					if (moveVal > bestVal) {
						bestMove.setRow(currentMove.getRow());
						bestMove.setColumn(currentMove.getColumn());
						bestVal = moveVal;

					}
				}
			}
		}
		return bestMove;
	}

	@Override
	public BoardEval getEval() {
		return eval;
	}

	@Override
	public void setEval(BoardEval eval) {
		this.eval = eval;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getComputerPlayer() {
		return computerPlayer;
	}

	public void setComputerPlayer(Player computerPlayer) {
		this.computerPlayer = computerPlayer;
	}

	public Player getOpponentPlayer() {
		return opponentPlayer;
	}

	public void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}

}
