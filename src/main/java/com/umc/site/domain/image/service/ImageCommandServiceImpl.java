package com.umc.site.domain.image.service;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
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
    public void createProjectImage(MultipartFile file, Project project){

        String keyName = s3Manager.generateProjectKeyName();
        String fileUrl = s3Manager.uploadFile(keyName, file);

        Image image = ImageConverter.toImage(keyName, fileUrl);
        image.setProject(project);

        imageRepository.save(image);
    }

    // 프로젝트 사진 삭제
    @Override
    @Transactional
    public void deleteProjectImage(Project project){

        Image image = imageRepository.findByProject(project);

        s3Manager.deleteFile(image.getFileName());

        imageRepository.delete(image);
        imageRepository.flush();
    }

    // 운영진 사진 생성
    @Override
    @Transactional
    public void createClubAdminImage(MultipartFile file, ClubAdmin clubAdmin){

        String keyName = s3Manager.generateProjectKeyName();
        String fileUrl = s3Manager.uploadFile(keyName, file);

        Image image = ImageConverter.toImage(keyName, fileUrl);
        image.setClubAdmin(clubAdmin);

        imageRepository.save(image);
    }
}
