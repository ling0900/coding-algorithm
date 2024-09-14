package leetcode.lh.nonday.day03;

class Solution {
    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }


        // 先定义两个为止
        int m = searchLeftIndex(nums, target);
        int n = searchRightIndex(nums, target);
        

        int[] res = new int[0];
        
        if (m == -1 || n == -1) {
            return new int[]{-1, -1};
        }
        
        if (nums[m] == nums[n]) {
            res = new int[]{m, n};
        }
        return res;
    }

    private static int searchLeftIndex(int [] nums, int target) {

        int indexLeft = 0;
        int indexRight = nums.length - 1;
        int middleIndex = 0;
        int resultIndex = 0;

        while (indexLeft <= indexRight) {
            middleIndex = (indexLeft + indexRight) / 2;

            if (indexLeft == indexRight) {
                if (nums[middleIndex] == target) {
                    resultIndex = middleIndex;
                }
                break;
            }

            if (nums[middleIndex] == target) { // 那么这个为止以左有可能还有和 target 相等的
                indexRight = middleIndex;
                resultIndex = middleIndex;
            } else if (nums[middleIndex] > target) { // 也是需要往左拓展区域
                indexRight = middleIndex;
            } else if (nums[middleIndex] < target) {

                indexLeft = middleIndex + 1;
            }
        }

        return resultIndex;
    }

    private static int searchRightIndex(int [] nums, int target) {

        int indexLeft = 0;
        int indexRight = nums.length - 1;
        int middleIndex = 0;
        int resultIndex = -1;

        while (indexLeft <= indexRight) {
            middleIndex = (indexLeft + indexRight) / 2;

            if (indexLeft == indexRight) {
                if (nums[middleIndex] == target) {
                    resultIndex = middleIndex;
                }
                break;
            }

            if (nums[middleIndex] == target) { // 那么这个为止以左有可能还有和 target 相等的
                resultIndex = middleIndex;
                indexLeft = middleIndex + 1;
            } else if (nums[middleIndex] > target) { // 也是需要往左拓展区域
                indexRight = middleIndex - 1;
            } else if (nums[middleIndex] < target) {

                indexLeft = middleIndex + 1;
            }
        }

        return resultIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        int i1 = searchRightIndex(nums, target);
//        System.out.println(i1);
        int[] i = searchRange(nums, target);
        for (int m : i) {
            System.out.println(m);
        }
    }
}
