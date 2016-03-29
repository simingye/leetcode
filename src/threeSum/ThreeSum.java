package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Siming on 7/6/15.
 */
public class ThreeSum
{
//    public List<List<Integer>> threeSum (int[] nums)
//    {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        Arrays.sort(nums);
//
//        if (nums == null || nums.length < 3)
//            return result;
//
//        for (int i = 0; i < nums.length - 2; i++)
//        {
//            if (i == 0 || nums[i] > nums[i - 1])
//            {
//                int negate = -nums[i];
//                int start = i + 1;
//                int end = nums.length - 1;
//
//                while (start < end)
//                {
//                    if (nums[start] + nums[end] == negate)
//                    {
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[start]);
//                        temp.add(nums[end]);
//                        result.add(temp);
//
//                        start++;
//                        end--;
//
//                        while (nums[start] == nums[start - 1] && start < end)
//                            start++;
//
//                        while (nums[end] == nums[end + 1] && start < end)
//                            end--;
//                    }
//                    else if (nums[start] + nums[end] < negate)
//                    {
//                        start++;
//                    }
//                    else
//                    {
//                        end--;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
    
    public List<List<Integer>> threeSum (int[] nums)
    {
        if (nums == null || nums.length < 3)
            return null;

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                List<Integer> arrayList = new ArrayList<>();

                if (!map.containsKey(nums[i] + nums[j]))
                {
                    arrayList.add(Math.min(nums[i], nums[j]));
                    arrayList.add(Math.max(nums[i], nums[j]));
                    map.put(-1 * (nums[i] + nums[j]), arrayList);
                }
                else
                {
                    if (!result.contains(sort(nums[i] + nums[j], map.get(nums[i] + nums[j]))))
                    {
                        result.add(sort(nums[i] + nums[j], map.get(nums[i] + nums[j])));
                    }
                }
            }
        }
        return result;
    }

    public List<Integer> sort (int num, List<Integer> arrayList)
    {
        List<Integer> res = new ArrayList<>();

        for (int element : arrayList)
        {
            res.add(element);
        }

        if (num <= res.get(0))
        {
            res.add(0, num);
        }
        else if (num > res.get(0) && num <= res.get(1))
        {
            res.add(1, num);
        }
        else if (num > arrayList.get(1))
        {
            res.add(2, num);
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int nums[] = new int[] {0,0,0};
        System.out.println(test.threeSum(nums));
    }
}
