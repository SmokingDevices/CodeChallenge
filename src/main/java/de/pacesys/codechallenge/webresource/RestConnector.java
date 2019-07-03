package de.pacesys.codechallenge.webresource;

import de.pacesys.codechallenge.api.GenerateImageRequest;
import de.pacesys.codechallenge.model.Image;
import de.pacesys.codechallenge.logic.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RestConnector {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/generate-image", method = RequestMethod.POST, consumes = "application/json", produces = "image/jpeg")
    public @ResponseBody byte[] generateImage(@RequestBody GenerateImageRequest imageRequest) {
        Image image = imageService.getImage(imageRequest);
        if (image != null) {
            return image.getImageContent();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cant find matching data for given parameter");
    }

}
