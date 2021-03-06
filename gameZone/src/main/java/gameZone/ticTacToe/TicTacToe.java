package gameZone.ticTacToe;

import gameZone.components.GlobalResources;

import javax.persistence.*;
import java.util.Random;

@Embeddable
@Table(name = "TicTacToe")
public class TicTacToe {

    /* START INSTANCE VARIABLES*/

    /**
     * {@code GlobalResources} {@code Component}. Grants the ability to use global variables and methods common to other {@code classes} in this Application
     */
    @Transient
    private final GlobalResources gRec = new GlobalResources(null, null);

    /**
     * 2D array for this {@code TicTacToe}. Used to play the game. 0 is empty, 1 is cross, 2 is nought.
     */
    private Integer board[][];
    
    private Integer numMoves;
    
    /* END INSTANCE VARIABLES */

    /* START CONSTRUCTORS */

    /**
     * Default Constructor
     */
    public TicTacToe()
    {
        this.board = new Integer[3][3];
        this.board[0][0] = 0;
        this.board[0][1] = 0;
        this.board[0][2] = 0;
        this.board[1][0] = 0;
        this.board[1][1] = 0;
        this.board[1][2] = 0;
        this.board[2][0] = 0;
        this.board[2][1] = 0;
        this.board[2][2] = 0;
        
        numMoves = 0;
    }

    /* END CONSTRUCTORS */

    public Integer[][] getBoard() { return this.board; }

    public void setBoard(Integer[][] board) { this.board = board; }

    public void setSpace(int space, int x, int y) { this.board[x][y] = space; }

    public int getSpace(int x, int y) {return this.board[x][y];}
    
    public Integer getNumMoves() { return this.numMoves; }
    public void setNumMoves(Integer numMoves) { this.numMoves = numMoves; }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }
    private boolean checkRowsForWin(){
        for(int i = 0; i < 3; i++){
            if(checkRowCol(board[i][0], board[i][1], board[i][2]) == true){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin(){
        for(int i = 0; i < 3; i++){
            if(checkRowCol(board[0][i], board[1][i], board[2][i]) == true){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin(){
        return((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }

    private boolean checkRowCol(int i1, int i2, int i3){
        return((i1 != 0) && (i1 == i2) && (i2 == i3));
    }
    
    public boolean checkForCat() { return !this.checkForWin() && numMoves >= 8; }
    
    public Integer[][] AImove(Integer[][] board){
        Random r = new Random();
        while(true)
        {
            int x = r.nextInt(3);
            int y = r.nextInt(3);
            if(board[x][y] == 0)
            {
                board[x][y] = 2;
                break;
            }
        }
        return board;
    }
}