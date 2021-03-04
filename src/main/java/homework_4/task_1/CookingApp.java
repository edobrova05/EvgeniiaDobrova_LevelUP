package homework_4.task_1;

import homework_4.task_1.ingredients.Meat;
import homework_4.task_1.ingredients.Vegetable;
import homework_4.task_1.ingredients.Water;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CookingApp {
    public static void main(String[] args) {
        readRecipe();
        System.out.println();
        System.out.println();

        Water water = new Water("Still water", 1);
        Vegetable potato = new Vegetable("Potato", 600);
        Vegetable beet = new Vegetable("Beet", 300);
        Vegetable carrot = new Vegetable("Carrot", 200);
        Vegetable cabbage = new Vegetable("Cabbage", 200);
        Vegetable onion = new Vegetable("Onion", 150);
        Meat beef = new Meat("Beef", 400);


        Pot myPot = new Pot();
        myPot.putIntoPot(potato);
        myPot.putIntoPot(beet);
        myPot.putIntoPot(carrot);
        myPot.putIntoPot(cabbage);
        myPot.putIntoPot(onion);
        myPot.putIntoPot(beef);

        potato.take();
        beet.take();
        carrot.take();
        cabbage.take();
        onion.take();
        beef.take();
        System.out.println();

        try {
            water.boil();
        } catch (TooLittleWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("It's very important to check the amount of water.");
            System.out.println();
        }

        System.out.println(potato.toString());
        System.out.println(beet.toString());
        System.out.println(carrot.toString());
        System.out.println(cabbage.toString());
        System.out.println(onion.toString());
        System.out.println(beef.toString());
        System.out.println();

        myPot.cook();
        System.out.println();

        System.out.println("Calorie content of borsch is "
                + (potato.count()
                + beet.count()
                + carrot.count()
                + cabbage.count()
                + onion.count()
                + beef.count())
                + " kcal.");
        System.out.println();

        writeNotes();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter amount of calories you're allowed to eat: ");
        int amount = scan.nextInt();

        if (amount >= potato.count()){
            System.out.println("You can eat potato, it has less calories.");
        }
        if (amount >= beet.count()){
            System.out.println("You can eat beet, it has less calories.");
        }
        if (amount >= carrot.count()){
            System.out.println("You can eat carrot, it has less calories.");
        }
        if (amount >= cabbage.count()){
            System.out.println("You can eat cabbage, it has less calories.");
        }
        if (amount >= onion.count()){
            System.out.println("You can eat onion, it has less calories.");
        }
        if (amount >= beef.count()){
            System.out.println("You can eat beef, it has less calories.");
        }
        if (amount < potato.count() && amount < beet.count() && amount < carrot.count() && amount < cabbage.count() && amount < onion.count() && amount < beef.count()){
            System.out.println("There's no product you can eat on your diet.");
        }

    }

    public static void readRecipe() {
        try {
            FileReader reader = new FileReader("C:\\Users\\edobrova\\Desktop\\LEVEL UP\\3. HOMETASKS\\Files\\Recipe.txt");
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }

        reader.close();

        } catch(FileNotFoundException exception) {
            System.out.println("File not found.");
        } catch (IOException exception){
            System.out.println("Input/Output " + exception.getMessage());
        }
    }

    public static void writeNotes() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\edobrova\\Desktop\\LEVEL UP\\3. HOMETASKS\\Files", true);
            writer.write(" Next time you need 4 liters water.");

            writer.close();

        } catch (IOException exception){
            System.out.println("Input/Output Exception: " + exception.getMessage());
        }

    }


}