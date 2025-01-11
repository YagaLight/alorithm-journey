import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
public class MainTest {
    /**
     * 题目：已知三个int型数据中，两个相同，找出不同于这两个数的第三个数
     * @param nums
     * @return
     */
    public int DifferNumber(int[] nums){
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
    @Test
    public void Test01(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入三个整数，并以空格分隔：");
        String input = scanner.nextLine();
        int[] nums = new int[3];
        String[] tokens = input.split(" ");
        while (tokens.length != 3) {
            System.out.println("输入的数字数量不正确，请输入三个整数！");
        }
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        System.out.println("不同的数字是："+ DifferNumber(nums));
        // 关闭 scanner 对象
        scanner.close();
    }

    enum Weekday{
        MONDAY("星期一"),
        TUESDAY("星期二"),
        WEDNESDAY("星期三"),
        THURSDAY("星期四"),
        FRIDAY("星期五"),
        SATURDAY("星期六"),
        SUNDAY("星期天");

        //枚举常量对应的中文星期名称
        private final String weekName;
        Weekday(String weekName) {
            this.weekName = weekName;
        }
        public String getWeekName() {
            return weekName;
        }
    }
    @Test
    public void Test02(){
        // 创建一个 Scanner 对象读取输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字（1-7）代表星期几：");
        // 读取用户输入的数字
        int input = scanner.nextInt();
        // 根据输入的数字输出对应的星期
        if (input >= 1 && input <= 7) {
            // 使用枚举获取对应的星期名称
            Weekday day = Weekday.values()[input - 1];
            System.out.println("对应的星期是：" + day.getWeekName());
        } else {
            System.out.println("输入无效，请输入一个 1 到 7 之间的数字。");
        }
        // 关闭 scanner
        scanner.close();
    }


    @Test
    public void Test03(){
        // 创建 Scanner 对象读取输入
        Scanner scanner = new Scanner(System.in);
        // 提示用户输入分数
        System.out.println("请输入学生的分数（0-100）：");
        int score = scanner.nextInt();
        // 检查分数是否合法
        if (score < 0 || score > 100) {
            System.out.println("请输入有效的分数，分数应在 0 到 100 之间！");
        } else {
            // 使用 switch 语句根据分数的范围进行评级
            String rating;
            switch (score / 10) {  // 将 score 除以 10 来判断区间
                case 0:   // 0 <= score < 10
                case 1:   // 10 <= score < 20
                case 2:   // 20 <= score < 30
                case 3:   // 30 <= score < 40
                case 4:   // 40 <= score < 50
                case 5:   // 50 <= score < 60
                    rating = "不及格";
                    break;
                case 6:   // 60 <= score < 70
                    rating = "及格";
                    break;
                case 7:   // 70 <= score < 80
                    rating = "中";
                    break;
                case 8:   // 80 <= score < 90
                    rating = "良";
                    break;
                case 9:   // 90 <= score < 100
                case 10:  // 100
                    rating = "优";
                    break;
                default:
                    rating = "输入无效";
            }
            // 输出结果
            System.out.println("学生成绩评级为: " + rating);
        }
        // 关闭 scanner 对象
        scanner.close();
    }


    @Test
    public void Test04(){
        // 遍历所有三位数
        for (int num = 100; num < 1000; num++) {
            // 获取百位、十位和个位的数字
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int ones = num % 10;

            // 计算各位数字的立方和
            int sumOfCubes = (hundreds * hundreds * hundreds) + (tens * tens * tens) + (ones * ones * ones);

            // 判断是否是水仙花数
            if (sumOfCubes == num) {
                System.out.println(num);
            }
        }
    }


    // 判断一个数字是否为素数的方法
    public boolean isPrime(int num) {
        if (num < 2) {
            return false; // 0 和 1 不是素数
        }
        // 只需要检查到 num 的平方根即可
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // 如果能被 i 整除，说明 num 不是素数
            }
        }
        return true; // 否则 num 是素数
    }
    @Test
    public void Test05(){
        int count = 0; // 用于统计素数的个数
        // 遍历101到200之间的每个数字
        for (int num = 101; num <= 200; num++) {
            if (isPrime(num)) {
                System.out.println(num); // 输出素数
                count++; // 素数计数加1
            }
        }
        // 输出素数的总个数
        System.out.println("在101到200之间，共有 " + count + " 个素数。");
    }

    @Test
    public void Test06(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入三个整数，并以空格分隔：");
        String input = scanner.nextLine();
        int[] nums = new int[3];
        String[] tokens = input.split(" ");
        while (tokens.length != 3) {
            System.out.println("输入的数字数量不正确，请输入三个整数！");
        }
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        // 使用 Arrays.sort() 对数组进行排序
        Arrays.sort(nums);
        // 输出排序后的结果
        System.out.println("从小到大的顺序是: " + nums[0] + ", " + nums[1] + ", " + nums[2]);
        scanner.close();
    }

    @Test
    public void Test07(){
        Scanner scanner = new Scanner(System.in);
        // 输入一个不多于5位的正整数
        System.out.print("请输入一个不多于5位的正整数: ");
        int num = scanner.nextInt();
        // 一、求它是几位数
        int length = (int) Math.log10(num) + 1;
        System.out.println("该数字是 " + length + " 位数。");

        // 二、逆序打印出各位数字
        System.out.print("逆序打印各位数字: ");
        while (num > 0) {
            int digit = num % 10;  // 获取最后一位数字
            System.out.print(digit); // 输出当前数字
            num = num / 10;  // 去掉最后一位数字
        }
        scanner.close();
    }

}
