package Interview;

import java.util.*;

/**
 * Created by Siming on 11/16/15.
 */
public class Solution
{
    public static void main (String args[]) throws Exception
    {
        Solution test = new Solution();

        Scanner sc = new Scanner(System.in);

        //get number of job description
        int numJobDes = sc.nextInt();

        Map<String, List<Integer>> map = new HashMap<>();

        //read job description word by word, and save them into the hashmap
        for (int i = 0; i < numJobDes; i++)
        {
            String line = sc.nextLine();
            String[] words = line.split(" ");

            for (int j = 0; j < words.length; j++)
            {
                if (map.containsKey(words[j]))
                {
                    map.get(words[j]).add(i + 1);
                    map.put(words[j], map.get(words[j]));
                }
                else
                {
                    map.put(words[j], new ArrayList<Integer>());
                }
            }
        }

        //get the number of outputs
        int numOutputs = sc.nextInt();

        List<String> queryList = new ArrayList<>();
        for (int i = 0; i < numOutputs; i++)
        {
            queryList.add(sc.nextLine());
        }

        //get the result of each query and print
        for (int i = 0; i < queryList.size(); i++)
        {
            test.queryOutput(map, queryList.get(i));
        }
    }

    /**
     * parse the query and get the result
     * @param map
     * @param query
     */
    public static void queryOutput(Map<String, List<Integer>> map, String query)
    {
        if (!query.contains("|") && !query.contains("&"))
        {
            //get rid of meaningless spaces
            String queryWord = query.trim();
            List<Integer> result = map.get(queryWord);
            printOutput(result);
            System.out.println(" ");
        }
        else if (query.contains("|"))
        {
            //get rid of meaningless spaces
            String queryWord1 = query.split("|")[0].trim();

            //get rid of meaningless spaces
            String queryWord2 = query.split("|")[1].trim();

            List<Integer> result1 = map.get(queryWord1);
            List<Integer> result2 = map.get(queryWord2);

            printOutput(result1);
            printOutput(result2);
            System.out.println(" ");
        }
        else if (query.contains("&"))
        {
            //get rid of meaningless spaces
            String queryWord1 = query.split("&")[0].trim();

            //get rid of meaningless spaces
            String queryWord2 = query.split("&")[1].trim();

            List<Integer> result1 = map.get(queryWord1);
            List<Integer> result2 = map.get(queryWord2);

            List<Integer> unionResult = new ArrayList<>();

            for (int element : result1)
            {
                if (!unionResult.contains(element))
                {
                    unionResult.add(element);
                }
            }

            for (int element : result2)
            {
                if (!unionResult.contains(element))
                {
                    unionResult.add(element);
                }
            }

            printOutput(unionResult);
            System.out.println(" ");
        }
    }

    /**
     * print the result on the console
     * @param result
     */
    public static void printOutput(List<Integer> result)
    {
        StringBuilder sb = new StringBuilder();

        for (int element : result)
        {
            if (!sb.toString().contains(String.valueOf(element)))
            {
                sb.append(element + " ");
            }
        }

        System.out.print(sb.toString());
    }
}
