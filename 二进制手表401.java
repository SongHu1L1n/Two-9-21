import java.util.ArrayList;
import java.util.List;

public class 二进制手表401 {
  /*二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。

每个 LED 代表一个 0 或 1，最低位在右侧。
    例如，上面的二进制手表读取 “3:25”。

给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

 

示例：

输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]


   */
    List<String> result;
    public List<String> readBinaryWatch(int num) {
        result = new ArrayList<>();
        if (num < 0){
            return result;
        }
        int[] nums = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        backTrack(num, nums, 0, 0, 0);
        return result;
    }

    private void backTrack(int num, int[] nums, int start, int hour, int minute) {
        if (num == 0){
            if (hour > 11 || minute > 59){
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(hour);
            stringBuilder.append(":");

            if (minute < 10){
                stringBuilder.append("0");
            }
            stringBuilder.append(minute);
            result.add(new String(stringBuilder));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i < 4){
                hour += nums[i];
            }else {
                minute += nums[i];
            }
            backTrack(num - 1, nums, start + 1, hour, minute);

            if (i < 4){
                hour -= nums[i];
            }else {
                minute -= nums[i];
            }

        }

    }

}
