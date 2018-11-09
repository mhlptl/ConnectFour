
public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private int playerID;
	private int row;
	private int col;
	private char moves[][];
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		moves = new char[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				moves[i][j] = ' ';
			}
		}
	}
		
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		for(int i = row-1; i >= 0; i--) {
			if(moves[i][c] == ' ') {
				moves[i][c] = 'L';
				break;
			}
		}
	}
	
	//returns column of where to play a token
	public int playToken(){
		String s = "";
		int play = GIO.readInt(s);
		while(play < 0 || play >= col || moves[0][play] != ' ') { //or when row is filled
			System.out.print("Please enter a valid column: ");
			play = GIO.readInt(s);
		}
		for(int i = row-1; i >= 0; i--) {
			if(moves[i][play] == ' ') {
				moves[i][play] = 'C';
				break;
			}
		}
		return play;
	}
	//get this player's id
	public int getPlayerID(){
		return playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				moves[i][j] = ' ';
			}
		}
	}
}