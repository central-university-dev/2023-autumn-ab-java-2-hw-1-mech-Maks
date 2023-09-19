1) Изучить HashMap – написать что вы поняли о  HashMap (до 2 баллов)

2) Написать через функциональные интерфейсы цепочку обработчиков класса Person, которые 
  а) меняют маму с папой местами (такие времена) 
  б) логгируют “changed” (System.out.println()) 
  в) удаляют друга (friend = null) 
В роли цепочки использовать обычную коллекцию. (2 балла)
(Пояснения в тг)

3) Написать программу, которая в 3 потока увеличивает единичку до 30001. Кол-во инкрементаций в каждом потоке по 10000. (3 балла)

4) Интерфейс Iterable предоставляет итератор и метод forEach. В каких случаях forEach не сможет сделать то, что может итератор? Потыкайте, повыдумывайте кейсы (3 балла)

# Решение

## Задача 1:

> Изучить HashMap – написать что вы поняли о HashMap

Особенности `HashMap<>`:

- Часть Java Collection Framework
- Хранит пары ключ-значение, ключи уникальные.
- Работает за время подсчета хэша от ключа
- Несортированная коллекция
- Допускает единственный `null` ключ и множество `null` значений
- Не thread-safe
- Итерирование по содержимому: `HashMap<>::entrySet()`, `HashMap<>::keySet()`, `HashMap<>::values()`

## Задача 2:

> Написать через функциональные интерфейсы цепочку обработчиков класса Person, которые:
>
> a. меняют маму с папой местами
> 
> b. логгируют “changed” (System.out.println())

```java
...
Collection<Person> people = List.of(...);
people.stream()
    .peek(p -> {
        // swap mum and dad
        Person father = p.father;
        p.father = p.mother;
        p.mother = father;
    })
    .forEach(p -> {
        // print "changed"
        System.out.println("changed");
    });
...
```

## Задача 3:

> Написать программу, которая в 3 потока увеличивает единичку до 30001. Кол-во инкрементаций в каждом потоке по 10000.

```java
public static void main(String[] args) throws InterruptedException {
    AtomicInteger j = new AtomicInteger(1);
    int cnt = 10000;

    Runnable r = () -> {
        for (int i = 0; i < cnt; ++i) {
            j.incrementAndGet();
        }
    };

    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);
    Thread t3 = new Thread(r);

    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();

    System.out.println(j.get()); // 30001
}
```

## Задача 4:

> Интерфейс Iterable предоставляет итератор и метод forEach. В каких случаях forEach не сможет сделать то, что может итератор? Потыкайте, повыдумывайте кейсы

```java
public static void main(String[] args) throws InterruptedException {
    List<String> lst = new ArrayList<>();
    lst.add("a");
    lst.add("b");
    lst.add("c");
    lst.add("d");
    lst.add("e");
    System.out.println(lst); // [a, b, c, d, e]

    // Concurrent modification exception
    // lst.forEach(lst::remove); 
    
    // But with iterator works fine
    Iterator<String> it = lst.iterator();
    while (it.hasNext()) {
        String elem = it.next();
        it.remove();
    }

    System.out.println(lst); // []
}
```
