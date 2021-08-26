package com.mycompany.games;

import java.util.Scanner;
import java.util.Random;

public class RandomNumberGuess {

    public static void main(String args[]) {
        // TODO code application logic here
        int guess;
        int chance=5,randomnumber;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~       Random Number Guessing       ~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        Random rand=new Random();
        Scanner scan=new Scanner(System.in);
        randomnumber=rand.nextInt(10)+1;
        do{
            System.out.printf("You have only %d chances\n", chance);
            chance--;
            System.out.println("Your guess is between 1 to 10");
            System.out.println("What's your guess?");
            guess=scan.nextInt();
            if(guess==randomnumber){
                System.out.println("Congratulations!\nYou win the game!");
                break;
            }
            else if(guess>randomnumber){
                System.out.println("Try again!!!");
                System.out.println("You entered bigger than Random Number");
            }
            else if(guess<randomnumber){
                System.out.println("Try again!!!");
                System.out.println("You entered lower than Random Number");
            }
        }while(chance!=0);
    }
}
