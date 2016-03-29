package Interview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Siming on 10/11/15.
 */
public class test
{
    public void map()
    {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        treeMap.put(2, 2);
        treeMap.put(6, 6);
        treeMap.put(100,100);
        treeMap.put(50, 50);

        for (int i : treeMap.values())
        {
            System.out.println(i);
        }
    }

    public void priorityQueue()
    {
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        PriorityQueue<String> pq = new PriorityQueue<>(5, c);
        pq.add("f");
        pq.add("d");
        pq.add("c");
        pq.add("ac");
        pq.add("abc");

        while (!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }
    }

    public static void main(String[] args) {
//        test t = new test();
//        t.priorityQueue();
//        System.out.println("a".compareTo("b"));

        int i = Integer.valueOf("123");



        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt());
    }
}
