package de.pacesys.codechallenge.logic.impl;

import de.pacesys.codechallenge.model.Image;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class FileImageStorageServiceTest {

    @Test
    public void testGetImagesWithValidFiles () {

        FileImageStorageService storageService = new FileImageStorageService(this.getClass().getResource("/storage").getPath());
        List<Image> images = storageService.getImages(44,"U", "UP");

        TestCase.assertNotNull(images);
        TestCase.assertEquals(2, images.size());
        // further checking the result --> skipped now for timeboxing reasons ....
    }

    @Test
    public void testGetImagesWithInValidFiles () {

        FileImageStorageService storageService = new FileImageStorageService(this.getClass().getResource("/storage").getPath());
        List<Image> images = storageService.getImages(45,"U", "UP");

        TestCase.assertNotNull(images);
        TestCase.assertEquals(0, images.size());
        // further checking the result --> skipped now for timeboxing reasons ....
    }

    @Test(expected = IllegalStateException.class)
    public void testGetImagesWithInValidPath () {

        FileImageStorageService storageService = new FileImageStorageService("/notExisting");

    }

}
