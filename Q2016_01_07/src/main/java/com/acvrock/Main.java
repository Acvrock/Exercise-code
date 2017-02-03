package com.acvrock;

/**
 * Created by JM on 2016-10-17.
 */
public class Main {

    public static void main(String[] args) {
        String path = "/Users/moon/Github/Exercise-code/Q2016_01_07/src/main/java/com/acvrock";
        String searchKey = "JM";
        SearchInFileI searchInFile = new SearchInFileImpl(path);
        searchInFile.searchInFiles(searchKey);
    }
}
