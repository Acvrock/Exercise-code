package com.acvrock.search;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by JM on 2016-10-16.
 */
public class SearchInFileImpl implements SearchInFileI {

    private String path;
    private String suffix;
    private int level;

    public SearchInFileImpl(String path, String suffix, int level) {
        this.path = path;
        this.suffix = suffix;
        this.level = level;
    }

    @Override
    public SearchResult searchInFiles(String key) {
        try {
            ScanFolder scanFolder = new ScanFolder(path, level, suffix);
            Path[] pathStream = scanFolder.scan();
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            WordCountTask task = new WordCountTask(0, pathStream.length, pathStream, key);
            ForkJoinTask<SearchResult> future = forkJoinPool.submit(task);
            return  future.get();
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
