package com.chatbot.application.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.chatbot.application.dto.ImageUploadRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Uploader {

    private final AmazonS3Client amazonS3Client;

    private static final String DIRECTORY_NAME = "static";

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String imageUpload(ImageUploadRequestDto dto) throws IOException, NoSuchAlgorithmException {
        File uploadFile = convert(dto.getImage()).orElseThrow(
                () -> new IllegalArgumentException("MultipartFile -> File 전환 실패")
        );

        return upload(uploadFile, dto.getRoomNumber());
    }

    private String upload(File uploadFile, int roomNumber) throws NoSuchAlgorithmException {
        String fileName = S3Uploader.DIRECTORY_NAME + "/" + roomNumber + "/" + hashingFile(uploadFile.getName());
        String uploadUrl = putS3(uploadFile, fileName);
        removeNewFile(uploadFile);
        return uploadUrl;
    }

    private String hashingFile(String fileName) throws NoSuchAlgorithmException {
        int pos = fileName.lastIndexOf(".");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String newFileName = fileName.substring(0, pos) + format.format(new Date());
        String extension = fileName.substring(pos);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        StringBuilder stringBuilder = new StringBuilder();

        messageDigest.update(newFileName.getBytes());
        for (byte dig : messageDigest.digest()) {
            stringBuilder.append(Integer.toString((dig & 0xff) + 0x100, 16).substring(1));
        }

        return stringBuilder.append(extension).toString();
    }

    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("파일이 삭제되었습니다.");
        } else {
            log.info("파일을 삭제하지 못했습니다.");
        }
    }

    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));

        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    private Optional<File> convert(MultipartFile file) throws IOException {
        File convertFile = new File(file.getOriginalFilename());

        if (convertFile.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }

            return Optional.of(convertFile);
        }

        return Optional.empty();
    }
}
