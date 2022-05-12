package LeetCode;

import java.util.*;

public class Week286 {
    public static void main(String[] args) {
        Week286 week286 = new Week286();
        int[] nums = {2,6,2,5,8,9,7,2,2,5,6,2,2,0,6,8,7,3,9,2,1,1,3,2,6,2,4,6,5,8,4,8,7,0,4,8,7,8,4,1,1,4,0,1,5,7,7,5,9,7,5,5,8,6,4,3,6,5,1,6,7,6,9,9,6,8,6,0,9,5,6,7,6,9,5,5,7,3,0,0,5,5,4,8,3,9,3,4,1,7,9,3,1,8,8,9,1,6,0,0};
        int a = week286.minDeletion(nums);
        System.out.println(a);
    }
    //2215.(简单) 找出两数组的不同
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<List<Integer>> answer=new ArrayList<>();
        ArrayList<Integer> answer1=new ArrayList<>();
        ArrayList<Integer> answer2=new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(nums1[nums1.length-1]);
        for (int i = nums1.length-2; i >= 0; i--) {
            if (nums1[i] != stack.peek()) stack.add(nums1[i]);
        }
        int i = 0;
        int last = -1001;
        while (!stack.isEmpty() && i < nums2.length) {
            if (nums2[i] == last) {
                i++;
            } else if (stack.peek() < nums2[i]) {
                answer1.add(stack.pop());
            } else if (stack.peek() > nums2[i]) {
                last = nums2[i];
                answer2.add(last);
                i++;
            } else {
                stack.pop();
                last = nums2[i];
                i++;
            }
        }
        if (stack.isEmpty()) {
            for (int j = i; j < nums2.length; j++) {
                if (nums2[j] != last) {
                    last = nums2[j];
                    answer2.add(last);
                }
            }
        } else {
            while (!stack.isEmpty()) {
                if (stack.peek() != last) {
                    answer1.add(stack.pop());
                }
            }
        }
        answer.add(answer1);
        answer.add(answer2);
        return answer;
    }
    //2216.(中等) 美化数组的最少删除数
    public int minDeletion(int[] nums) {
        int result = 0;
        int last = nums[0];
        int isEven;
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                n++;
            } else {
                last = nums[i];
                if (n > 1) {
                    isEven = (i - n - result) % 2;
                    result += n - 1 - isEven;
                    n = 1;
                }
            }
        }
        if (n > 1) {
            result += n - 1;
        }
        if ((nums.length - result) % 2 != 0) {
            result++;
        }
        return result;
    }
}
