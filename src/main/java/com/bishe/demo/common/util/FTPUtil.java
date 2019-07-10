package com.bishe.demo.common.util;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FTPUtil {

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");

    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");

    private static String ftpPwd = PropertiesUtil.getProperty("ftp.pwd");

    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp, 21, ftpUser, ftpPwd);
        System.out.println("开始连接服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        System.out.println("结束上传");
        return result;
     }

    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = false;
        FileInputStream fis = null;
        // 连接FTP服务器

        if (connectServer(this.getIp(), this.port, this.user, this.pwd)) {
            try {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);          // 缓冲区
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();     // 本地被动模式 ??? 
                for (File fileItem : fileList) {
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(), fis);
                }
                uploaded = true;
            } catch (IOException e) {
                System.out.println("上传文件异常");
                e.printStackTrace();
            }finally {
                fis.close();
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }

    private boolean connectServer(String ip, int port, String user, String pwd) {

        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, pwd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }


    private String ip;
    private int port;
    private String user;
    private String pwd;
    private FTPClient ftpClient;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}
