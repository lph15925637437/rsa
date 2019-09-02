package com.lph.rsa.controller;

import com.lph.rsa.Utils.ZipUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zip")
public class ZipController {

    public static final Logger log = LoggerFactory.getLogger(ZipController.class);

    public static final String ZIPFILENAME = "facefeature-web.zip";

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response){
        List<String> files = new ArrayList<>();
        files.add("D:/logs/facefeature-web.log");
        ZipUtil.downloadZipFiles(ZIPFILENAME, response, files);
    }
}

