import java.util.Scanner;

    public class CrditCardValidator{
    /// method to check if the credit card number is vaild Luhn algorithm
    public static boolean isValidCreditCard(long cardNumber){

        int sum = 0;
        boolean shouldDouble = false;


        // loop thorough each digit of the credit card number starting from the right
        while (cardNumber > 0 ){
            int digit = (int)(cardNumber % 10);// get the rightmopst digit
            cardNumber /= 10; // remove the rightmove digit


            // Double every second digit from the right
            if (shouldDouble){
                digit *= 2;
                // if doublinmg results in a number greater than 9,subtract 9
                if (digit > 9){
                    digit -= 9;
                }
            }

            sum += digit; // add digit (double or not ) to the sum
            shouldDouble = !shouldDouble;
        }

        // the card nuber is valid if the sum is multipler by 10
        return sum % 10 ==0;


    }

    public static void main(String[] args){

        //create scanner object to get input from the user
        Scanner scanner = new Scanner (System.in);

        // promt the user to enter a credit card number
        System.out.print("Enter a credit card number: ");
        long cardNumber = scanner.nextLong();

        // valdidate the credit card number
        if(isValidCreditCard(cardNumber)){
            System.out.printIn("the credit card is a vaild number. ");
        }else{
            System.out.printIn("the crdit card is not valid. ");
        }

        // close the scanner
        scanner.close();

    }

}