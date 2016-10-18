public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)) {
            int distance = Integer.MAX_VALUE;
            int current = -1;
            for(int i = 0; i < words.length; i++) {
                if(word1.equals(words[i])) {
                    if(current == -1)
                        current = i;
                    else if(i-current < distance) {
                        distance = i - current;
                        current = i;
                    }
                }
            }
        } else {
            int distance = Integer.MAX_VALUE;
            int pos1 = -1, pos2 = -1;
            for(int i = 0; i < words.length; i++) {
                if(word1.equals(words[i])) {
                    pos1 = i;
                    if(pos2 != -1 && pos1-pos2 < distance)
                        distance = pos1 - pos2;
                } else if(word2.equals(words[i])) {
                    pos2 = i;
                    if(pos1 != -1 && pos2-pos1 < distance)
                        distance = pos2 - pos1;
                }
            }
        }
        return distance;
    }
}
