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
}
