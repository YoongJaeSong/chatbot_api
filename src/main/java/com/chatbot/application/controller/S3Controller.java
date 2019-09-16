package com.chatbot.application.controller;

import com.chatbot.application.aws.S3Uploader;
import com.chatbot.application.dto.ImageUploadRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final S3Uploader s3Uploader;

    @PostMapping(value = "/api/image/upload")
    public String uploadToS3(@ModelAttribute ImageUploadRequestDto dto) throws IOException {
        return s3Uploader.imageUpload(dto);
    }
}
