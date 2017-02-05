package com.acvrock.search;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by JM on 2016-10-16.
 */
public class SearchResult extends CopyOnWriteArrayList<IndexResult> {

    public int resultSum() {
        return this.size();
    }

    public Map<String, Long> resultCount() {
        return this.stream().map(indexResult -> indexResult.getFilename()).collect(groupingBy(word -> word, counting()));
    }
}
