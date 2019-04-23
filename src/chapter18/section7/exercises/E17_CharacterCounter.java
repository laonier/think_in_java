package chapter18.section7.exercises;

import chapter18.section7.TextFile;
import common.Constant;

import java.util.*;

public class E17_CharacterCounter {
    public static void main(String[] args) {
        String filename = Constant.PATH_CHAPTER18_SECTION07 + "/exercises/E17_CharacterCounter.java";
        Map<Character, Integer> charCounter = new HashMap<>();
        for (String word: new TextFile(filename, "\\W+")) {
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                Integer count = 1;
                if (charCounter.containsKey(ch)) {
                    count += charCounter.get(ch);
                }
                charCounter.put(ch, count);
            }
        }
        List<Character> keys = new ArrayList<>(charCounter.keySet());
        Collections.sort(keys);
        for (Character ch: keys) {
            System.out.println(ch + " => " + charCounter.get(ch));
        }
    }
}
