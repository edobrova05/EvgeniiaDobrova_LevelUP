package homework_3.task_1.ingredients;

abstract public class Foodstuff {
    private String name;
    private int gram;

    abstract public void take();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }
}
