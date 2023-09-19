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
        //////////////////////////////////////////////////
        it = numbers.iterator();
        while (it.hasNext()){
            int a = it.next();
            System.out.print(a + " ");
            if(a == 2){
                break;
            }
            //2 можно временно остановить работу и продолжить с последнего момента
        }
        System.out.print("-Временное прекращение работы-");
        while (it.hasNext()){
            int a = it.next();
            System.out.print(a + " ");
        }

        System.out.println();
        //////////////////////////////////////////////////
        int c = 1;
        numbers.forEach(a -> {
            if(a==5 && c==1){
                numbers.remove(a);
                //c = 0; будет ошибка
            }
        });
        System.out.println(numbers);
        //3 forEach нельзя перезапустить один раз его включив

        //////////////////////////////////////////////////
        it = numbers.iterator();
        if(it.hasNext()){
            it.next();
        }
        it.forEachRemaining(System.out::print); //4 вывод будет со второго элемента. C forEach так сделать не получится

        //////////////////////////////////////////////////
        try {
            numbers.forEach(a -> {
                System.out.print(a + " ");
                if(a==2){
                    numbers.remove(a);
                    System.out.println("stop");
                    return;
                    //5 прекратит перебор, но выдаст ошибку, поэтому надо окружить try-catch
                }
            });
        }catch (Exception ignored){}
        //6 forEach можно остановить, но будет ошибка.
        //И в следующий раз запустится опять с первого элемента, а не как Iterator

        //////////////////////////////////////////////////
        it = numbers.iterator();
        it.forEachRemaining(a -> {
            System.out.print(a + " ");
            numbers.remove(a);
        }); //7 удалении из коллекции по которой проходит итераций приведет к ошибке

    }
}