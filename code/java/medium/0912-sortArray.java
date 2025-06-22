// mergeSort

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int si, int ei) {

        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        mergeSort(nums, si, mid);
        mergeSort(nums, mid + 1, ei);
        merge(nums, si, mid, ei);
    }

    private static void merge(int[] nums, int si, int mid, int ei) {
        int n = ei - si + 1;
        int[] temp = new int[n];
        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= ei) {
            temp[k++] = nums[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }
}

// Randomized quickSort

class Solution {
    public int[] sortArray(int nums[]){
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private static void quickSort(int[] nums, int si, int ei) {
        if (si >= ei)
            return;
        int pidx = partition(nums, si, ei);
        quickSort(nums, si, pidx - 1);
        quickSort(nums, pidx + 1, ei);
    }

    private static int partition(int[] nums, int si, int ei) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(ei - si + 1) + si;
        int pivot = nums[pivotIndex];

        swap(nums, pivotIndex, ei);

        int i = si - 1; 

        for (int j = si; j < ei; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, ei);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}