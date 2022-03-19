# 第一题

## 题目

![img](D:\Typora图片备份\1647662266736-b4ba62b6-66db-40af-ba52-190a12111f4e.png)

![img](D:\Typora图片备份\1647662294099-025b3f8e-a67f-4dab-a946-d591e1262011.png)

## 思路

1.	顺序找出每个 nums[ j ] == key3.

2.	end 为 最小值（j + k ，nums最后一位），防止数组越界

2.	start 为 最大值（j - k ，上一个end），避免重复

3.	将 start 到 end 放入 ArrayList，返回ArrayList

## 代码

~~~java
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
~~~



# 第二题

## 题目

![img](D:\Typora图片备份\1647663328146-f3f3e2c6-7b34-4549-a6ee-c045aa1c40ae.png)

![img](D:\Typora图片备份\1647663347145-768e587b-223c-4536-a33a-14ea4a112fb0.png)

## 思路

1.	新建一个二维数组[n][n]，代表网格

2.	所有 dig 的位置，网格=1

3.	如果一个 artifacts 的所有位置，网格都为1，则这个 artifacts 可以被挖出

4.	判断所有 artifacts ，返回可挖出数量

## 代码

~~~java
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
~~~

