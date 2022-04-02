package LeetCode;

import java.util.*;

class Week283 {
    /*
    2194.(简单) Excel 表中某个范围内的单元格
    思路：
    1.字符串拆分
    2.字符转整形，获取行、列起始值、截止值
    3.两层for循环，先列后行拼接字符串，加入list
     */
    public List<String> cellsInRange(String s) {
        char[] list = s.toCharArray();
        String x;
        List<String> result = new ArrayList<>();
        int c1 = (int) list[0];
        int c2 = (int) list[3];
        int r1 = Integer.parseInt(s,1,2,10);
        int r2 = Integer.parseInt(s,4,5,10);
        for (int i = c1; i <= c2; i++) {
            for (int j = r1; j <= r2; j++) {
                x = "" + (char)i + j;
                result.add(x);
            }
        }
        return result;
    }
    /*
    2195.(中等) 向数组中追加 K 个整数
    思路：
    1.nums从小到大排序
    2.贪心算法累加
     */
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0, start = 1;
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (start < nums[i]) {
                int cnt = (nums[i] - start) > k ? k : (int) (nums[i] - start);
                ans += (2L * start + cnt - 1) * cnt / 2;
                k -= cnt;
            }
            start = nums[i] + 1;
        }
        if (k > 0) {
            ans += (2L * start + k - 1) * k / 2;
        }
        return ans;
    }
    /*
    2196.(中等) 根据描述创建二叉树
    思路：
    1.构造所有二叉树
    2.将所有二叉树放进Map，key为其头结点，所有二叉树子节点放进Set
    3.根据 isLeft 将父TreeNode与子TreeNode链接
    4.查找Map中的key，如Set中没有，则为根结点
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,TreeNode> map = new HashMap<>();
        TreeNode root = null;
        for (int[] node : descriptions) {
            int p = node[0];
            int c = node[1];
            TreeNode parent = map.get(p);
            TreeNode child = map.get(c);
            boolean isLeft = (node[2] == 1);
            if (map.get(p)==null){
                parent = new TreeNode(p);
                map.put(p,parent);
            }
            if (map.get(c)==null){
                child = new TreeNode(c);
                map.put(c,child);
            }
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            set.add(c);
        }
        for (int value : map.keySet()) {
            if (!set.contains(value)) {
                root = map.get(value);
                break;
            }
        }
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*
    2197.(困难) 替换数组中的非互质数
    思路：
    1.将数组倒序填入单调栈（当然顺序也可以，这样最后就要把栈反转，复杂度差不多）
    2.每次入栈时，循环弹出栈顶两个元素并比较，直到只剩一个元素
    3.比较：如两元素不互质，最小公倍数入栈；如互质，都入栈，循环终止
    4.将栈赋给list，返回list
     */
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; i--) {
            stack.push(nums[i]);
            while (stack.size() > 1) {
                int x = stack.pop();
                int y = stack.pop();
                int gcd = gcd(x, y);
                if (gcd == 1) {
                    stack.add(y);
                    stack.add(x);
                    break;
                } else {
                    stack.push((x/gcd)*y);
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
