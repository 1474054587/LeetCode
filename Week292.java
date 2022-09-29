package LeetCode;

public class Week292 {
    //2264.(简单)字符串中最大的 3 位相同数字
    public String largestGoodInteger(String num) {
        String index = "0";
        int length = 0;
        int[] list = new int[10];
        for (int i = 0; i < num.length(); i++) {
            if (index.equals(num.substring(i))) {
                length++;
                if (length == 3) {
                    list[Integer.parseInt(num.substring(i))]++;
                }
            } else {
                index = num.substring(i);
                length = 1;
            }
        }
        for (int i = 9; i >= 0 ; i--) {
            if (list[i] > 0) {
                return i*111+"";
            }
        }
        return "";
    }
}
