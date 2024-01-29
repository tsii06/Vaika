package com.example.vaika.controller;

import com.example.vaika.modele.Modele;
import com.example.vaika.modele.Photos;
import com.example.vaika.modele.Utilisateur;
import com.example.vaika.repo.PhotosRepository;
import com.example.vaika.service.PhotosService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
    public Photos uploadPhoto(@RequestParam("idAnnonce") Long idAnnonce, @RequestPart("file")MultipartFile file) throws Exception {
        try {
            Path tempPath = Files.createTempFile("temp","jpg");
            Files.copy(file.getInputStream(),tempPath, StandardCopyOption.REPLACE_EXISTING);
            String absolutePath = tempPath.toAbsolutePath().toString();
            File uploadPhoto = new File(absolutePath);
            return photosService.upload(idAnnonce,uploadPhoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Photos();
    }
    @Transactional
    @GetMapping("/photos/{idAnnonce}")
    public List<Photos> getPhotoByIdAnnonce(@PathVariable(value = "idAnnonce") int annonceId) {
        return photosRepository.findByIdAnnonce(annonceId);
    }


}
