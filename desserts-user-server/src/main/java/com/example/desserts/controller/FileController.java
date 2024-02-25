package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传接口
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResponseResult upload(@RequestPart("file") MultipartFile file) {
        String imgFileStr = fileService.upload(file);
        if (imgFileStr == null || "".equals(imgFileStr)) {
            return ResponseResult.errorResult(BusinessCode.FILE_UPLOAD_ERROR);
        } else {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("url", imgFileStr);
            return ResponseResult.okResult(dataMap);
        }
    }


}