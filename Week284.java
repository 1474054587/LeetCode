package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Week284 {
    /*
    2200.(简单) 找出数组中的所有 K 近邻下标
    思路
    1.顺序找出每个 nums[ j ] == key3.
    2.end 为 最小值（j + k ，nums最后一位），防止数组越界
    3.start 为 最大值（j - k ，上一个end），避免重复
    4.将 start 到 end 放入 ArrayList，返回ArrayList
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int start = 0;
        int end = 0;
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                start = Math.max(start,i-k);
                end = Math.min(len-1,i+k);
                while (start <= end) {
                    list.add(start++);
                }
            }
        }
        return list;
    }
    /*
    2201. (中等)统计可以提取的工件
    思路
    1.新建一个二维数组[n][n]，代表网格
    2.所有 dig 的位置，网格=1
    3.如果一个 artifacts 的所有位置，网格都为1，则这个 artifacts 可以被挖出
    4.判断所有 artifacts ，返回可挖出数量
     */
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] map = new int[n][n];
        int num = 0;
        for (int[] ints : dig) {
            map[ints[0]][ints[1]] = 1;
        }
        for (int[] ints : artifacts) {
            boolean canDig = true;
            out:
            for (int i = ints[0]; i <= ints[2]; i++) {
                for (int j = ints[1]; j <= ints[3]; j++) {
                    if (map[i][j] != 1) {
                        canDig = false;
                        break out;
                    }
                }
            }
            if (canDig) {
                num++;
            }
        }
        return num;
    }
}
