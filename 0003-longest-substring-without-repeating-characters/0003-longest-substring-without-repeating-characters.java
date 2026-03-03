class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Array to store last index of each character
        int[] lastSeen = new int[256]; 
        // Initialize all as -1 (not seen yet)
        for (int i = 0; i < 256; i++) lastSeen[i] = -1;

        int maxLen = 0;   // answer
        int start = 0;    // start of current window

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If character was seen before and is inside current window
            if (lastSeen[c] >= start) {
                // Move start to one after the last seen position
                start = lastSeen[c] + 1;
            }

            // Update last seen index of current character
            lastSeen[c] = i;

            // Update max length
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }
}