package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week293 {
    //2273.(简单) 移除字母异位词后的结果数组
    public List<String> removeAnagrams(String[] words) {
        int[] lastList = new int[26];
        char[] word;
        List<String> result = new ArrayList<>();
        for(int i=0; i<words.length;i++){
            word = words[i].toCharArray();
            int[] list = new int[26];
            for(int j=0; j<word.length;j++){
                list[word[j]-97]++;
            }
            for(int j=0;j<26;j++){
                if(list[j]!=lastList[j]){
                    lastList=list;
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    //2274.(中等) 不含特殊楼层的最大连续楼层数
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int big = Math.max(special[0]-bottom,top-special[special.length-1]);
        for(int i=1;i<special.length;i++){
            big=Math.max(big,special[i]-special[i-1]-1);
        }
        return big;
    }

    //2275.(中等) 按位与结果大于零的最长组合
    public int largestCombination(int[] candidates) {
        int[] list = new int[24];
        for(int item : candidates){
            for(int i=0;i<24;i++){
                if((1<<i & item) > 0){
                    list[i]++;
                }
            }
        }
        int longest=0;
        for(int i=0;i<24;i++){
            longest=Math.max(longest,list[i]);
        }
        return longest;
    }

}
