package com.umc.site.domain.image.service;

import com.umc.site.domain.image.converter.ImageConverter;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.image.repository.ImageRepository;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.global.manager.AmazonS3Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageCommandServiceImpl implements ImageCommandService {

    private final AmazonS3Manager s3Manager;
    private final ImageRepository imageRepository;

    // 프로젝트 사진 생성
    @Override
    @Transactional
    public void createProjectImage(MultipartFile projectImage, Project project){

        String keyName = s3Manager.generateProjectKeyName();
        String fileUrl = s3Manager.uploadFile(keyName, projectImage);

        Image image = ImageConverter.toProjectImage(keyName, fileUrl);
        image.setProject(project);

        imageRepository.save(image);
    }
}
