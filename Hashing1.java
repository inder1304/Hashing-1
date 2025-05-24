class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sToT.containsKey(sc)) {
                if (sToT.get(sc) != tc) return false;
            } else {
                sToT.put(sc, tc);
            }

            if (tToS.containsKey(tc)) {
                if (tToS.get(tc) != sc) return false;
            } else {
                tToS.put(tc, sc);
            }
        }

        return true;
    }
}


/* //Brute - Force O(n^2)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // Check if this mapping is consistent throughout the string
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == sc) {
                    if (t.charAt(j) != tc) return false;
                } else if (t.charAt(j) == tc) {
                    if (s.charAt(j) != sc) return false;
                }
            }
        }

        return true;
    }
}
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
}