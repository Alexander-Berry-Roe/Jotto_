package com.berryroe.jotto_;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class Word {
    private String word;
    private List<String> wordList;
    private List<String> words;

    public Word(){
        try {
            wordList = Files.readAllLines(Paths.get("src\\main\\resources\\com\\berryroe\\jotto_\\betterwords.txt"));
            words = Files.readAllLines(Paths.get("src\\main\\resources\\com\\berryroe\\jotto_\\words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int max = 8858;
        int min = 0;
        word = wordList.get((int)Math.floor(Math.random()*(max-min+1)+min));
        System.out.println(word);
    }



    public boolean solved = false;

    public String checkWord(String guess) {
        String output = "";
        for (int i = 0; i < 5; i++) {
            if (guess.substring(i, i + 1).equalsIgnoreCase(this.word.substring(i, i + 1))) {
                output = output + "G";
            } else if (this.word.toUpperCase(Locale.ROOT).contains(guess.substring(i, i + 1))) {
                output = output + "Y";
            } else {
                output = output + "R";
            }

        }
        if (output.equals("GGGGG")) {
            solved = true;
        }
        return output;
    }

    public Boolean isInWordList(String word){
         word = word.toLowerCase();
         return wordList.contains(word);
    }



}
