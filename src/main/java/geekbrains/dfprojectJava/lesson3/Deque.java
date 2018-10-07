package geekbrains.dfprojectJava.lesson3;

import java.awt.dnd.InvalidDnDOperationException;

public class Deque {
    private int[] deque = new int[0];
    private int size = 0;
    private int head = 0;
    private int tail = -1;
//
//    public Deque(int s) {
//        size = s;
//        deque = new int[size];
//        head = 0;
//        tail = -1;

    private void allocateNewArray(int startingIndex)
    {
        int newLength = (size == 0) ? 4 : size * 2;

        int[] newArray = new int[newLength];

        if (size > 0)
        {
            int targetIndex = startingIndex;

            // Копируем содержимое...
            // Если массив не закольцован, просто копируем элементы.
            // В противном случае, копирует от head до конца, а затем от начала массива до tail.

            // Если tail меньше, чем head, переходим в начало.
            if (tail < head)
            {
                // Копируем _items[head].._items[end] в newArray[0]..newArray[N].
                for (int index = head; index < deque.length; index++)
                {
                    newArray[targetIndex] = deque[index];
                    targetIndex++;
                }

                // Копируем _items[0].._items[tail] в newArray[N+1]..
                for (int index = 0; index <= tail; index++)
                {
                    newArray[targetIndex] = deque[index];
                    targetIndex++;
                }
            }
            else
            {
                // Копируем _items[head].._items[tail] в newArray[0]..newArray[N]
                for (int index = head; index <= tail; index++)
                {
                    newArray[targetIndex] = deque[index];
                    targetIndex++;
                }
            }


            head = startingIndex;
            tail = targetIndex - 1;
        }
        else
        {
            // Массив пуст.
            head = 0;
            tail = -1;
        }

        deque = newArray;
    }
    public void EnqueueFirst(int item)
    {
        // Проверим, необходимо ли увеличение массива:
        if (deque.length == size)
        {
            allocateNewArray(1);
        }

        // Так как массив не заполнен и _head больше 0,
        // мы знаем, что есть место в начале массива.
        if (head > 0)
        {
            head--;
        }
        else
        {
            // В противном случае мы должны закольцеваться.
            head = deque.length - 1;
        }

        deque[head] = item;


        size++;

        if (size == 1)
        {
            // Если мы добавили первый элемент в пустую
            // очередь, он же будет и последним, поэтому
            // нужно обновить и _tail.
            tail = head;
        }
    }
    public void EnqueueLast(int item)
    {
        // Проверим, необходимо ли увеличение массива:
        if (deque.length == size)
        {
            allocateNewArray(0);
        }

        // Теперь, когда у нас есть подходящий массив,
        // если _tail в конце массива, нам надо перейти в начало.
        if (tail == deque.length - 1)
        {
            tail = 0;
        }
        else
        {
            tail++;
        }

        deque[tail] = item;
        size++;

        if (size == 1)
        {
            // Если мы добавили последний элемент в пустую
            // очередь, он же будет и первым, поэтому
            // нужно обновить и _head.
            head = tail;
        }
    }
    public int DequeueFirst()
    {
        if (size == 0)
        {
            throw new InvalidDnDOperationException("The deque is empty");
        }

        int value = deque[head];

        if (head == deque.length - 1)
        {
            // Если head установлен на последнем индексе, переходим к началу массива.
            head = 0;
        }
        else
        {
            // Переходим к следующему элементу.
            head++;
        }

        size--;

        return value;
    }
    public int DequeueLast()
    {
        if (size == 0)
        {
            throw new InvalidDnDOperationException("The deque is empty");
        }

        int value = deque[tail];

        if (tail == 0)
        {
            // Если tail установлен на начало массива, переходим к концу.
            tail = deque.length - 1;
        }
        else
        {
            // Переходим к предыдущему элементу.
            tail--;
        }

        size--;

        return value;
    }
    public int PeekFirst()
    {
        if (size == 0)
        {
            throw new InvalidDnDOperationException("The deque is empty");
        }

        return deque[head];
    }
    public int PeekLast()
    {
        if (size == 0)
        {
            throw new InvalidDnDOperationException("The deque is empty");
        }

        return deque[tail];
    }
}
