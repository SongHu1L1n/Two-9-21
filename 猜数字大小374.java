public class 猜数字大小374 {
    /*猜数字游戏的规则如下：

每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。
你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：

 1 : 你猜测的数字比系统选出的数字大
 -1 : 你猜测的数字比系统选出的数字小
 0 : 恭喜！你猜对了！
 

示例 :

输入: n = 10, pick = 6
输出: 6
     */
    int num;
    public int guessNumber(int n) {
        int low = 1, high = n;
        int mid1, mid2;
        int res1, res2;
        while (low <= high){
            mid1 = low + (high - low) / 2;
            mid2 = high - (high - low) / 2;
            if (guess(mid1) == 0){
                return mid1;
            }else if (guess(mid2) == 0){
                return mid2;
            }else {
                if (guess(mid1) == 1){
                    high = mid1;
                }else if (guess(mid1) == -1 && guess(mid2) == 1){
                    low = mid1;
                    high = mid2;
                }else {
                    low = mid2;
                }
            }
        }
        return -1;
    }
    public int guess(int n){
        if (n > num){
            return 1;
        }else if (n < num){
            return -1;
        }else {
            return 0;
        }
    }
}
