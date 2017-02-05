package com.acvrock.search;

/**
 * Created by moon on 05/02/2017.
 *
 * @Description:
 */
public class IndexResult {
    private String filename;
    private int index;
    private String searchKey;

    public String getFilename() {
        return filename;
    }

    public int getIndex() {
        return index;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public IndexResult(String filename, int index, String searchKey) {
        this.filename = filename;
        this.index = index;
        this.searchKey = searchKey;
    }

    @Override
    public String toString() {
        return "IndexResult{" +
                "filename='" + filename + '\'' +
                ", index=" + index +
                ", searchKey='" + searchKey + '\'' +
                '}';
    }
}
