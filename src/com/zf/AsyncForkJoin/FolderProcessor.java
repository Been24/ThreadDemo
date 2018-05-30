package com.zf.AsyncForkJoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Been on 2018/5/30.
 */
public class FolderProcessor extends RecursiveTask<List<String>> {
    private static final long serialVersionUID=1L;
    //存储任务将要处理的文件夹的完整路径
    private String path;
    //存储任务将要查找的文件的扩展名
    private String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        //存储文件夹中文件的名称
        List<String> list = new ArrayList<>();
        //存储子任务，这些子任务奖处理文件夹中的子文件夹
        List<FolderProcessor> tasks = new ArrayList<>();
        File file = new File(path);
        File content[] = file.listFiles();
        if (content != null) {
            for (int i=0;i<content.length;i++) {
                if (content[i].isDirectory()) {
                    FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                } else {
                    if (checkFile(content[i].getName())) {
                        list.add(content[i].getAbsolutePath());
                    }
                }
            }
            if (tasks.size() > 50) {
                System.out.printf("%s:%d tasks ran.\n", file.getAbsolutePath(), tasks.size());
            }
            addResultsFromTasks(list, tasks);

        }
        return list;
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }

    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor item : tasks) {
            list.addAll(item.join());
        }
    }
}
