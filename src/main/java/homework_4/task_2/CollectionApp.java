package homework_4.task_2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionApp {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 1; i <= 100000; i++){
            list.add(i);
        }

        Collections.shuffle(list);
        System.out.println("Few elements of the collection: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }

        ArrayList<Integer> dividerTwo = new ArrayList<>();
        ArrayList<Integer> dividerThree = new ArrayList<>();
        ArrayList<Integer> dividerFive = new ArrayList<>();
        ArrayList<Integer> dividerSeven = new ArrayList<>();

        for(int i =0; i <= 99999; i++){
            int a = list.get(i);

            if (a%2 == 0) {
                dividerTwo.add(a);
            }
            if (a%2 == 0 && a%3 == 0){
                dividerTwo.add(a);
            }
            if (a%2 == 0 && a%5 == 0){
                dividerTwo.add(a);
            }
            if (a%2 == 0 && a%7 == 0){
                dividerTwo.add(a);
            }
            if (a%2 == 0 && a%3 == 0 && a%5 == 0){
                dividerTwo.add(a);
            }
            if (a%2 == 0 && a%3 == 0 && a%7 == 0){
                dividerTwo.add(a);
            }
            if (a%2 == 0 && a%5 == 0 && a%7 == 0){
                dividerTwo.add(a);
            }
            if (a%2 == 0 && a%3 == 0 && a%5 == 0 && a%7 == 0){
                dividerTwo.add(a);
            }
        }


        for(int i =0; i <= 99999; i++) {
            int b = list.get(i);

            if (b % 3 == 0) {
                dividerThree.add(b);
            }
        }

        for(int i =0; i <= 99999; i++) {
            int c = list.get(i);

            if (c % 5 == 0) {
                dividerFive.add(c);
            }
        }

        for(int i =0; i <= 99999; i++) {
            int d = list.get(i);

            if (d % 7 == 0) {
                dividerSeven.add(d);
            }
        }
    }
}
