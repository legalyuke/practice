package letCode;

/**
 * @author liyuke
 * @date 2021-06-07 20:47
 * <p>
 * leetcode 第494题
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 */
public class Db494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[][] db = new int[n + 1][neg + 1];
        db[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int temp = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                db[i][j] = db[i - 1][j];
                if (j >= temp) {
                    db[i][j] += db[i - 1][j - temp];
                }
            }
        }
        return db[n][neg];


    }


    public static void main(String[] args) {
        Db494 db494 = new Db494();
        System.out.println(db494.findTargetSumWays(new int[]{1}, 2));
    }
}
