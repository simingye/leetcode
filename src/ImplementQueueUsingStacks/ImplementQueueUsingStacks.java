package ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * Created by SimingYe on 1/19/16.
 */
public class ImplementQueueUsingStacks
{
    Stack<Integer> stackOne = new Stack<>();

    public void push(int x)
    {
        stackOne.push(x);
    }

    public void pop()
    {
        Stack<Integer> stackTwo = new Stack<>();

        while (!stackOne.isEmpty())
        {
            if (stackOne.size() != 1)
            {
                int temp = stackOne.pop();
                stackTwo.push(temp);
            }
            else
            {
                stackOne.pop();
            }
        }

        while (!stackTwo.isEmpty())
        {
            int temp = stackTwo.pop();
            stackOne.push(temp);
        }
    }

    public int peek()
    {
        Stack<Integer> stackTwo = (Stack<Integer>) stackOne.clone();

        while (stackTwo.size() != 1)
        {
            stackTwo.pop();
        }

        return stackTwo.pop();
    }

    public boolean empty()
    {
        return stackOne.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks test = new ImplementQueueUsingStacks();
        test.push(1);
        test.push(2);
        System.out.println(test.peek());
        System.out.println(test.peek());
    }
}
