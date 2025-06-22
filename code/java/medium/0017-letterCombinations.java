class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, digits, new StringBuilder(), map);
        return res;
    }

    private void backtrack(int index, String digits, StringBuilder temp, Map<Character, String> map) {
        if (index >= digits.length()) {
            res.add(temp.toString());
            return;
        }

        char ch = digits.charAt(index);
        String str = map.get(ch);

        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtrack(index + 1, digits, temp, map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}

// way 2

class Solution {
    public List<String> letterCombinations(String num) {
        if (num == null || num.length() == 0) {
            return res;
        }
        combinations(num, 0, num.length(), new StringBuilder());
        return res;
    }

    final static String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    List<String> res = new ArrayList<>();

    private void combinations(String num, int i, int n, StringBuilder currStr) {
        if (i == n) {
            res.add(currStr.toString());
            return;
        }

        String currNum = letters[num.charAt(i) - '0'];

        for (int k = 0; k < currNum.length(); k++) {
            currStr.append(currNum.charAt(k));
            combinations(num, i + 1, n, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}

// same but more readable

class Solution {
    public List<String> letterCombinations(String num) {
        if (num == null || num.length() == 0) {
            return res;
        }
        combinations(num, 0, num.length(), new StringBuilder());
        return res;
    }

    final static String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    List<String> res = new ArrayList<>();

    private void combinations(String num, int i, int n, StringBuilder currStr) {
        if (i == n) {
            res.add(currStr.toString());
            return;
        }

        String currNum = letters[num.charAt(i) - '0'];

        for (int k = 0; k < currNum.length(); k++) {
            currStr.append(currNum.charAt(k));
            combinations(num, i + 1, n, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}