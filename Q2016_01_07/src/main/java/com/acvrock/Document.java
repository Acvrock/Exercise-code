package com.acvrock;

import java.util.List;

/**
 * Created by JM on 2016-10-15.
 */
public class Document {

    private String folderPath;
    private List<Word> words;

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public String toString() {
        return "Document{" +
                "folderPath='" + folderPath + '\'' +
                ", words=" + words +
                '}';
    }
}
