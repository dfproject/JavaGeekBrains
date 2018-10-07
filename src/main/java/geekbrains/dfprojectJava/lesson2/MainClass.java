package geekbrains.dfprojectJava.lesson2;

public class MainClass {

    public static void main(String[] args) {
//        int size = 1000000; не хватит памяти для миллиона int'ов, поэтому используем short
        short size = (short) 1000000;
        int search = 501367;
        MyArr myArr = new MyArr(size);  // 1. Создать массив большого размера (миллион элементов).
        for (int i = 0; i < size; i++) {
            myArr.insert((int)(Math.random()*1000000));  // 3. Заполнить массив случайными числами.
        }
        myArr.mix();

        if (myArr.find(search)){
            myArr.delete(search);
            System.out.println("Элемент " +search+ " удален");
        } else {
            System.out.println("Не удалось найти элемент "+search);
        }
        System.out.println("Выводим новый массив");
        myArr.display();

        System.out.println("Элемент есть в массиве: " + myArr.binaryFind(search));
        System.out.println("Засекаем время выполнения сортировок:");

//       4. Написать методы, реализующие рассмотренные виды сортировок и проверить скорость выполнения каждой.
        long start1 = System.currentTimeMillis();
        myArr.sortBubble();
        long finish1 = System.currentTimeMillis() - start1;
        System.out.println("Пузырьковая сортировка: " + finish1);

        myArr.mix();

        long start2 = System.currentTimeMillis();
        myArr.sortSelect();
        long finish2 = System.currentTimeMillis() - start2;
        System.out.println("Сортировка методом выбора: " + finish2);

        myArr.mix();

        long start3 = System.currentTimeMillis();
        myArr.sortInsert();
        long finish3 = System.currentTimeMillis() - start3;
        System.out.println("Cортировка методом вставки: " + finish3);
    }
}
