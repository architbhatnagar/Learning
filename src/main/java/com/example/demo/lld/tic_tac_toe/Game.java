package com.example.demo.lld.tic_tac_toe;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size:-");
        int size=sc.nextInt();
        gameBoard =new Board(size);
        players=new LinkedList<>();
        System.out.println("Enter Player 1 Name :-");
        String player1=sc.next();
        Player x=new Player(player1,new PlayingPieceX());
        players.add(x);
        System.out.println("Enter Player 2 Name :-");
        String player2=sc.next();
        Player o=new Player(player2,new PlayingPieceO());
        players.add(o);
    }

    public String startGame(){

        boolean noWinner = true;
        while(noWinner){
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces =  gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position chosen, shi se khel gandu");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece().pieceType);
            if(winner) {
                return playerTurn.getName();
            }
        }

        return "tie";
    }

    public boolean isThereWinner(int row,int column,PieceType pieceType){
        boolean rowCheck=true;
        boolean columnCheck=true;
        boolean diagonalCheck=true;
        boolean antidiagonalCheck=true;
        if(row<0 || row > gameBoard.size || column< 0 || column> gameBoard.size){
            return false;
        }
        for(int i=0;i<gameBoard.size;i++) {
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowCheck=false;
                break;
            }
        }
        for(int i=0;i<gameBoard.size;i++) {
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnCheck=false;
                break;
            }
        }
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalCheck=false;
                break;
            }
        }
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antidiagonalCheck=false;
                break;
            }
        }
        return rowCheck || columnCheck || diagonalCheck || antidiagonalCheck;
    }
}
