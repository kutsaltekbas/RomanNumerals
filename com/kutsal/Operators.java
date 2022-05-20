package com.kutsal;

public class Operators {
    private numberToRomenNumber romenNumber = new numberToRomenNumber();
    private RomenNumberToNumber number = new RomenNumberToNumber();


    public String operatorSelection(String number1, String number2, String operation) throws  Exception{
        int selectedNum;

        switch (operation){
            case "+":
                selectedNum = romenNumber.getToTheNumber(number1) + romenNumber.getToTheNumber(number2);
                break;
            case "-":
                selectedNum = romenNumber.getToTheNumber(number1) - romenNumber.getToTheNumber(number2);
                break;
            case "/":
                selectedNum = romenNumber.getToTheNumber(number1) / romenNumber.getToTheNumber(number2);
                break;
            case "*":
                selectedNum =romenNumber.getToTheNumber(number1) * romenNumber.getToTheNumber(number2);
                break;
            default:
                throw new Exception("The result of the entered operation should be between 1-3999.");
        }

        if (selectedNum <= 3999 && selectedNum > 0){
            return number.getToTheRomenNumber(selectedNum);
        }
        else {
            throw new Exception("The result of the entered operation should be between 1-3999.");
        }
    }
}
