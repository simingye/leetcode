package ImplementStackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Siming on 12/10/15.
 */
public class ImplementStackUsingQueue
{
    Queue<Integer> queue = new LinkedList<>();

    public void push(int x)
    {
        this.queue.add(x);
    }

    public void pop()
    {
        Queue<Integer> tempQueue = new LinkedList<>();
        int size = this.queue.size();
        for (int i = 0; i < this.queue.size(); i++)
        {
            if (size - 1 != i)
            {
                tempQueue.add(this.queue.poll());
            }
        }

        this.queue = new LinkedList<>(tempQueue);
    }

    public int top()
    {
        Queue<Integer> tempQueue = new LinkedList<>();
        int result = 0;
        int size = this.queue.size();
        for (int i = 0; i < size; i++)
        {
            if (size - 1 != i)
            {
                tempQueue.add(this.queue.poll());
            }
            else
            {
                tempQueue.add(this.queue.peek());
                result = this.queue.poll();
                this.queue = new LinkedList<>(tempQueue);
            }
        }

        return result;
    }

    public boolean empty()
    {
        return this.queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueue test = new ImplementStackUsingQueue();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.top());
        test.pop();
        System.out.println(test.top());
    }
}
