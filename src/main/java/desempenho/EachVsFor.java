package desempenho;

import java.util.ArrayList;
import java.util.List;

public class EachVsFor {

    static ArrayList<Integer> teste = new ArrayList<Integer>();
    public static void main(String[] args) {
       for (Integer i=0; i<100000000; i++) {
           teste.add(i);
       }
        testeFor();
        teste2();
    }

    private static void testeFor() {
        Long start = System.currentTimeMillis();
        for (Integer i : teste) {
            //System.out.println("oi");
        }
        Long finish = System.currentTimeMillis();
        System.out.println("tempo com for:" + (finish-start));
    }

    private static void teste2() {
        Long start = System.currentTimeMillis();
        teste.forEach(it->
                {
                }
        );
        Long finish = System.currentTimeMillis();
        System.out.println("tempo com each:" + (finish-start));
    }
}
