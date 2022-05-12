package LeetCode;

public class Week288 {
    public static void main(String[] args) {
        Week288 week288 = new Week288();
        System.out.println(week288.minimizeResult("247+38"));
    }
    //2231.(简单)按奇偶性交换后的最大数字
    public int largestInteger(int num) {
        int[] integer = new int[10];
        boolean[] parity = new boolean[10];
        int len = 0;
        int result = 0;
        int temp;
        while (num != 0) {
            temp = num % 10;
            integer[temp]++;
            parity[len] = temp%2==0;
            len++;
            num /= 10;
        }
        for (int i = len-1; i >= 0; i--) {
            temp = parity[i] ? 8:9;
            while (integer[temp] == 0) temp-=2;
            result = result * 10 + temp;
            integer[temp]--;
        }
        return result;
    }

    //2232.(中等)向表达式添加括号后的最小结果
    public String minimizeResult(String expression) {
        int len = expression.length();
        int plus = expression.indexOf('+');
        int left = Integer.parseInt(expression.substring(0,plus));
        int right = Integer.parseInt(expression.substring(plus+1));
        int leftLen = plus;
        int rightLen = len - leftLen - 1;
        int n = leftLen * rightLen;
        int indexL,indexR,temp;
        int min = Integer.MAX_VALUE;
        int result = 0;
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            indexL = (i % leftLen) + 1;
            indexR = (i / leftLen) + 1;
            if (indexL == leftLen && indexR == rightLen) {
                list[i] = "("+expression+")";
                temp = left + right;
            } else if (indexL == leftLen) {
                indexR = (int)Math.pow(10,indexR);
                list[i] = "("+left+"+"+right/(indexR)+")" +right%indexR;
                temp = (left +(right / indexR))*(right % indexR);
            } else if (indexR == rightLen) {
                indexL = (int)Math.pow(10,indexL);
                list[i] = left/indexL+"("+left%indexL+"+"+right+")";
                temp = ((left % indexL)+right)*(left / indexL);
            } else {
                indexL = (int)Math.pow(10,indexL);
                indexR = (int)Math.pow(10,indexR);
                list[i] = left/indexL+"("+left%indexL+"+"+right/indexR+")"+right%indexR;
                temp = ((left % indexL)+(right / indexR))
                        *(left / indexL)*(right % indexR);
            }
            if (temp < min) {
                min = temp;
                result = i;
            }
        }
        return list[result];
    }
}
