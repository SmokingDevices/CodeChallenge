package de.pacesys.codechallenge.logic.impl;

import de.pacesys.codechallenge.logic.IImageStorageService;
import de.pacesys.codechallenge.model.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileImageStorageService implements IImageStorageService {

    private final String filePath;

    public FileImageStorageService(@Value("${storage.file.path}") String filePath) {
        this.filePath = filePath;
        File f = new File(filePath);
        if (!f.isDirectory()) {
            throw new IllegalStateException("given configuration (storage.file.path) must point to a path!");
        }
    }

    @Override
    public List<Image> getImages(Integer utmZone, String latitudeBand, String gridSquare) {
        String fileNameBegin = "T"+utmZone + latitudeBand + gridSquare;
        List<Image> result = new ArrayList<>();
        File folder = new File(filePath);
        for (File file : folder.listFiles()) {
            // TODO: switch to regexp usage
            String[] fileNameParts = file.getName().split("_");
            if (fileNameParts.length == 3 && fileNameParts[0].equals(fileNameBegin)) {
                String[] bandAndExtension = fileNameParts[2].split("\\.");
                try {
                    Image i = new Image();
                    i.setName(file.getName());
                    i.setDate(fileNameParts[1]);
                    i.setSensorBand(bandAndExtension[0]);
                    i.setType(bandAndExtension[1]);
                    i.setImageContent(readFileContent(file));
                    result.add(i);
                } catch (IOException ioe){
                    // TODO: log the error
                    System.out.println("IOException while tryint to read from filePath:"+filePath+" message:"+ioe.getMessage());
                }
            }
        }
        return result;
    }

    private byte[] readFileContent (File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
}
