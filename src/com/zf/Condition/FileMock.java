package com.zf.Condition;

/**
 * Created by Been on 2018/5/29.
 */
public class FileMock {
    private String content[];
    private  int index;

    /**
     * 初始化文件内容
     * @param size
     * @param length
     */
    public FileMock(int size, int length) {
        content = new String[size];
        for (int i=0;i<size;i++) {
            StringBuilder bd = new StringBuilder(length);
            for (int j=0;j<length;j++) {
                int indice = (int) Math.random() * 255;
                bd.append((char) indice);
            }
            content[i] = bd.toString();
        }
        index=0;
    }
    /**
     *
     */
    public boolean hasMoreLines(){
        return index<content.length;
    }
    /**
     * 返回index指定的行内容，自增1
     */
    public String getLine() {
        if(this.hasMoreLines()){
            System.out.println("Mock:" + (content.length - index));
            return content[index++];
        }
        return null;
    }
}
