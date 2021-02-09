package prosayj.thinking.hightconcurrent._07_fork_join_framework.support;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:14
 * @since 1.0.0
 */
public class ForkJoinRecursiveAction extends RecursiveAction {
    private final File sourceFiles;
    /**
     * 源文件夹
     */
    private final String sourceUrl;
    /**
     * 目标文件夹
     */
     private final String targetUrl;


    public ForkJoinRecursiveAction(String sourceUrl,String targetUrl) {
        this.sourceFiles = new File(sourceUrl);
        this.sourceUrl=sourceUrl;
        this.targetUrl=targetUrl;
    }

    @Override
    protected void compute() {
        List<ForkJoinRecursiveAction> subTasks = new ArrayList<>();

        File[] sourceFiles = this.sourceFiles.listFiles();
        if (sourceFiles != null) {
            for (File sourceFile : sourceFiles) {
                String absolutePath = sourceFile.getAbsolutePath();
                String targetDir = absolutePath.replace(sourceUrl, targetUrl);
                File targetPath = new File(targetDir);
                if (sourceFile.isDirectory()) {
                    targetPath.mkdirs();
                    subTasks.add(new ForkJoinRecursiveAction(sourceUrl,targetUrl));
                } else {
                    try {
                        Files.copy(sourceFile.toPath(), targetPath.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!subTasks.isEmpty()) {
                for (ForkJoinRecursiveAction subTask : invokeAll(subTasks)) {
                    subTask.join();
                }
            }
        }
    }
}
