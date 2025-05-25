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

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        HashMap<Character, String> patToWord = new HashMap<>();
        HashMap<String, Character> wordToPat = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++){
            char pat = pattern.charAt(i);
            String word = words[i];
            //String sub = s.split(i);
            if( patToWord.containsKey(pat)){
                if(!patToWord.get(pat).equals(word)) {return false;}
            }
            else{
                patToWord.put(pat, word);
            }
            if (wordToPat.containsKey(word)){
                if(wordToPat.get(word)!= pat) return false;}
            else {
                wordToPat.put(word, pat);
            }


        }


        return true;

    }
}