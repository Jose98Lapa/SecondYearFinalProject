import com.jcraft.jsch.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.ImageFilter;
import java.io.File;

public class SFTPClient {

    private String host = "10.9.21.17";
    private int port = 22;
    private Session session = null;

    public SFTPClient() {

    }

    public void connect() throws JSchException {
        JSch jsch = new JSch();

        session = jsch.getSession("root", host, port);
        session.setPassword("123Tiago123");

        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
    }

    public void upload(String source, String filename) throws JSchException, SftpException {
        filename += ".";
        int i = source.lastIndexOf('.');
        if (i > 0) {
            filename += source.substring(i + 1);
        }
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        try {
            sftpChannel.cd("/var/www/html");
        } catch (SftpException e) {
            sftpChannel.mkdir("/var/www/html");
            sftpChannel.cd("/var/www/html");
        }
        sftpChannel.put(source, filename);
        sftpChannel.exit();
        session.disconnect();
    }

    public void download(String source, String destination) throws JSchException, SftpException {
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        try {
            sftpChannel.cd("/var/www/html");
        } catch (SftpException e) {
            sftpChannel.mkdir("/var/www/html");
            sftpChannel.cd("/var/www/html");
        }
        sftpChannel.get(source, destination);
        sftpChannel.exit();
        session.disconnect();
    }

    public String chooser(String type) {
        JFileChooser chooser = new JFileChooser();
        switch (type) {
            case "image": {
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg"));
                chooser.setAcceptAllFileFilterUsed(false);
            }
            case "file": {
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "png"));
                chooser.setAcceptAllFileFilterUsed(false);
            }
            case "script": {
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Iage Files", "jpg", "png"));
                chooser.setAcceptAllFileFilterUsed(false);
            }
        }
        int result = chooser.showDialog(null, "Select File");
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
    }

    public String castLink(String filename) {
        return "http://"+host+"/"+filename+".jpg";
    }

    public String choseAndUploadImage(String filename) {
        try {
            this.connect();
            String path = this.chooser("image");
            if (path != null) {
                this.upload(path, filename);
            }
            return this.castLink(filename);
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
            return null;
        }
    }
}