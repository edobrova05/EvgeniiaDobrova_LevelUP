package homework_3.task_1.ingredients;

import homework_3.task_1.KcalCountable;

public class Meat extends Foodstuff implements KcalCountable {

    public Meat(String name, int gram){
        super.setName(name);
        super.setGram(gram);
    }


    @Override
    public void take() {
        System.out.println("We took " + super.getGram() + " gram of " + getName() + ".");
    }

    @Override
    public int count() {
        switch(super.getName()){
            case "Beef":
                return (super.getGram() * 250)/100;
            case "Pork":
                return (super.getGram() * 242)/100;
            default:
                System.out.println("Wrong ingredient.");
                return 0;
        }
    }

    @Override
    public String toString() {
        return "We cooked " + getName() + ".";
    }
}
