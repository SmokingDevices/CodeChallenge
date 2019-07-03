package de.pacesys.codechallenge.logic;

import de.pacesys.codechallenge.model.Image;

import java.util.List;

/**
 * i've introduced this interface because i think that there are more than one possible source for these pictures.
 */
public interface IImageStorageService {

    /**
     * returns only the latest files matching the given parameters from a specific storage
     * @param utmZone the utmZone
     * @param latitudeBand the latitudeBand
     * @param gridSquare the gridSquare
     * @param date the date
     * @return a list of @Image matching the given parameter
     */
    List<Image> getImages(Integer utmZone, String latitudeBand, String gridSquare, String date);
}
