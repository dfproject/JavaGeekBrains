package geekbrains.dfprojectJava.lesson3;

import java.awt.dnd.InvalidDnDOperationException;

public class MyDeque {
    private int[] deque = new int[0];
    private int size = 0;
    private int head = 0;
    private int tail = -1;

    private void allocateNewArray(int startingIndex)
    {
        int newLength = (size == 0) ? 4 : size * 2;

        int[] newArray = new int[newLength];

        if (size > 0)
        {
            int targetIndex = startingIndex;

            if (tail < head)
            {
                for (int index = head; index < deque.length; index++)
                {
                    newArray[targetIndex] = deque[index];
                    targetIndex++;
                }

                for (int index = 0; index <= tail; index++)
                {
                    newArray[targetIndex] = deque[index];
                    targetIndex++;
                }
            }
            else
            {
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
            head = 0;
            tail = -1;
        }

        deque = newArray;
    }
    public void EnqueueFirst(int item)
    {
        if (deque.length == size)
        {
            allocateNewArray(1);
        }

        if (head > 0)
        {
            head--;
        }
        else
        {
            head = deque.length - 1;
        }

        deque[head] = item;


        size++;

        if (size == 1)
        {
            tail = head;
        }
    }
    public void EnqueueLast(int item)
    {
        if (deque.length == size)
        {
            allocateNewArray(0);
        }

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
            head = 0;
        }
        else
        {
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
            tail = deque.length - 1;
        }
        else
        {
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
