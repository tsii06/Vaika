package com.example.vaika.service;


import com.example.vaika.modele.Photos;
import com.example.vaika.repo.PhotosRepository;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;


@Service
public class PhotosService {

    private final PhotosRepository photosRepository;

    @Autowired
    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public String toBase64(String imagePath) throws Exception{
        File input = new File(imagePath);
        File output = new File(imagePath);
        Thumbnails.of(input)
                .size(400,400)
                .outputQuality(0.7)
                .toFile(output);
        try(FileInputStream image = new FileInputStream(output)){
            byte [] imageData = new byte[(int) output.length()];
            image.read(imageData);
            return Base64.getEncoder().encodeToString(imageData);
        }
    }

    public void upload(Photos photos) throws Exception {
        String bean = this.toBase64(photos.getPath());
        photos.setPath(bean);
        System.out.println(photos.getPath());
        this.photosRepository.save(photos);
    }





}
