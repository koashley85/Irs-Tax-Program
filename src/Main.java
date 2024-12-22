import java.io.IOException;
import java.util.Scanner;

/* Author: Kavion Ashley
 * Date: November 23, 2024
 * File: Main.java
 * This program calculates tax
 * and net income based on
 * the user's tax category and taxable income.
 * It calls five methods to introduce the program,
 * get user input, calculate tax, and display output.

This program is made to calculate the tax rate based on category selected
User will provide tax category and income
and program will display the Income, taxed amount and Net income
 */
public class Main {

    public static void main(String[] args)throws IOException {
        try {
            String continueAns = introduction();
            if (continueAns.equalsIgnoreCase("y")) {
                int categoryChosen, categoryChosenFinal;
                double income, taxedIncome;
                categoryChosen = category();
                income = taxableIncome();
                categoryChosenFinal = categoryChosen - 1;
                taxedIncome = tax(categoryChosenFinal, income);
                output(taxedIncome, income);
            }

            else {
                System.out.println("Have a Nice Day, Goodbye");
            }
        }
        catch (Exception e){
            System.out.println("Invalid Data");
        }
        }
        //This is to introduce the program to the user
        private static String introduction () {
            Scanner data = new Scanner(System.in);
            System.out.println("Welcome to my Federal Income Tax Program");
            System.out.println("To continue please type (Y or y)");
            return data.nextLine();
        }
        //To get the users category
        private static int category () {
            Scanner data = new Scanner(System.in);
            String[] taxCategory = {"Single", "Head of Household", "Married, Joint", "Married, Separate"};
            int selection;
            for (int i = 0; i < 4; i++) {
                selection = i + 1;
                System.out.print(selection + ".");
                System.out.println(taxCategory[i]);
            }
            System.out.print("Please select a category ");
            selection = data.nextInt();
            while ((selection > 4) || (selection < 0)) {

                System.out.print("Please select a valid category ");
                selection = data.nextInt();
            }
            return selection;
        }
        //To get the users taxable income
        public static double taxableIncome () {
            double selection;
            System.out.println("What is your income ?");
            Scanner data = new Scanner(System.in);
            selection = data.nextDouble();
            while (selection < 0){
                System.out.println("Please enter valid income :");
                selection = data.nextDouble();
            }
            return selection;
        }
        //To calculate the tax
        public static double tax ( int category, double income){
            double[] taxable = new double[4];
            if (category == 0) {
                if (income > 17850) {
                    taxable[0] = ((0.15 * 17850.00) + ((income - 17850.00) * .28));
                } else {
                    //System.out.println(income);
                    taxable[0] = (income * .15);
                }
            }

            if (category == 1) {
                if (income > 23900) {
                    taxable[1] = ((0.15 * 23900.00) + ((income - 23900.00) * .28));
                } else {
                    // System.out.println(income);
                    taxable[1] = (income * .15);
                }
            }

            if (category == 2) {
                if (income > 29750) {
                    taxable[2] = ((0.15 * 29750.00) + ((income - 29750.00) * .28));
                } else {
                    //System.out.println(income);
                    taxable[2] = (income * .15);
                }
            }

            if (category == 3) {
                if (income > 14875) {
                    taxable[3] = ((0.15 * 14875.00) + ((income - 14875.00) * .28));
                } else {
                    // System.out.println(income);
                    taxable[3] = (income * .15);
                }
            }
            return taxable[category];
        }

        //To display the required output
        public static void output ( double taxedIncome, double income){
            System.out.printf("Income:     $%.2f", income);
            System.out.println();
            System.out.printf("Tax:        $%.2f", taxedIncome);
            System.out.println();
            System.out.printf("Net Income: $%.2f", (income - taxedIncome));
            System.out.println();

        }
    }


