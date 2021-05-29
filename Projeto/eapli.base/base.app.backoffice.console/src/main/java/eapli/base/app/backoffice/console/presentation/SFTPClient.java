package eapli.base.app.backoffice.console.presentation;

import com.jcraft.jsch.*;
import eapli.base.Application;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class SFTPClient {

    private String localServerFolder = "/var/www/html";
    private int port = 22;
    private Session session = null;

    public SFTPClient() {

    }

    public void connect() throws JSchException {
        JSch jsch = new JSch();

        session = jsch.getSession(Application.settings().getSshUser(), Application.settings().getImageServerIp(), port);
        session.setPassword(Application.settings().getSshPassword());

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
            sftpChannel.cd(localServerFolder);
        } catch (SftpException e) {
            sftpChannel.mkdir(localServerFolder);
            sftpChannel.cd(localServerFolder);
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
            sftpChannel.cd(localServerFolder);
        } catch (SftpException e) {
            sftpChannel.mkdir(localServerFolder);
            sftpChannel.cd(localServerFolder);
        }
        sftpChannel.get(source, destination);
        sftpChannel.exit();
        session.disconnect();
    }

    public String chooser(String type) {

        JFileChooser chooser = new JFileChooser();

        // swing on mac has some quirks
        JDialog dialog = new JDialog();

        switch (type) {
            case "image": {
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files - .JPG", "jpg"));
                chooser.setAcceptAllFileFilterUsed(false);
                break;
            }
            case "file": {
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "png"));
                chooser.setAcceptAllFileFilterUsed(false);
                break;
            }
            case "script": {
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Script", "txt"));
                chooser.setAcceptAllFileFilterUsed(false);
                break;
            }
            default:{
                System.err.println("Invalid file type");
                System.exit(0);
                break;
            }
        }
        int result = chooser.showOpenDialog( dialog );
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
    }

    public String castLinkImage(String filename) {
        return "http://"+Application.settings().getImageServerIp()+"/"+filename+".jpg";
    }

    public String castLinkScript(String filename) {
        return "http://"+Application.settings().getImageServerIp()+"/"+filename+".txt";
    }

    public String choseAndUploadImage(String filename) {
        try {
            this.connect();
            String path = this.chooser("image");
            if (path != null) {
                this.upload(path, filename);
                return this.castLinkImage(filename);
            }
            return null;
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String choseAndUploadScript(String filename) {
        try {
            this.connect();
            String path = this.chooser("script");
            if (path != null) {
                this.upload(path, filename);
                return this.castLinkScript(filename);
            }
            return null;
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
            return null;
        }
    }
}