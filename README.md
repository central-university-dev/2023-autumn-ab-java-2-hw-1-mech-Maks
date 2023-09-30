1) Изучить HashMap – написать что вы поняли о  HashMap (до 2 баллов)  
**(решение в src/main/java/edu/example/txt/hashmap.txt)**

2) Написать через функциональные интерфейсы цепочку обработчиков класса Person, которые 
  а) меняют маму с папой местами (такие времена) 
  б) логгируют “changed” (System.out.println()) 
  в) удаляют друга (friend = null) 
В роли цепочки использовать обычную коллекцию. (2 балла)  
(Пояснения в тг)  
**(решение в src/main/java/edu/example/processors/*.java)**  
**(тесты в src/test/java/edu/example/PersonProcessorTest.java)**

3) Написать программу, которая в 3 потока увеличивает единичку до 30001. Кол-во инкрементаций в каждом потоке по 10000. (3 балла)  
**(решение в src/main/java/edu/example/concurrency/ConcurrencyAdder.java)**  
**(тесты в src/test/java/edu/example/ConcurrencyAdderTest.java)**

4) Интерфейс Iterable предоставляет итератор и метод forEach. В каких случаях forEach не сможет сделать то, что может итератор? Потыкайте, повыдумывайте кейсы (3 балла)  
**(решение в src/main/java/edu/example/txt/iterable_and_for_each.txt)**