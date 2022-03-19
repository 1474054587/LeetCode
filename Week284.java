package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Week284 {
    //2200.(简单) 找出数组中的所有 K 近邻下标
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
    //2201. (中等)统计可以提取的工件
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
