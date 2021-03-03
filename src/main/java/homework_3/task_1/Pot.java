package homework_3.task_1;

import homework_3.task_1.ingredients.Foodstuff;
import homework_3.task_1.ingredients.Meat;
import homework_3.task_1.ingredients.Vegetable;
import homework_3.task_1.ingredients.Water;

import java.util.ArrayList;

public class Pot {
    ArrayList<Foodstuff> borschList = new ArrayList<Foodstuff>();

    public void putIntoPot(Vegetable vegetable){
        borschList.add(vegetable);
    }

    public void putIntoPot(Meat meat){
        borschList.add(meat);
    }

    public void cook(){

        System.out.println("Borsch is cooked. It is very delicious!");
    }
}
