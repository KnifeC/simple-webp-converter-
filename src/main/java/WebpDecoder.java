import com.luciad.imageio.webp.WebPReadParam;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WebpDecoder {

    public static void decode(String webpimagePath , String type , String objectImagePath ) throws IOException {
        // Obtain a WebP ImageReader instance
        ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();

        // Configure decoding parameters
        WebPReadParam readParam = new WebPReadParam();
        readParam.setBypassFiltering(true);

        // Configure the input on the ImageReader
        reader.setInput(new FileImageInputStream(new File(webpimagePath)));

        // Decode the image
        BufferedImage image = reader.read(0, readParam);

        ImageIO.write(image, type, new File(objectImagePath));
    }
}
