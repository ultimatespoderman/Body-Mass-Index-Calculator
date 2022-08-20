/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package body.mass.index.calculator;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Wonarche
 */
public class BodyMassIndexCalculator {

    public static double getDoubleWithinRange(Scanner sc, String prompt,
    double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble (sc, prompt);
            if (d <= min) {
                System.out.println(
                "Error! Number must be greater than " + min + ".");       
            } else if (d >= max) {
                System.out.println(
                "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }
    
    public static double getDouble(Scanner sc, String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();   
                isValid = true;
            } else {
                System.out.println("Error! Invalid number. Try again.");
            }
            sc.nextLine(); 
        }
        return d;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        NumberFormat number = NumberFormat.getNumberInstance();
        String choice = "y";
          while (choice.equalsIgnoreCase("y")) {     
        
              double weight = 0;
              double height = 0;
              double bmi = 0;
              
        //ask user for weight in pounds
          try {
        System.out.print("Please enter weight (pounds): ");
        weight = sc.nextDouble();
        } catch  (InputMismatchException e) {
            System.out.println("Error! Invalid decimal value. Try again.\n");
            sc.nextLine();
            continue;
        }
        System.out.println();
        
        //ask user for height in inches
        try {
        System.out.print("Please enter height (inches): ");
        height = sc.nextDouble();
        
        //uses the bmi formula to calculate user's input
         bmi = 703 * (weight / (height * height));
        } catch  (InputMismatchException e) {
            System.out.println("Error! Invalid decimal value. Try again.\n");
            sc.nextLine();
            continue;
        }
        
        //formats number to two 
        number.setMaximumFractionDigits(2);
        System.out.println("Your BMI is : " + number.format(bmi));
        System.out.println();
        
        System.out.println("BMI VALUES\n" +
"Underweight: less than 18.5\n" +
"Normal: between 18.5 and 24.9\n" +
"Overweight: between 25 and 29.9\n" +
"Obese: 30 or greater");
        System.out.println();
        
         // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
    }
    }
}
