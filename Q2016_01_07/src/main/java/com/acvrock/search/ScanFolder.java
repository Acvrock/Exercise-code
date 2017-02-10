package com.acvrock.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by JM on 2016-10-15.
 */
public class ScanFolder {

    private int maxDepth;  //递归的层级
    private String suffix;
    private String path;

    public ScanFolder(String path, int maxDepth, String suffix) {
        this.maxDepth = maxDepth;
        this.suffix = suffix;
        this.path = path;
    }

    public Path[] scan() throws IOException {
        Path start = Paths.get(path);
        Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).endsWith(suffix));
        Path[] paths = stream.toArray(size -> new Path[size]);
        return paths;

    }
}
