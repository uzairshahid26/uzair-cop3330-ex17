/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Muhammad Uzair
 */

package org.example;
import java.util.Scanner;
import java.text.DecimalFormat;



public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.######");


        int A, W, H, gender;
        float r;
        double BAC;
        System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
        gender = checkNumber(scanner.nextLine());

        System.out.print("How many ounces of alcohol did you have? ");
        A = checkNumber(scanner.nextLine());

        System.out.print("What is your weight, in pounds? ");
        W = checkNumber(scanner.nextLine());

        System.out.print("How many hours has it been since your last drink? ");
        H = checkNumber(scanner.nextLine());

        scanner.close();

        if (gender == 1) {
            r = (float) 0.73;
        } else {
            r = (float) 0.66;
        }


        BAC = (A * 5.14 / W * r) - (0.015 * H);

        System.out.println("\nYour BAC is " + df.format(BAC));
        if (BAC < 0.08) {
            System.out.println("It is LEGAL for you to drive.");
        } else {
            System.out.println("It is NOT LEGAL for you to drive.");


        }
    }

    private static boolean isNum(String input) {
        boolean isNum = true;
        try {
            Integer.parseInt(input);
        }
        catch(NumberFormatException e) {
            isNum = false;
        }
        return isNum;
    }

    private static int checkNumber(String inputStr) {
        Scanner scanner = new Scanner(System.in);
        String inputToCheck = inputStr;
        int input = 0;
        boolean completed = false;
        while (!completed) {
            if (isNum(inputToCheck)) {
                input = Integer.parseInt(inputToCheck);
                completed = true;
            } else {
                System.out.print("Error! Please enter numeric values only: ");
                inputToCheck = scanner.nextLine();
            }
        }
        return input;
    }
}