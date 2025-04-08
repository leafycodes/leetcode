/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    let pattern = '^' + p + '$';
    let regex= new RegExp(pattern);
    return regex.test(s);
};