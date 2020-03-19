import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: romag
 * Date: 2/20/20
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageResizer implements Runnable {
    private File[] files;
    private int newWidth;
    private String dstFolder;

    public ImageResizer(File[] files, int newWidth, String dstFolder) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
    }

    @Override
    public void run() {
        for (File file : files) {
            try {
                BufferedImage image = ImageIO.read(file);
                assert image != null;
                BufferedImage image2 = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT,image.getWidth()/2,image.getHeight()/2);
                int newHeight = (int) Math.round(image2.getHeight() / (image2.getWidth() / (double) newWidth));
                    BufferedImage bufferedImage = Scalr.resize(image2, newWidth, newHeight);
                    File newFile = new File(dstFolder + "/" + file.getName());
                    ImageIO.write(bufferedImage, "jpg", newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /*BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
i
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                );

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newHeight; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }*/
        }

    }
}

