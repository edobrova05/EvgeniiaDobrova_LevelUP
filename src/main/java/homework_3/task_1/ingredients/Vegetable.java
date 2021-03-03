package homework_3.task_1.ingredients;

import homework_3.task_1.KcalCountable;

public class Vegetable extends Foodstuff implements KcalCountable {

    public Vegetable(String name, int gram){
        super.setName(name);
        super.setGram(gram);
    }


    @Override
    public void take() {
        System.out.println("We took " + getGram() + " gram of " + getName() + ".");
    }

    @Override
    public int count() {
        switch(super.getName()){
            case "Potato":
                return (super.getGram() * 77)/100;
            case "Beet":
                return (super.getGram() * 43)/100;
            case "Carrot":
                return (super.getGram() * 41)/100;
            case "Cabbage":
                return (super.getGram() * 25)/100;
            case "Onion":
                return (super.getGram() * 40)/100;
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
