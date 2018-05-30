package com.zf.ForkJoin;

import java.util.Random;

/**
 * Created by Been on 2018/5/30.
 */
public class DocumentMock {
    private String words[]={"the","hello","goodbye","thread","main"};

    /**
     *
     * @param numLines
     * @param numWords 每一行词的个数
     * @param word
     * @return
     */
    public String[][] generateDocument(int numLines, int numWords, String word) {
        int counter=0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();
        for (int i=0;i<numLines;i++) {
            for (int j=0;j<numWords;j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (document[i][j].equals(word)) {
                    counter++;
                }
            }
        }
        System.out.println("DocumentMock:The word apperas" + counter + "times in the document");
        return document;
    }
}
