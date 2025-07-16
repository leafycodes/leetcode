class Solution {
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private boolean isCons(char ch) {
        ch = Character.toLowerCase(ch);
        return Character.isLetter(ch) && !isVowel(ch);
    }

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean vowel = false;
        boolean cons = false;
        boolean invalid = false;

        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (isVowel(ch)) {
                    vowel = true;
                } else if (isCons(ch)) {
                    cons = true;
                }
            } else if (!Character.isDigit(ch)) {
                invalid = true;
            }
        }

        return !invalid && vowel && cons;
    }
}