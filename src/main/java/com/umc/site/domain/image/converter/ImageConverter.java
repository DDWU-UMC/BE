package com.umc.site.domain.image.converter;

import com.umc.site.domain.image.dto.ImageResponseDTO;
import com.umc.site.domain.image.entity.Image;

public class ImageConverter {

    public static ImageResponseDTO.ImageDTO toImageDTO(Image image) {

        return ImageResponseDTO.ImageDTO.builder()
                .uuid(image.getUuid())
                .fileUrl(image.getFileUrl())
                .fileName(image.getFileName())
                .build();
    }

    // 프로젝트 사진 생성
    public static Image toProjectImage(String keyName, String fileUrl) {
        return Image.builder()
                .uuid(keyName.split("/")[1])
                .fileName(keyName)
                .fileUrl(fileUrl)
                .build();
    }
}
