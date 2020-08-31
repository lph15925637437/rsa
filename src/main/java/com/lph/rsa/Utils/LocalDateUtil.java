package com.lph.rsa.Utils;


import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.time.*;
import java.time.temporal.ChronoField;

/**
 * 时间处理工具类
 * @author: lph
 * @date:  2019/10/30 15:06
 * @version V1.0
 */
public class LocalDateUtil {

    public static final String ZIP_FILE = "D:\\image";
    public static final String JPG_FILE = "D:\\image\\web.jpg";

    public static final Logger logger = LoggerFactory.getLogger(LocalDateUtil.class);

    SoftReference<Integer> softReference = new SoftReference<Integer>(1);

    public static void main(String[] args){
        zipFileNoBuffer();
    }

    public static void zipFileNoBuffer() {
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            //开始时间
            long beginTime = System.currentTimeMillis();

            for (int i = 0; i < 10; i++) {
                try (InputStream input = new FileInputStream(JPG_FILE)) {
                    zipOut.putNextEntry(new ZipEntry("web" + i));
                    int temp = 0;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                }
            }
            System.err.println("花费时间:" +beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
