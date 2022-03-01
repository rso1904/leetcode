class Solution {
    public int prefixCount(String[] words, String pref) {
        return Stream.of(words).filter(word -> word.startsWith(pref)).collect(Collectors.toList()).size();
    }
}