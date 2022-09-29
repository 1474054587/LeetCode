package LeetCode;

import java.util.HashMap;
import java.util.Iterator;

public class Week289 {
    //2243.(简单)计算字符串的数字和
    public String digitSum(String s, int k) {
        while(s.length()>k){
            s=fun(s,k,s.length());
        }
        return s;
    }
    public String fun(String s,int k,int len){
        int sum=0;
        if(len<=k){
            for(int i=0;i<s.length();i++){
                sum+=Integer.parseInt(s.charAt(i)+"");
            }
            return sum+"";
        } else{
            for(int i=0;i<k;i++){
                sum+=Integer.parseInt(s.charAt(i)+"");
            }
            return sum+fun(s.substring(k),k,len-k);
        }
    }

    //2244.(中等)完成所有任务需要的最少轮数
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int sum =0;
        int i;
        for(i=0;i<tasks.length;i++){
            map.computeIfPresent(tasks[i],(key,value)->value+1);
            map.putIfAbsent(tasks[i],1);
        }
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            i = iterator.next();
            if(i==1){
                return -1;
            }else{
                sum+=i/3;
                if(i%3!=0){
                    sum++;
                }
            }
        }
        return sum;
    }
}
