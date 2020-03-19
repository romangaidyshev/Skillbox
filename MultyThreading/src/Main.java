import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: romag
 * Date: 2/20/20
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static int newWidth = 300;
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
        String srcFolder = "resourses/src";
        String dstFolder = "resourses/dst";
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        assert files != null;
        int coresNum = files.length / cores;

        File[][] newArr = new File[cores][coresNum];

        int count = 0;
        for (int c = 0; c < cores; c++) {
            for (int j = 0; j < coresNum; j++) {
                if (count == files.length) {
                    break;
                }
                newArr[c][j] = files[count++];
            }
        }

        for (int i = 0; i < cores; i++) {
            new Thread(new ImageResizer(newArr[i], newWidth, dstFolder)).start();
        }
    }
}


