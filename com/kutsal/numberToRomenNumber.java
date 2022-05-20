package com.kutsal;

import java.util.*;

public class numberToRomenNumber {

    private Map<String,Integer> romenNumbers = new HashMap<>();

    numberToRomenNumber(){

        final List<Integer> romenNumberValues = new ArrayList<>(Arrays.asList(1,5,10,50,100,500,1000));

        final List<String> romenNumberKeys = new ArrayList<>(Arrays.asList("I","V","X","L","C","D","M"));


        for (int i = 0;i<romenNumberKeys.size();i++){
            romenNumbers.put(romenNumberKeys.get(i),romenNumberValues.get(i));
        }

    }

    //2744  // MMDCCXLIV
    public int getToTheNumber(String word) throws  Exception{
        List<String> dividedData = new ArrayList<>();
        List<String> usefulData = new ArrayList<>();
        int total = 0;

        usefulData = List.of(word.split(""));

        usefulData = editData(usefulData);

        for(var component : usefulData){
            if(component.length() == 2){
                dividedData = List.of(component.split(""));
                total += romenNumbers.get(dividedData.get(1)) - romenNumbers.get(dividedData.get(0));
            }
            else{
                total += romenNumbers.get(component);
            }
        }

        return total;
    }

    private List<String> editData(List<String> datas) throws Exception {

        String previous;
        List<String> newData = new ArrayList<>();
        datas = checkTheLetters(datas);

        previous = datas.get(0);
        String newComponent;
        boolean isItDone = false;

        if(datas.size() == 1){
            return datas;
        }

        for (int i = 1;i<datas.size();i++){
            newComponent = datas.get(i);

            if(romenNumbers.get(previous) >= romenNumbers.get(newComponent)){
                if (!isItDone){
                    newData.add(previous);
                }
                isItDone= false;

            }
            else{
                newData.add(previous+newComponent);
                isItDone = true;

            }
            if(i == datas.size()-1 && newData.get(newData.size()-1).length() !=2){
                newData.add(newComponent);
            }

            previous = newComponent;
        }

        return checkItIsRomenNumber(newData);
    }

    private List<String> checkItIsRomenNumber(List<String> theRomenNumbers) throws Exception {
        List<String> tempList = new ArrayList<>();
        String previousComponent = "";
        String nextComponent = "";
        String previousComponent1 = "";

        int counter,previousCounter = 0;
        for (var component : theRomenNumbers){

            //Yanlıs ikili durumları kontrol eder.
            if(component.length() == 2){
                tempList = List.of(component.split(""));

                if(romenNumbers.get(tempList.get(1)) != romenNumbers.get(tempList.get(0)) * 5 &&
                        !(romenNumbers.get(tempList.get(1)) == romenNumbers.get(tempList.get(0)) * 10)){

                    throw new Exception("Entered number does not comply with Roman numerals.");
                }
                else if (romenNumbers.get(tempList.get(1)) != romenNumbers.get(tempList.get(0)) * 10 &&
                        !(romenNumbers.get(tempList.get(1)) == romenNumbers.get(tempList.get(0)) * 5)){
                    throw new Exception("Entered number does not comply with Roman numerals.");
                }
            }
            counter = 0;
            //Aynı Romen rakamının 3 ten fazla olup olmama durumu kontrol edilir.
           for(int i = 0;i<theRomenNumbers.size();i++){
               if (component.equals(theRomenNumbers.get(i))){
                   counter++;
               }
               //Bu ve asagidaki ifadeler yukardaki if ifadesi içine alınabilirler gibi duruyor.
               if (component.length() == 2){
                   previousComponent = component.split("")[0];
                   if (previousComponent.equals(nextComponent)){
                       throw new Exception("The entered number cannot be entered with the character next to it twice. : "+previousComponent);
                   }
                   nextComponent = previousComponent;
                   break;
               }
               if (previousComponent.equals(component)){
                   throw new Exception("The order of the digits entered is not correct.");
               }
           }
           if (counter > 3){
               throw new Exception("Entered numbers cannot be more than 3 next to each other.");
           }
           else if (previousCounter >= 1 && counter >1 && romenNumbers.get(component) * 2 == romenNumbers.get(previousComponent1)){
                throw new Exception("It cannot be used 2 times after the number 2 times greater than itself.");
           }
           previousCounter = counter;
           previousComponent1 = component;

        }

        return theRomenNumbers;
    }

    private List<String> checkTheLetters(List<String> theRomenNumbers) throws Exception{

        for (var component : theRomenNumbers){
            if(!(romenNumbers.containsKey(component))){
                throw new Exception("The entered number does not match any roman numerals.");
            }
        }

        return theRomenNumbers;
    }

}

