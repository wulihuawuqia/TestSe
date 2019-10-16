package leedcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 描述:
 * 三数之和 为0
 *
 * @author qia.wu
 * @create 2019-09-30 15:31
 * @see leedcode
 */
public class Test15 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(threeSumTwo(new int[]{-1, 0, 1, 2, -1, -4})));
        System.out.println(JSON.toJSON(threeSumTwo(new int[]{0, 0, 0, 0})));
        System.out.println(JSON.toJSON(threeSumTwo(new int[]{1, 1, -2})));

        System.out.println(JSON.toJSON(threeSumThree(new int[]{-1, 0, 1, 2, -1, -4})));
        System.out.println(JSON.toJSON(threeSumThree(new int[]{0, 0, 0, 0})));
        System.out.println(JSON.toJSON(threeSumThree(new int[]{1, 1, -2})));
    }

    public static List<List<Integer>> threeSumThree(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * 1、如果数组长度小于3 则直接返回空数组
     * 2、首先按从小打到排序
     * 3、然后遍历数组，如果元素大于0 直接结束遍历
     * 4、如果当前元素== 前一位元素，直接跳过
     * 5、设置标识位
     * 6、循环遍历元素，如果三数之和==0 则加入结果集，注意如果有两个元素相等，则跳过此元素
     * 7、
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumTwo(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, HashMap<String, List<Integer>>> map = new HashMap();
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                Integer sum = nums[i] + nums[j];
                HashMap<String, List<Integer>> curMap = map.get(sum);
                List<Integer> two = new ArrayList<>();
                List<Integer> value = new ArrayList<>();
                value.add(nums[i]);
                value.add(nums[j]);
                two.add(i);
                two.add(j);
                if (null != curMap) {
                    // 除重专用
                    Collections.sort(value);
                    curMap.put(value.toString(), two);
                } else {
                    curMap = new HashMap<>();
                    curMap.put(value.toString(), two);
                }
                map.put(sum, curMap);
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            HashMap<String, List<Integer>> curMap = map.get(-nums[i]);
            if (null != curMap) {
                for (List<Integer> cc : curMap.values()) {
                    List<Integer> e = new ArrayList<>();
                    if (i != cc.get(0) && i != cc.get(1)) {
                        e.add(nums[i]);
                        e.add(nums[cc.get(0)]);
                        e.add(nums[cc.get(1)]);
                        Collections.sort(e);
                        String eStr = e.toString();
                        if (!set.contains(eStr)) {
                            result.add(e);
                            set.add(eStr);
                        }
                    }
                }
            }
        }
        return result;
    }


}
