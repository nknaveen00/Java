package com.mycompany.atmsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ATM {

    
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println("###################################################");
        System.out.println("\t\tWelcome to ATM System\n");
        System.out.println("###################################################");
        String name;
        int id;
        Main main=new Main();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your name");
        name=scan.nextLine();
        System.out.println("Enter your ID");
        id=scan.nextInt();
        main.check_valid_cust(id,name);
    }
}

class Main{
    String custname;
    ArrayList<Integer> custID=new ArrayList<Integer>();
    int balance;
    int lastTransaction;
    int cr_dt=0;
    public Main(){
        custID.add(2000);
        custID.add(1998);
        custID.add(2001);
    }
    
    public void check_valid_cust(int ID, String name){
        custname=name;
        if(custID.contains(ID)){
            System.out.println("\n");
            Menu();
        }
        else{
            System.out.println("Better luck next time!!!");
            System.exit(0);
        }
    }
    
    public void Menu(){
        int option;
        Scanner scan=new Scanner(System.in);
        System.out.println("\t\t***Welcome "+custname+"***\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Last Transaction");
        System.out.println("5. Cancel");
        System.out.println("Enter your option");
        option=scan.nextInt();
        do{
            switch(option){
                case 1: Checkbalance();
                        break;
                case 2: deposit();
                        break;
                case 3: withdraw();
                        break;
                case 4: lastransactions();
                        break;
                case 5: System.exit(0);
            }
            System.out.println("Enter your option");
            option=scan.nextInt();
        }while(option>0 && option<=5);
    }
    public void Checkbalance(){
        System.out.println("\n");
        System.out.println("``````````````````````````````````````````````````");
        System.out.println("\t\t"+custname+" Your balance is  "+balance);
        System.out.println("``````````````````````````````````````````````````");
        System.out.println("\n");
    }
    public void deposit(){
        int amount;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the amount to deposite");
        amount= scan.nextInt();
        if(amount!=0){
            balance=balance+amount;
            lastTransaction=amount;
            cr_dt=1;
            System.out.println("Amount deposited successfully");
        }
        else{
            System.out.println("Couldn't deposite 0 balance");
        }
        System.out.println("\n");
    }
    
    public void withdraw(){
        int amount;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the amount to withdraw");
        amount=scan.nextInt();
        if(amount>0){
            if(balance>=amount){
                balance=balance-amount;
                lastTransaction=amount;
                cr_dt=2;
                System.out.println("Amount drawed successfully");
            }
            else{
                System.out.println("Insufficient balance");
            }
        }
        else{
            System.out.println("Enter amount above 0");
        }
        System.out.println("\n");
    }
    
    public void lastransactions(){
        if(cr_dt==1){
            System.out.println("The Last Transaction "+lastTransaction+" /Cr");
        }
        else if(cr_dt==2){
            System.out.println("The Last Transaction "+lastTransaction+" /Dt");
        }
        else{
            System.out.println("There is no Transaction");
        }
        System.out.println("\n");
    }
}