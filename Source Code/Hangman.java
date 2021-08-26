/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman;

import java.util.Scanner;

/**
 *
 * @author ELCOT
 */
public class Hangman {

    private static String words[]={"english" , "italy" , "france" , "computer", "naveen"};
    private static String hints[]={"Popular language" , "Beautiful country in the world" , "This country has highest turitors per year" ,
                        "Electronic device", "My Name"};
    
    public void guessword(int n){
        Scanner scan=new Scanner(System.in);
        char one_word[]=new char[words[n].length()];
        char letter;
        int flag=0;
        int chance=3;
        String neword=words[n];
        for(int i=0;i<words[n].length();i++){
            one_word[i]='-';
        }
        System.out.print("\n~~~~~~~~~~~~~~~~~~~HINT~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("==========================================\n");
        System.out.print("===\t "+hints[n]+"  \t===\n");
        System.out.println("==========================================\n");
        System.out.print("Guess this word\n\t\t");
        System.out.print("\n");
        System.out.println(one_word);
        while(chance!=0){
            System.out.println("\nEnter you guessed letter:  ");
            letter=scan.next().charAt(0);
            for(int j=0;j<words[n].length();j++){
                if(letter==words[n].charAt(j)){
                    one_word[j]=letter;
                    flag=1;
                }
            }
            if(flag==1){
                System.out.print("Weldone my dear boy!!! Keep it up!!!\n\t\t");
                System.out.print(one_word);
                flag=0;
            }
            else{
                chance--;
                System.out.println("Try again");
            }
            int len=0;
            for(int k=0;k<words[n].length();k++){
               if(words[n].charAt(k)==one_word[k])
                   len++;
           }
           if(len==words[n].length())
               break;
        }
        if(chance==0)
            hangmanrope();
        if(n==words.length-1){
            System.out.println("\nTry again later! Thanks for your play!");
        }
        else{
            System.out.println("\nTry Next word!");
        }
    }
    
    public void hangmanrope(){
            System.out.println(" --------");
            System.out.println(" |      |");
            System.out.println(" O      |");
            System.out.println("/|\\     |");
            System.out.println("/\\      |");
            System.out.println("        |");
            System.out.println("        |");
            System.out.println("--------------------");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("^^^             Hangman                   ^^^");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("\n\n");
        Hangman hang=new Hangman();
        for(int i=0;i<words.length;i++){
            hang.guessword(i);
            System.out.println("\n");
        }
    }
}
