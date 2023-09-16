package homework1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        for(int i=0; i<10; i++){
            numbers.add(i);
        }


        int b = 1;
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()){
            int a = it.next();
            System.out.print(a + " ");
            if(a == 5 && b == 1){
                it.remove();
                it = numbers.iterator();
                b = 0;
            }
            //1 можно перезапустить иторатор при каком-то значении
        }

        System.out.println();

        int c = 1;
        numbers.forEach(a -> {
            if(a==5 && c==1){
                numbers.remove(a);
                //c = 0; будет ошибка
            }
        });
        System.out.println(numbers);
        //1 forEach нельзя перезапустить один раз его включив


        it = numbers.iterator();
        if(it.hasNext()){
            it.next();
        }
        it.forEachRemaining(System.out::print); //2 вывод будет со второго элемента. C forEach так сделать не получится


    }
}