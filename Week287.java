package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Week287 {
    public static void main(String[] args) {
        int[][] a = new int[2][4];
        Week287 week287 = new Week287();
        week287.findWinners(a);
    }
    //2224.(简单) 转化时间需要的最少操作数
    public int convertTime(String current, String correct) {
        int hour1 = Integer.valueOf(current.substring(0, 2));
        int minute1 = Integer.valueOf(current.substring(3,5));
        int hour2 = Integer.valueOf(correct.substring(0, 2));
        int minute2 = Integer.valueOf(correct.substring(3,5));
        int n = hour2 - hour1;
        int minuteDifference = minute2 - minute1;
        if (minuteDifference < 0) {
            minuteDifference+=60;
            n-=1;
        }
        while (minuteDifference > 0) {
            if (minuteDifference >= 15) {
                minuteDifference-=15;
            } else if (minuteDifference >= 5) {
                minuteDifference-=5;
            } else {
                minuteDifference-=1;
            }
            n+=1;
        }
        return  n;
    }

    //2225.(中等) 找出输掉零场或一场比赛的玩家
    public List<List<Integer>> findWinners(int[][] matches) {
        ArrayList<Integer> noLose = new ArrayList<>();
        ArrayList<Integer> oneLose = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        int n = matches.length;
        int biggist = 0;
        int[][] list = new int[100001][2];
        for (int[] i : matches) {
            list[i[0]][0]+=1;
            list[i[1]][1]+=1;
            if (i[0] > biggist) biggist = i[0];
            if (i[1] > biggist) biggist = i[1];
        }
        for (int i = 1; i <= biggist; i++) {
            if (list[i][0] != 0 && list[i][1] == 0) {
                noLose.add(i);
            } else if (list[i][1] == 1) {
                oneLose.add(i);
            }
        }
        result.add(noLose);
        result.add(oneLose);
        return result;
    }
}
