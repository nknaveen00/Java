package com.mycompany.tictactoe;

import java.util.Scanner;


public class tictactoe {
    
    public char[] barray={'0','1','2','3','4','5','6','7','8','9'};
    public int opt; 
    
    public void Tic_Tac_Toe(){
        int count=0,player=1,win;
        Scanner scan=new Scanner(System.in);
        ///Intro about Game
        System.out.println("\t\t\tTic Toe game");
        System.out.println("This is your board");
        board();
        System.out.println("Player 1 symbol is:  O");
        System.out.println("Player 2 symbol is:  X");
        System.out.println("Let's start game");
        ///Main process of the program
        do{
            player=(player%2!=0)? 1:2;
            System.out.println("Player"+player+"\nEnter your choice");
            opt=scan.nextInt();
            if(opt>=1&&opt<=9){
                if(player==1){
                    System.out.println("Option is "+opt);
                    barray[opt]='O';
                    board();
                    win=checkwin(player);
                    player++;
                }
                else{
                    barray[opt]='X';
                    board();
                    win=checkwin(player);
                    player--;
                }
                count++;
                if(win==0&&count==9)
                    System.out.println("Match is draw");
            }
            else{
                System.out.println("Enter valid option");
            }
        }while(count!=9);
        
    }
    
    public void board(){
            System.out.println("--------------");
            System.out.println("| "+barray[1]+" | "+barray[2]+" | "+barray[3]+" |");
            System.out.println("--------------");
            System.out.println("| "+barray[4]+" | "+barray[5]+" | "+barray[6]+" |");
            System.out.println("--------------");
            System.out.println("| "+barray[7]+" | "+barray[8]+" | "+barray[9]+" |");
            System.out.println("--------------");
    }
    
    public int checkwin(int player){
            int won;
            if(barray[1]==barray[2]&&barray[2]==barray[3])
                won=1;
            else if(barray[4]==barray[5]&&barray[5]==barray[6])
                won=1;
            else if(barray[7]==barray[8]&&barray[8]==barray[9])
                won=1;
            else if(barray[1]==barray[4]&&barray[4]==barray[7])
                won=1;
            else if(barray[2]==barray[5]&&barray[5]==barray[8])
                won=1;
            else if(barray[3]==barray[6]&&barray[6]==barray[9])
                won=1;
            else if(barray[1]==barray[5]&&barray[5]==barray[9])
                won=1;
            else if(barray[1]==barray[5]&&barray[5]==barray[9])
                won=1;
            else if(barray[3]==barray[5]&&barray[5]==barray[7])
                won=1;
            else
                won=0;
            if(won==1){
                System.out.println("Player "+player+" is won the match");
                System.out.println("Congrats player"+player);
                System.exit(0);
            }
            return won;
        }
 
    ///Driver Program
    public static void main(String args[]) {
        // TODO code application logic here
           tictactoe t=new tictactoe();
           t.Tic_Tac_Toe();
    }
}