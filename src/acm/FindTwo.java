package acm;

public class FindTwo {
    public static void main(String[] args) {
        int[][] array = {{1, 24, 45}, {2, 43, 64}};
        int target = 1;
        //从左节点开始遍历矩阵
        int len = array.length - 1;
        int i = 0;
        while ((len >= 0) && (i < array[len].length)) {
            if (array[len][i] > target) {
                len--;
            } else if (array[len][i] < target) {
                i++;
            } else {
                System.out.println("true");
                return;
            }
        }
    }
}
