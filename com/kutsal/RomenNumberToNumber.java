package com.kutsal;

import java.util.*;

public class RomenNumberToNumber {

    private Map<Integer,String> romenNumbers = new HashMap<>();
    private final int MAX_SIZE = 1000;

    RomenNumberToNumber(){

        final List<Integer> romenNumberKeys = new ArrayList<>(Arrays.asList(1,5,10,50,100,500,MAX_SIZE));

        final List<String> romenNumberValues = new ArrayList<>(Arrays.asList("I","V","X","L","C","D","M"));

        for (int i = 0;i<romenNumberKeys.size();i++){
            romenNumbers.put(romenNumberKeys.get(i),romenNumberValues.get(i));
        }


    }


    public String getToTheRomenNumber(int sayi){
        int divNumber = MAX_SIZE;
        int counter = 0;
        int tempNum = sayi;
        StringBuilder romanNum = new StringBuilder();
        boolean itIsGoingOn = true;

        while (divNumber >= 1) {

            if (tempNum / divNumber != 0) {
                counter = tempNum / divNumber;
                tempNum -= counter * divNumber;
            }
            else if(tempNum / (divNumber-divNumber/10) == 1){
                romanNum.append(romenNumbers.get(divNumber/10)+romenNumbers.get(divNumber));
                tempNum -= (divNumber-divNumber/10);
            }

            for (int i = 0; i < counter; i++) {
                if(counter == 4){
                   romanNum.append(romenNumbers.get(divNumber)+romenNumbers.get(divNumber*5));
                   break;
                }
                else{
                    romanNum.append(romenNumbers.get(divNumber));
                }


            }
            if (itIsGoingOn) {
                divNumber = divNumber / 2;
                itIsGoingOn = false;
            } else {
                divNumber = divNumber / 5;
                itIsGoingOn = true;
            }
            counter = 0;
        }


        return romanNum.toString();
    }



}
