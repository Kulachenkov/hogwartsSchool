package com.example.hogwartsschool.service.impl;

import com.example.hogwartsschool.model.Avatar;
import com.example.hogwartsschool.model.Student;
import com.example.hogwartsschool.repository.AvatarRepository;
import com.example.hogwartsschool.repository.StudentRepository;
import com.example.hogwartsschool.service.AvatarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AvatarServiceImpl implements AvatarService {

    @Value("/avatars")
    private String avatarsDir;

    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;

    public AvatarServiceImpl(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    @Override
    public void uploadAvatar(Long studentId, MultipartFile avatar) throws IOException {

        Student student = studentRepository.getById(studentId);
        Path filePath = Path.of(avatarsDir, student.getId() + "." + getExtensions(avatar.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = avatar.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
        ) {
            is.transferTo(os);
        }
        Avatar newAvatar = findAvatar(studentId);
        newAvatar.setStudent(student);
        newAvatar.setFilePath(filePath.toString());
        newAvatar.setFileSize(avatar.getSize());
        newAvatar.setMediaType(avatar.getContentType());
        newAvatar.setData(avatar.getBytes());
        avatarRepository.save(newAvatar);
    }

    public Avatar findAvatar(Long id) {
        return avatarRepository.findByStudentId(id).orElse(new Avatar());
    }


    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
