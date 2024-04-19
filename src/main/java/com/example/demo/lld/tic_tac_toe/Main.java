package com.example.demo.lld.tic_tac_toe;

public class Main {

    public static void main(String[] args)throws Exception
    {
        Game ticTacToe=new Game();
        ticTacToe.initializeGame();
        System.out.println("Winner is :- "+ticTacToe.startGame());

    }
}
