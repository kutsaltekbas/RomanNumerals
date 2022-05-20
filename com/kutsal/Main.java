package com.kutsal;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	// This is the main function

        Scanner scanner = new Scanner(System.in);
        String word,word2,operator;
        Operators operators = new Operators();


        while(true){

            System.out.print("Enter a roman numeral (I-MMMCMXCIX):");
            word = scanner.nextLine();

            if(word.equals("-")){
                break;
            }
            System.out.print("Select an operator(+,-,/,*):");
            operator = scanner.nextLine();

            System.out.print("Enter the second roman numeral (I-MMMCMXCIX):");
            word2 = scanner.nextLine();

            System.out.println(operators.operatorSelection(word,word2,operator));

        }


    }






}
