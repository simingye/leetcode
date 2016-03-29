package Interview;

import java.util.*;

/**
 * Created by Siming on 11/14/15.
 */
public class TopK
{
    public int[] getTopK(List<Integer>[] sortedLists, int k)
    {
        int result[] = new int[k];
        int length = sortedLists.length;
        int[] pointer = new int[length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Comparator<Map.Entry<Integer, Integer>> c = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> topk = new PriorityQueue<>(k, c);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pointer.length; i++)
        {
            pq.add(sortedLists[i].get(0));
        }

        while (pq.size() > 0)
        {
            int num = pq.poll();
            int count = 0;

            for (int i = 0; i < pointer.length; i++)
            {
                for (int j = pointer[i]; j < sortedLists[i].size(); j++)
                {
                    if (num == sortedLists[i].get(j))
                    {
                        count++;
                        pointer[i]++;
                    }
                    else if (num < sortedLists[i].get(j))
                    {
                        pq.add(sortedLists[i].get(j));
                        break;
                    }
                }
            }

            if (!map.containsKey(num))
                map.put(num, count);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (topk.size() < k)
            {
                topk.add(entry);
            }
            else
            {
                if (entry.getValue() > topk.peek().getValue())
                {
                    topk.poll();
                    topk.add(entry);
                }
            }
        }

        for (int i = 0; i < k; i++)
        {
            result[i] = topk.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(7);

        List<Integer>[] lists = new List[3];
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        TopK test = new TopK();
        test.getTopK(lists, 2);
    }
}
