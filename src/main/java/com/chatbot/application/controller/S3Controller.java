package com.chatbot.application.controller;

import com.chatbot.application.aws.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final S3Uploader s3Uploader;

    @PostMapping("/api/image/upload")
    @ResponseBody
    public String uploadToS3(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        return s3Uploader.imageUpload(multipartFile, "static");
    }
}
