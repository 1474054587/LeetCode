package LeetCode;

import java.util.HashMap;

public class Week291 {
    //2259.(简单)移除指定数字得到的最大结果
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i)==digit){
                index = i;
                if(i<number.length()-1 && number.charAt(i)<number.charAt(i+1)){
                    break;
                }
            }
        }
        sb.append(number.substring(0,index));
        sb.append(number.substring(index+1));
        return sb.toString();
    }

    //2260.(中等)必须拿起的最小连续卡牌数
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int num = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; i++){
            if(map.containsKey(cards[i])){
                num = Math.min(num,(i - map.get(cards[i]) + 1));
            }
            map.put(cards[i],i);
        }
        if (num == Integer.MAX_VALUE) num = -1;
        return num;
    }
}
