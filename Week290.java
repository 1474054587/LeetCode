package LeetCode;

import java.util.*;

public class Week290 {
    //2248.(简单)多个数组求交集
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<nums[0].length;i++){
            map.put(nums[0][i],1);
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                map.computeIfPresent(nums[i][j],(key,value)->value+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==len){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }

    //2249.(中等)统计圆内格点数目
    public int countLatticePoints(int[][] circles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
        for (int[] c : circles) {
            minX = Math.min(minX, c[0] - c[2]);
            minY = Math.min(minY, c[1] - c[2]);
            maxX = Math.max(maxX, c[0] + c[2]);
            maxY = Math.max(maxY, c[1] + c[2]);
        }
        int num = 0;
        int d;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                for (int[] c : circles) {
                    d = (i - c[0]) * (i - c[0]) + (j - c[1]) * (j - c[1]);
                    if (d <= c[2] * c[2]) {
                        num++;
                        break;
                    }
                }
            }
        }
        return num;
    }
}
