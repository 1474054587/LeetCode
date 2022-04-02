package LeetCode;

public class Week285 {
    /*
    2210.(简单) 统计数组中峰和谷的数量
    思路
    1.遍历数组第2个数至倒数第二个数
    2.获取上一个不相等数和下一个不相等数
    3.判断是否为峰或谷
    */
    public int countHillValley(int[] nums) {
        int last = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1] || nums[i]==last) continue;
            if ((nums[i] > last && nums[i] > nums[i+1])
                    || (nums[i] < nums[i+1] && nums[i] < last)
            ) result++;
            last = nums[i];
        }
        return result;
    }

    /*
    2211.(中等) 统计道路上的碰撞次数
    思路
    1.	将字符串转为字符数组，遍历
    2.	每次比对上一辆车和自身的方向
    3.	如果上一辆车向左，无碰撞
    4.	如果上一辆车静止
            如果自身向左，碰撞+1
            其他无碰撞
    5.	如果上一辆车向右，组成向右的车队，车队数量为1
            如果自身也向右，车队数量+1
            如果自身静止，与向右车队碰撞，碰撞+车队数量
            如果自身向左，与向右车队碰撞，碰撞+车队数量+1
    */
    public int countCollisions(String directions) {
        char[] cars = directions.toCharArray();
        char last = cars[0];
        int result = 0;
        int nums = 1;
        for (int i = 1; i < cars.length; i++) {
            if (last == 'L') {
                last = cars[i];
            } else if (last == 'S') {
                if (cars[i] == 'L') result++;
                else last = cars[i];
            } else {
                if (cars[i] == 'L') {
                    result += nums + 1;
                    nums = 1;
                    last='S';
                }
                else if (cars[i] == 'S') {
                    result += nums;
                    nums = 1;
                    last='S';
                } else {
                    nums++;
                }
            }
        }
        return result;
    }
}
