package tictactoe.bean;

public class Player {
	private CellContent playerSign;
	private boolean isComputer;
	private boolean isCurrentPlayer;
	public Player() {
		this.playerSign=CellContent.CROSS;
		this.isComputer=false;
		this.isCurrentPlayer=false;
	}
	public Player(CellContent player) {
		this.playerSign=player;
		this.isComputer=false;
		this.isCurrentPlayer=false;
	}
	public boolean isComputer() {
		return isComputer;
	}
	public void setComputer(boolean isComputer) {
		this.isComputer = isComputer;
	}
	public CellContent getPlayerSign() {
		return playerSign;
	}
	public void setPlayerSign(CellContent player) {
		this.playerSign = player;
	}
	public boolean isCurrentPlayer() {
		return isCurrentPlayer;
	}
	public void setCurrentPlayer(boolean isCurrentPlayer) {
		this.isCurrentPlayer = isCurrentPlayer;
	}
	public Player getOpponentPlayer() {
		Player opponentPlayer=new Player();
		if(this.getPlayerSign()==CellContent.CROSS) {
			opponentPlayer.setPlayerSign(CellContent.NOUGHT);
		}
		else if(this.getPlayerSign()==CellContent.NOUGHT) {
			opponentPlayer.setPlayerSign(CellContent.CROSS);
		}
		return opponentPlayer;
	}
	

}
