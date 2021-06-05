package eapli.base.utils;

import java.util.Random;

public class GenerateRandomStringID {
    public static String generateRandomStringID(){
        Random rand = new Random();
        return generateRandomStringID(rand.nextInt(4)+3);
    }

    private static String generateRandomStringID(int number){
        String numbers = "0123456789";
        Random rand = new Random();
        StringBuilder toReturnID = new StringBuilder();
        for (int i=0;i<number;i++){
            toReturnID.append(numbers.charAt(rand.nextInt(numbers.length())));
        }
        return toReturnID.toString();
    }
}
