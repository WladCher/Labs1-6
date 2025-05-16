import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (indexMap.containsKey(needed)) {
                return new int[] { indexMap.get(needed), i };
            }
            indexMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No valid pair found");
    }
}
