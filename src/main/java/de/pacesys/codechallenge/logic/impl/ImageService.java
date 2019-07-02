package de.pacesys.codechallenge.logic.impl;

import de.pacesys.codechallenge.api.GenerateImageRequest;
import de.pacesys.codechallenge.logic.IImageStorageService;
import de.pacesys.codechallenge.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private List<IImageStorageService> imageStorageServices;

    public Image getImage(GenerateImageRequest imageRequest) {
        List<Image> possiblePictures = new ArrayList<>();
        for (IImageStorageService service : imageStorageServices) {
            possiblePictures.addAll(service.getImages(imageRequest.getUtmZone(), imageRequest.getLatitudeBand(), imageRequest.getGridSquare()));
        }
        Image result = null;
        List<Image> latestImages = filterLatest(possiblePictures);
        if (!latestImages.isEmpty()) {
            // combine the pictures!
            return combine(latestImages);
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
        // i've found some examples on google but i don't fully understand all the given parameters right now
        // because of this i will just return the first image from the set
        return images.get(0);
    }
}
