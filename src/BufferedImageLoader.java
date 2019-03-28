import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BufferedImageLoader {

    public static BufferedImage loadImage(String path) throws IOException {

        try {
            BufferedImage image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            System.out.println("Img not loaded");
            return null;
        }
    }
}
