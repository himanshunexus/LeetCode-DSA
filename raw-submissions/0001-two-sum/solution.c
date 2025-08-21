int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int* result = (int*)malloc(2 * sizeof(int));  // allocate memory for result
    *returnSize = 2;  // always return 2 indices

    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                return result;  // return indices immediately
            }
        }
    }

    return NULL;  // in case no solution (but per constraints, always exists)
}

