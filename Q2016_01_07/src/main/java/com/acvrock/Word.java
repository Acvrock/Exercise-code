package com.acvrock;

import java.util.List;

/**
 * Created by JM on 2016-10-15.
 */
public class Word {
    private String fileName;
    private List<String> words;

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Word{" +
                "fileName='" + fileName + '\'' +
                ", words=" + words +
                '}';
    }
}
