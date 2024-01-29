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

    public String toBase64(File file) throws Exception{
        Thumbnails.of(file)
                .size(400,400)
                .outputQuality(0.7)
                .toFile(file);
        try(FileInputStream image = new FileInputStream(file)){
            byte [] imageData = new byte[(int) file.length()];
            image.read(imageData);
            return Base64.getEncoder().encodeToString(imageData);
        }
    }

    public Photos upload(Long idAnnonce,File file) throws Exception {
        String bean = this.toBase64(file);
        Photos photos = new Photos();
        photos.setPath(bean);
        photos.setIdAnnonce(idAnnonce);
        System.out.println(photos.getPath());
        return this.photosRepository.save(photos);
    }





}
