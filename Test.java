/*给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
[-1, 0, 1],
[-1, -1, 2]
]*/
package lianxi0517;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list  = new ArrayList<>();
        if(nums.length == 0 || nums.length == 1){
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if( i -1 >=0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left +1 <right && nums[left] == nums[left+1]){
                        left ++;
                    }
                    while(right -1>left&&nums[right] == nums[right -1]){
                        right --;
                    }
                    left ++;
                    right --;
                }else if(sum < 0){
                    left ++;
                }else{
                    right --;
                }
            }

        }
        return list;
    }
}