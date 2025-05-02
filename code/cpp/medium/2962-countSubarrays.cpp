class Solution {
    public:
        long long countSubarrays(vector<int>& nums, int k) {
            int n = nums.size();
            int maxVal = 0;
            for (int num : nums) {
                maxVal = max(maxVal, num);
            }
    
            int left = 0, count = 0;
            long long result = 0;
    
            for (int right = 0; right < n; ++right) {
                if (nums[right] == maxVal) count++;
    
                while (count >= k) {
                    if (nums[left] == maxVal) count--;
                    left++;
                }
    
                result += left;
            }
    
            return result;
        }
    };
    