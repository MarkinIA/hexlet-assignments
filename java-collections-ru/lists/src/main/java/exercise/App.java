package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App{
    public static boolean scrabble(String letters, String word) {
        letters = letters.toLowerCase();
        word = word.toLowerCase();
        String[] letterStr = letters.split("");
        String[] wordStr = word.split("");
        List<String> letterList = new ArrayList<>(Arrays.asList(letterStr));
        List<String> resLetters= new ArrayList<>();
        for (int i = 0; i <= wordStr.length - 1; i++) {
            if (letterList.contains(wordStr[i])) {
                resLetters.add(letterList.get(letterList.indexOf(wordStr[i])));
                letterList.remove(wordStr[i]);
            }
        }
        String resStr = String.join("", resLetters);
        return resStr.equals(word);
    }
}
//END
