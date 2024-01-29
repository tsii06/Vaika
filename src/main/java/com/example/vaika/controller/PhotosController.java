package com.example.vaika.controller;

import com.example.vaika.modele.Modele;
import com.example.vaika.modele.Photos;
import com.example.vaika.modele.Utilisateur;
import com.example.vaika.repo.PhotosRepository;
import com.example.vaika.service.PhotosService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PhotosController {

    private final PhotosRepository photosRepository;
    private final PhotosService photosService;

    @Autowired
    public PhotosController(PhotosRepository photosRepository, PhotosService photosService) {
        this.photosRepository = photosRepository;
        this.photosService = photosService;
    }

    @GetMapping("/photos")
    public List<Photos> getAllPhotos() {
        return photosRepository.findAll();
    }

    @PostMapping("/upload")
    public Photos uploadPhoto(@RequestBody Photos photos) throws Exception {
        try {
            photosService.upload(photos);
            return photos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return photos;
    }
    @Transactional
    @GetMapping("/photos/{idAnnonce}")
    public List<Photos> getPhotoByIdAnnonce(@PathVariable(value = "idAnnonce") int annonceId) {
        return photosRepository.findByIdAnnonce(annonceId);
    }


}
