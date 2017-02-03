package com.acvrock;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by JM on 2016-10-16.
 */
public class SearchInFileImpl implements SearchInFileI{

    private String path;
    public SearchInFileImpl(String path){
        this.path = path;
    }
    @Override
    public SearchResult searchInFiles(String key) {
        List<Document> documents = this.searchFiles();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        WordCountTask task = new WordCountTask(0,documents.size(),documents,key);
        ForkJoinTask<ConcurrentHashMap<String, Integer>> future = forkJoinPool.submit(task);
        try {
            ConcurrentHashMap<String, Integer> countMap = future.get();
            Set<Map.Entry<String, Integer>> entries = countMap.entrySet();
            for(Map.Entry<String, Integer> entry:entries){
                String key1 = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("filename = "+key1+"     "+"value:"+value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Document> searchFiles(){
        ScanFolder scanFolder = new ScanFolder(3);
        scanFolder.scan(path, 1);
        List<Document> documentList = scanFolder.getDocumentList();
        return documentList;
    }

}
