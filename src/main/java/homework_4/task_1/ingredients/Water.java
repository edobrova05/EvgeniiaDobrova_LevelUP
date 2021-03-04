package homework_4.task_1.ingredients;

import homework_4.task_1.TooLittleWaterException;

public class Water {
    public String type;
    public int liter;

    public Water (String type, int liter){
        this.type = type;
        this.liter = liter;
    }

    public void boil() throws TooLittleWaterException {
        if(liter > 2) {
            System.out.println("We took " + liter + " liters of " + type + " and boiled it.");
        } else {
            throw new TooLittleWaterException("There's too little water in the pot. Add more!");
        }

    }

    public void cook(){
        System.out.println("Borsch is ready.");
    }

}
