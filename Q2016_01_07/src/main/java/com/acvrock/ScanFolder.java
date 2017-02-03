package com.acvrock;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JM on 2016-10-15.
 */
public class ScanFolder {

    private int level;  //递归的层级
    private List<Document> documentList = new ArrayList<>();//

    public ScanFolder(int level){
        this.level = level;
    }

    public void scan(String path, int flag){
        if(level<=flag){
            System.out.println("递归层级已满，退出！");
            return ;
        }
        if(StringUtils.isBlank(path)){
            throw new RuntimeException("path错误");
        }
        Document document = new Document();
        List<Word> words = new ArrayList<>();
        File rootFile = new File(path);
        File[] files = rootFile.listFiles();
        for(File file:files){
            if(file.isDirectory()){
                String childrenPath = file.getPath();
                scan(childrenPath,flag+1);
            }else{
                Word word = readFile(file);
                words.add(word);
            }
        }
        document.setFolderPath(path);
        document.setWords(words);
        documentList.add(document);
    }

    private Word readFile(File file){
        Word word = new Word();
        try {
            FileInputStream input = new FileInputStream(file);
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            String s = null;
            List<String> lines = new ArrayList<>();
            while((s = bufferedReader.readLine()) != null){
                lines.add(s);
            }
            word.setWords(lines);
            word.setFileName(file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }

    public List<Document> getDocumentList(){
        return documentList;
    }
}
