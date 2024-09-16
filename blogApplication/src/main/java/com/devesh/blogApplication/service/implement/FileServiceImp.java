package com.devesh.blogApplication.service.implement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devesh.blogApplication.service.FileService;

@Service
public class FileServiceImp implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImp.class);

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();

        // Validate file extension
        String fileExtension = name.substring(name.lastIndexOf(".")).toLowerCase();
        if (!fileExtension.equals(".jpg") && !fileExtension.equals(".png") && !fileExtension.equals(".jpeg")) {
            throw new IOException("Only JPG, PNG, and JPEG files are allowed");
        }

        // Generate random unique file name
        String randomID = UUID.randomUUID().toString();
        String fileName = randomID.concat(fileExtension);
        
        // Prepare directory and file path
        String filePath = path + File.separator + fileName;
        File directory = new File(path);
        if (!directory.exists()) directory.mkdirs(); // Create directory if not exists

        // Copy file to the destination
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(filePath));
        } catch (IOException e) {
            // Handle exception
        	 logger.error("Error uploading file: " + name, e);
             throw new IOException("File upload failed. Please try again.");
        }


        return fileName; // Return the correct file name
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        return new FileInputStream(file);
    }
}
