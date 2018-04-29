package tictactoe.test;

import tictactoe.bean.Board;
import tictactoe.bean.Cell;
import tictactoe.bean.CellContent;
import tictactoe.bean.Move;
import tictactoe.bean.Player;
import tictactoe.evaluate.MinMax;
import tictactoe.evaluate.MinMaxImp;

public class MinMaxTest {
	// Driver code
	public static void main(String[] args){
		
		
		 Board board=new Board(3);
		 
		 
		
		board.setCell(CellContent.NOUGHT,new Move(0,0));
		board.setCell(CellContent.CROSS,new Move(0,2));
		board.setCell(CellContent.NOUGHT,new Move(1,0));
		
		board.setCell(CellContent.CROSS,new Move(1,2));
		board.setCell(CellContent.NOUGHT,new Move(1,1));
		board.setCell(CellContent.CROSS,new Move(0,0));
		//board.setCell(CellContent.NOUGHT,new Move(1,1))
		printBoard(board);
		
		Player player12=new Player(CellContent.NOUGHT);
		player12.setComputer(true);
		MinMax minmax=new MinMaxImp(board);
		minmax.setComputerPlayer(player12);
		minmax.setOpponentPlayer(player12.getOpponentPlayer());
		
		//MinMax minmax=new MinMaxImp(board);
		Move bestMove = minmax.findBestMove();
		
	    System.out.println("The Optimal Move is : ");
	    System.out.println("ROW: "+bestMove.getRow()+" COL: "+
	                                  bestMove.getColumn());
	    printBoard(board);
	    Board board2=new Board(3);
		board2.setCell(CellContent.CROSS,new Move(0,0));
		board2.setCell(CellContent.NOUGHT,new Move(0,1));
		board2.setCell(CellContent.CROSS,new Move(1,0));
		board2.setCell(CellContent.NOUGHT,new Move(1,1));
		
		printBoard(board2);
		MinMax minmax2=new MinMaxImp(board2);
		Move bestMove2 = minmax2.findBestMove();
		
	    System.out.println("The Optimal Move is : ");
	    System.out.println("ROW: "+bestMove2.getRow()+" COL: "+
	                                  bestMove2.getColumn());
	    printBoard(board2);
	    
	    Board board3=new Board(3);
	    
		board3.setCell(CellContent.CROSS,new Move(0,0));		
		board3.setCell(CellContent.NOUGHT,new Move(0,1));
		board3.setCell(CellContent.CROSS,new Move(1,1));
		printBoard(board3);
		Player player=new Player(CellContent.NOUGHT);
		player.setComputer(true);
		MinMax minmax3=new MinMaxImp(board3);
		minmax3.setComputerPlayer(player);
		minmax3.setOpponentPlayer(player.getOpponentPlayer());
		Move bestMove3 = minmax3.findBestMove();
		//System.out.println(minmax3.getComputerPlayer().getPlayerSign());
		//System.out.println(minmax3.getOpponentPlayer().getPlayerSign());
	    System.out.println("The Optimal Move is : ");
	    System.out.println("ROW: "+bestMove3.getRow()+" COL: "+
	                                  bestMove3.getColumn());
	    printBoard(board3);
	     
	    Board board4=new Board(3);
	    
		board4.setCell(CellContent.CROSS,new Move(0,0));		
		board4.setCell(CellContent.NOUGHT,new Move(2,2));
		board4.setCell(CellContent.CROSS,new Move(0,1));
		printBoard(board4);
		Player player2=new Player(CellContent.NOUGHT);
		player2.setComputer(true);
		MinMax minmax4=new MinMaxImp(board4);
		minmax4.setComputerPlayer(player2);
		minmax4.setOpponentPlayer(player2.getOpponentPlayer());
		Move bestMove4 = minmax4.findBestMove();
		//System.out.println(minmax3.getComputerPlayer().getPlayerSign());
		//System.out.println(minmax3.getOpponentPlayer().getPlayerSign());
	    System.out.println("The Optimal Move is : ");
	    System.out.println("ROW: "+bestMove4.getRow()+" COL: "+
	                                  bestMove4.getColumn());
	    printBoard(board4);
	   
	    Board board5=new Board(3);
	    
		board5.setCell(CellContent.CROSS,new Move(0,2));		
		board5.setCell(CellContent.NOUGHT,new Move(0,1));
		board5.setCell(CellContent.CROSS,new Move(1,1));
		printBoard(board5);
		Player player3=new Player(CellContent.NOUGHT);
		player3.setComputer(true);
		MinMax minmax5=new MinMaxImp(board5);
		minmax5.setComputerPlayer(player3);
		minmax5.setOpponentPlayer(player3.getOpponentPlayer());
		Move bestMove5 = minmax5.findBestMove();
		//System.out.println(minmax3.getComputerPlayer().getPlayerSign());
		//System.out.println(minmax3.getOpponentPlayer().getPlayerSign());
	    System.out.println("The Optimal Move is : ");
	    System.out.println("ROW: "+bestMove5.getRow()+" COL: "+
	                                  bestMove5.getColumn());
	    printBoard(board5);
	    
	}
	public static void printBoard(Board board) {
	      for (int row = 0; row < board.getSize(); ++row) {
	         for (int col = 0; col < board.getSize(); ++col) {
	            printCellContent(board.getCells()[row][col]);   
	            if (col < board.getSize() - 1) System.out.print("|");
	         }
	         System.out.println();
	         if (row < board.getSize() - 1) {
	            System.out.println("-----------");
	         }
	      }
	}
	public static void printCellContent(Cell cell) {
	      switch (cell.getContent()) {
	         case CROSS:  System.out.print(" X "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case EMPTY:  System.out.print("   "); break;
	      }
	   }


}
