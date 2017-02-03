package com.acvrock;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

/**
 * Created by JM on 2016-10-15.
 */
public class WordCountTask extends RecursiveTask<ConcurrentHashMap<String, Integer>> {

    private int first;
    private int last;
    private List<Document> documentList;
    private String searchWord;

    public WordCountTask(int first, int last, List<Document> documentList, String searchWord) {
        this.first = first;
        this.last = last;
        this.documentList = documentList;
        this.searchWord = searchWord;
    }

    @Override
    protected ConcurrentHashMap<String, Integer> compute() {
        ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<>();
        if (last - first < 5) {
            countMap = wordCount();
        } else {
            int midlle = (last - first) / 2;
            WordCountTask wordCountTask1 = new WordCountTask(0, midlle, documentList, searchWord);
            WordCountTask wordCountTask2 = new WordCountTask(midlle + 1, last, documentList, searchWord);
            wordCountTask1.fork();
            wordCountTask2.fork();
            countMap.putAll(wordCountTask1.join());
            countMap.putAll(wordCountTask2.join());
        }
        return countMap;
    }

    public ConcurrentHashMap<String, Integer> wordCount() {
        ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<>();
        for (int j = first; j < last; j++) {
            Document document = documentList.get(j);
            for (Word word : document.getWords()) {
                int count = 0;
                for (String s : word.getWords()) {
                    if ((s.indexOf(searchWord)) != -1) count++;
                }
                if (count != 0) {
                    countMap.put(document.getFolderPath() + "\\" + word.getFileName(), count);
                }
            }
        }
        return countMap;
    }

}
