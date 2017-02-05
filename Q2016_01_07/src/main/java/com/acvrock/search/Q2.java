package com.acvrock.search;

/**
 * Created by moon on 2016-10-17.
 */
public class Q2 {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //获取开始时间
        String path = "/Users/moon/Github/";
        String suffix = ".java";
        String searchKey = "com";
        SearchInFileI searchInFile = new SearchInFileImpl(path, suffix, 8);
        SearchResult indexResults = searchInFile.searchInFiles(searchKey);
        System.out.println(String.format("%s 总共出现 %s 次",searchKey,indexResults.resultSum()));
         indexResults.resultCount().forEach((key, value) -> {
            System.out.println(String.format("其中 %d 次出现在 %s 文件中",value,key));
        });
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
