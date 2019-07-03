package de.pacesys.codechallenge.logic.impl;

import de.pacesys.codechallenge.api.GenerateImageRequest;
import de.pacesys.codechallenge.logic.IImageStorageService;
import de.pacesys.codechallenge.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private List<IImageStorageService> imageStorageServices;

    /**
     * creates an image from the requested parameters
     * @param imageRequest the definition for the image
     * @return an image
     */
    public Image getImage(GenerateImageRequest imageRequest) {
        List<Image> possiblePictures = new ArrayList<>();
        for (IImageStorageService service : imageStorageServices) {
            possiblePictures.addAll(service.getImages(imageRequest.getUtmZone(), imageRequest.getLatitudeBand(), imageRequest.getGridSquare(), imageRequest.getDate()));
        }
        Image result = null;
        List<Image> latestImages = filterLatest(possiblePictures);
        if (!latestImages.isEmpty()) {
            // combine the pictures!
            Image combined =  combine(latestImages);
            if (combined != null) {
                return encode(combined, "jpg");
            }
        }
        return result;
    }

    /**
     * filter out just the latest images for every sensor band because with more than one IImageStorageService
     * it would be possible that you will get pictures with different timestamps per sensor band.
     * @param images all images retrieved from the storages
     * @return a list of the latest images per sensor band
     */
    private List<Image> filterLatest (List<Image> images) {
        // as i don't have file to test this i will leave it just as the structure it might be filled later.
        return images;
    }

    /**
     * combines different sensor bands to a final picture
     * @param images the different sensor bands
     * @return a picture with all sensor bands
     */
    private Image combine (List<Image> images) {
        if (images == null || images.isEmpty()) {
            return null;
        }
        // currently i don't have a clue howto put these images together
        // i've found some examples on google but i don't fully understand all this right now
        // what i understand is that most of the example create an tif image with multiple pages
        // but i had understand from the given requirements that i should create an image that consists
        // of all the color information that comes from the different sensor bands
        // because of this i will just return the first image from the set

        return images.get(0);
    }

    /**
     * encodes the given image to the given type
     * @param image an image to convert/encode
     * @param type the target to be converted
     * @return an image of the target type
     */
    private Image encode(Image image, String type) {
        // here i would implement a strategy handler which will start the strategy that is assigned to type
        // and the strategy would then do all the stuff that is necessary to convert the picture (encoding and maybe zipping)
        // and return the final picture

        // i know that this was not part of the request but i think it would be nice to have somehting like this and
        // tell the service what type of image would be best imho.
        return image;
    }
}
