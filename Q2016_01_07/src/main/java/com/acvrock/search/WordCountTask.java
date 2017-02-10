package com.acvrock.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.RecursiveTask;

/**
 * Created by JM on 2016-10-15.
 */
public class WordCountTask extends RecursiveTask<SearchResult> {

    private int first;
    private int last;
    private Path[] paths;
    private String searchWord;

    public WordCountTask(int first, int last, Path[] paths, String searchWord) {
        this.first = first;
        this.last = last;
        this.paths = paths;
        this.searchWord = searchWord;
        System.out.println("init first = [" + first + "], last = [" + last + "], paths = [" + paths + "], searchWord = [" + searchWord + "]");
    }

    @Override
    protected SearchResult compute() {
        SearchResult countList = new SearchResult();
        if (last - first < 20) {
            countList = wordCount();
        } else {
            int middle = (last + first) / 2;
            WordCountTask wordCountTask1 = new WordCountTask(first, middle, paths, searchWord);
            WordCountTask wordCountTask2 = new WordCountTask(middle, last, paths, searchWord);
            wordCountTask1.fork();
            wordCountTask2.fork();
            countList.addAll(wordCountTask1.join());
            countList.addAll(wordCountTask2.join());
        }
        return countList;
    }

    public SearchResult wordCount() {
        SearchResult countList = new SearchResult();
        for (int j = first; j < last; j++) {
            Path path = paths[j];
            byte[] bytes = null;
            try {
                bytes = Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            indexOf(bytes, searchWord.getBytes(), path, countList);
        }
        return countList;
    }

    public static void indexOf(byte[] array, byte[] target, Path path, SearchResult countList) {
        if (null == array || null == target) return;
        outer:
        for (int i = 0; i < array.length - target.length + 1; i++) {
            for (int j = 0; j < target.length; j++) if (array[i + j] != target[j]) continue outer;
            countList.add(new IndexResult(String.valueOf(path), i, new String(target)));
            continue outer;
        }
    }
}
