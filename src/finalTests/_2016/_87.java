package finalTests._2016;

public class _87 {
    /**
     * count substring that start and ends in c in string
     * @param s
     * @param c
     * @param k how many c can appear between start and end
     * @return
     */
    public static int subStrMaxC(String s, char c, int k) {
        int counter = 0;
        int countWords = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == c) {
                if (counter > 0) countWords += Math.min(k + 1, counter);
                counter++;
            }
        }

        return countWords;
    }


}
