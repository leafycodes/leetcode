/**
 * @param {number} n
 * @return {number[]}
 */
var lexicalOrder = function (n) {
    let nums = [];
    for (let i = 1; i <= n; i++) {
        nums.push(i);
    }

    nums = nums.sort();
    return nums;
};