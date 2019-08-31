package com.lph.rsa.Utils;

import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 压缩或解压zip：
 * 由于直接使用java.util.zip工具包下的类，会出现中文乱码问题，所以使用org.apache.ant中的org.apache.tools.zip下的工具类
 */
public class ZipUtil {

    private static final Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    private static byte[] byteBuffer = new byte[1024] ;

    /**
     * 压缩文件或路径
     *
     * @param zip
     *          压缩的目的地址
     * @param srcFiles
     *          压缩的源文件
     */
    public static boolean zipFile(String zip , List<File> srcFiles){
        ZipOutputStream zipOut = null;
        try {
            if (zip.endsWith(".zip") || zip.endsWith(".ZIP")){
                zipOut = new ZipOutputStream(new FileOutputStream(new File(zip))) ;
                zipOut.setEncoding("GBK");
                for( File file : srcFiles){
                    handlerFile(zip, zipOut , file , "");
                }
                zipOut.close();
            }else{
                throw new RuntimeException("目标文件不是zip文件,无法压缩");
            }
        } catch (Exception e) {
            logger.error("压缩文件异常", e);
            throw new RuntimeException("压缩文件异常", e);
        } finally {
            IOUtils.closeQuietly(zipOut);
        }

        return true;
    }

    /**
     *
     * @param zip 压缩的目的地址
     * @param zipOut
     * @param srcFile  被压缩的文件信息
     * @param path  在zip中的相对路径
     * @throws IOException
     */
    private static void handlerFile(String zip , ZipOutputStream zipOut , File srcFile , String path) throws Exception{
        logger.info("compression file[" + srcFile.getName() + "], begin...");
        if( !"".equals(path) && ! path.endsWith(File.separator)){
            path += File.separator ;
        }
        if(!srcFile.getPath().equals(zip)) {
            if( srcFile.isDirectory()) {//目录
                File[] files = srcFile.listFiles() ;
                if( files.length == 0 ){
                    zipOut.putNextEntry(new ZipEntry(path + srcFile.getName() + File.separator));
                    zipOut.closeEntry();
                }else{
                    for( File file : files ){
                        handlerFile( zip ,zipOut , file , path + srcFile.getName());
                    }
                }
            } else {//文件
                InputStream in = null;
                try {
                    in = new FileInputStream(srcFile);
                    zipOut.putNextEntry(new ZipEntry(path + srcFile.getName()));
                    int len = 0;
                    while ((len = in.read(byteBuffer)) > 0) {
                        zipOut.write(byteBuffer, 0, len);
                    }
                    in.close();
                    zipOut.closeEntry();
                } catch (Exception e) {

                } finally {
                    IOUtils.closeQuietly(in);
                }
            }
        }

        logger.info("compression file[" + srcFile.getName() + "], end ...");
    }

    /**
     * 解压缩ZIP文件，将ZIP文件里的内容解压到targetDIR目录下
     *
     * @param zipPath 待解压缩的ZIP文件名
     * @param targetDir  目标目录
     */
    public static List<File> upzipFile(String zipPath, String targetDir) throws Exception {
        return upzipFile( new File(zipPath) , targetDir ) ;
    }

    /**
     * 对.zip文件进行解压缩
     * @param zipFile  解压缩文件
     * @param descDir  压缩的目标地址，如：D:\\测试 或 /mnt/d/测试
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List<File> upzipFile(File zipFile, String descDir) throws Exception {
        List<File> _list = new ArrayList<File>() ;
        try {
            ZipFile _zipFile = new ZipFile(zipFile , "GBK") ;
            for(Enumeration entries = _zipFile.getEntries(); entries.hasMoreElements() ; ){
                ZipEntry entry = (ZipEntry)entries.nextElement() ;
                File _file = new File(descDir + File.separator + entry.getName()) ;
                if( entry.isDirectory() ){
                    _file.mkdirs() ;
                }else{
                    File _parent = _file.getParentFile() ;
                    if( !_parent.exists() ){
                        _parent.mkdirs() ;
                    }
                    InputStream _in = null;
                    OutputStream _out = null;
                    try {
                        _in = _zipFile.getInputStream(entry);
                        _out = new FileOutputStream(_file);
                        int len = 0;
                        while ((len = _in.read(byteBuffer)) > 0) {
                            _out.write(byteBuffer, 0, len);
                        }
                        _in.close();
                        _out.flush();
                        _out.close();
                        _list.add(_file);
                    } catch (Exception e) {

                    } finally {
                        IOUtils.closeQuietly(_in);
                        IOUtils.closeQuietly(_out);
                    }
                }
            }
        } catch (IOException e) {
        }
        return _list ;
    }

    /**
     * 对临时生成的文件夹和文件夹下的文件进行删除
     */
    public static void deletefile(String delpath) {
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + File.separator + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + File.separator + filelist[i]);
                    }
                }
                file.delete();
                logger.info("delete file[" + delpath + "], success...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String zipPath = "D:/logs/facefeature-web.zip";

        List<File> files = new ArrayList<>();
        files.add(new File("D:/logs/facefeature-web"));
        zipFile(zipPath, files);

        deletefile("D:\\test");
    }
}
