package com.guoyang.test;

/**
 * Created by L'Accordeur on 2016/10/31.
 */
public class AddAllNumbers {
    public Long addNumbers(Long number) {
        Long result = 0L;
        Long temp = 0L;
        String copyNumber;

        if (number instanceof Long) {

            copyNumber = number.toString();

            for (int i = 0;i < copyNumber.length();i++) {
                temp = number % 10;
                result = result + temp;
                number = number / 10;
            }
            System.out.println("The result is " + result);
        } else {
            System.out.println("传入的参数类型不符合");
        }

        return result;
    }

    public Integer addNumbers(Integer number) {
        Integer result = 0;
        Integer temp = 0;
        String copyNumber;

        if (number instanceof Integer) {

            copyNumber = number.toString();

            for (int i = 0;i < copyNumber.length();i++) {
                temp = number % 10;
                result = result + temp;
                number = number / 10;
            }
            System.out.println("The result is " + result);
        } else {
            System.out.println("传入的参数类型不符合");
        }

        return result;
    }

    public static void main(String[] args) {
        AddAllNumbers addAllNumbers = new AddAllNumbers();
        long num = 3432423454L;
        int num1 = 43289;
        addAllNumbers.addNumbers(num);
        addAllNumbers.addNumbers(num1);
    }
}


