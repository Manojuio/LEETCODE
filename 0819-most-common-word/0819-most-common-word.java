class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        // 1. Convert to lowercase
        paragraph = paragraph.toLowerCase();

        // 2. Remove punctuation
        paragraph = paragraph.replaceAll("[^a-z ]", " ");

        // 3. Split into words
        String[] words = paragraph.split("\\s+");

        // 4. Store banned words
        HashSet<String> set = new HashSet<>();
        for (String word : banned) {
            set.add(word);
        }

        // 5. Count frequencies
        HashMap<String, Integer> map = new HashMap<>();

        String answer = "";
        int max = 0;

        for (String word : words) {

            if (set.contains(word)) {
                continue;
            }

            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);

            if (count > max) {
                max = count;
                answer = word;
            }
        }

        return answer;
    }
}