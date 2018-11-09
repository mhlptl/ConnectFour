
public class Board {
	
	private char playerOne;
	private char playerTwo;
	private int row;
	private int col;
	private char board[][];
	private int index;
	
	Board() {
		this.row = 6;
		this.col = 7;
		board = new char[this.row][this.col];
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.col; j++) {
				board[i][j] = ' ';
			}
		}
	}
	Board(int row, int col) {
		this.row = row;
		this.col = col;
		board = new char[this.row][this.col];
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.col; j++) {
				board[i][j] = ' ';
			}
		}
	}
	public int getNumRows() {
		return this.row;
	}
	public int getNumCols() {
		return this.col;
	}
	public char getPlayerOne() {
		return this.playerOne;
	}
	public char getPlayerTwo() {
		return this.playerTwo;
	}
	public void setPlayerOne(char o) {
		this.playerOne = o;
	}
	public void setPlayerTwo(char t) {
		this.playerTwo = t;
	}
	//need to fix
	public char getToken(int row, int col) {
		char token = '\0';
		if(row < 0 || col < 0 || row >= this.row || col >= this.col)
			return token;
		else
			return board[row][col];
	}
	public boolean canPlay() {
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.col; j++) {
				if(this.board[i][j] == ' ') {
					return true;
				}
			}
		}
		return false;
	}
	public boolean play(int p, int c) {
		int x = this.row;
		if (c < 0 || c >= this.col) {
			return false;
		} 
		else if (p > 2 || p <= 0) {
			return false;
		}
		else if (board[0][c] == this.playerOne || board[0][c] == this.playerTwo) {
		   return false;
		} 
		else
		   while (x > 0) {
			   x--;
			   if (board[x][c] == ' ') {
				   break;
			   }
		  }
		if (board[0][c] != ' ') {
		  return false;
		}
		if (p == 1) {
			board[x][c] = this.playerOne;
			return true;
		} 
		else {
			board[x][c] = this.playerTwo;
			return true;
		}
	 }

	public int isFinished() {
		int count = 0;
		//checks horizontal p1
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.col; j++) {
				if(this.board[i][j] == this.getPlayerOne())
					count++;
				else
					count = 0;
				if(count >= 4) {
					index = 1;
				}
			}
		}
		//checks horizontal p2
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.col; j++) {
				if(this.board[i][j] == this.getPlayerTwo())
					count++;
				else
					count = 0;
				if(count >= 4) {
					index = 2;
				}
			}
		}
		//checks vertical p1
		for(int i = 0; i < this.col-1; i++) {
			for(int j = row-1; j >= 0; j--) {
				if(this.board[j][i] == this.getPlayerOne())
					count++;
				else
					count = 0;
				if(count >= 4) {
					index = 1;
				}
			}
		}
		//checks vertical p2
		for(int i = 0; i < this.col; i++) {
			for(int j = row-1; j >= 0; j--) {
				if(this.board[j][i] == this.getPlayerTwo())
					count++;
				else
					count = 0;
				if(count >= 4) {
					index = 2;
				}
			}
		}
		//diagonal p1
		for(int i = row-1; i > 0; i--) {
			count = 1;
			for(int j = 0; j < col; j++) {
				int x = i;
				int y = j;
				while (x > 0 && y < col-1){
					if(board[x][y] == board[x-1][y+1]) {
						count++;
					}
					else
						count = 1;
					if(count >= 4) {
						if(board[i][j] == this.getPlayerOne()) {
							index = 1;
							return index;
						}
					}
					x--;
					y++;
					if(count == 1) {
						break;
					}
				}
				count = 1;
			}
		}
		//p1 diagonal
		for(int i = 0; i < row-1; i++) {
			count = 1;
			   for(int j = 0; j < col-1; j++) {
				   int x=i;
				   int y=j;
				   while(x < row-1 && y < col-1) {
					   if(board[x][y] == board[x+1][y+1])
						   count++;
					   else
						   count = 1;
					   if(count >= 4) {
						   if(board[i][j] == this.getPlayerOne()) {
							   index = 1;
							   return index;
						   }
					   }
					   x++;
					   y++;
					   if(count == 1)
						   break;
				   }
				   count = 1;
			   }
		}
		//p2 diagonal
		for(int i = row-1; i > 0; i--) {
			count = 1;
			for(int j = 0; j < col-1; j++) {
				int x = i;
				int y = j;
				while (x > 0 && y < col-1) {
					if(board[x][y] == board[x-1][y+1]) {
						count++;
					}
					else
						count = 1;
					if(count >= 4) {
						if(board[i][j] == this.getPlayerTwo()) {
							index = 2;
							return index;
						}
					}
					x--;
					y++;
					if(count == 1) {
						break;
					}
				}
				count = 1;
			}
		}
		//p2 diagonal
		for(int i = 0; i < row-1; i++) {
			count = 1;
			for(int j = 0; j < col-1; j++) {
				int x = i;
				int y = j;
				while(x < row-1 && y < row-1) {
					if(board[x][y]==board[x+1][y+1])
						count++;
					else
						count = 1;
					if(count >= 4) {
						if(board[i][j] == this.getPlayerTwo()){
							index = 2;
							return index;
						}
					}
					x++;
					y++;
					if(count == 1)
						break;
				}
				count = 1;
			}
		}
		if(index != 1 && index != 2 && canPlay() == false)
			index = 0;
		if(index != 1 && index != 2 && canPlay() == true)
			index = -1;
		return index;
	}
}