import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> s_map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> p_map = new HashMap<Character, Integer>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if (s_map.containsKey(i)) {
                s_map.put(s.charAt(i), s_map.get(s.charAt(i)) + 1);
            } else {
                s_map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < p.length(); i++) {
            if (p_map.containsKey(i)) {
                p_map.put(p.charAt(i), p_map.get(p.charAt(i)) + 1);
            } else {
                p_map.put(p.charAt(i), 1);
            }
        }
        int right = p.length();
        int left = 0;
        while (right != s.length()) {
            System.out.print(s_map);
            if (s_map.equals(p_map))
                list.add(left);
            right++;
            if (s_map.get(s.charAt(left)) > 1) {
                s_map.put(s.charAt(left), s_map.get(s.charAt(left)) - 1);
            } else {
                s_map.remove(s.charAt(left));
            }
            if (right < s.length() - 1) {
                if (s_map.containsKey(s.charAt(right))) {
                    s_map.put(s.charAt(right), s_map.get(s.charAt(right)) + 1);
                } else {
                    s_map.put(s.charAt(right), 1);
                }

            }
            left++;
        }
        return list;
    }
}