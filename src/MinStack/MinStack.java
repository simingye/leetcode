package MinStack;

import java.util.Stack;

/**
 * Created by Siming on 6/14/15.
 */
public class MinStack
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();
    int min;

    public void push (int x)
    {
        if (stack.isEmpty())
        {
            min = x;
        }

        stack.push(x);

        if (tempStack.isEmpty() || x <= tempStack.peek())
        {
            tempStack.push(x);
        }
    }

    public void pop ()
    {
        int num = stack.pop();
        if (num == tempStack.peek())
        {
            tempStack.pop();
        }
    }

    public int top ()
    {
        return stack.peek();
    }

    public int getMin ()
    {
        return tempStack.peek();
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(0);
        test.push(1);
        test.push(0);
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
    }
}
