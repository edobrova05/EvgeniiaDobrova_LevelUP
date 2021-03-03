package homework_3.task_1.ingredients;

public class Water {
    public String type;
    public int liter;

    public Water (String type, int liter){
        this.type = type;
        this.liter = liter;
    }

    public void boil(){
        System.out.println("We took " + liter + " liters of " + type + " and boiled it.");
    }

    public void cook(){
        System.out.println("Borsch is ready.");
    }

}
