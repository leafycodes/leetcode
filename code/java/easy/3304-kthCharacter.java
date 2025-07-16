class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            word.append(generateWord(word.toString()));
        }

        return word.charAt(k - 1);
    }

    private String generateWord(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) ((str.charAt(i) - 'a' + 1) % 26 + 'a'));
        }
        return sb.toString();
    }
}