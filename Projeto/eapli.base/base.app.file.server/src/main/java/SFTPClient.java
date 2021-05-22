import com.jcraft.jsch.*;

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
    public void upload(String source,String filename) throws JSchException, SftpException {
        filename+=".";
        int i = source.lastIndexOf('.');
        if (i > 0) {
            filename += source.substring(i+1);
        }
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        try {
            sftpChannel.cd( "/var/www/html" );
        }
        catch ( SftpException e ) {
            sftpChannel.mkdir( "/var/www/html" );
            sftpChannel.cd( "/var/www/html" );
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
            sftpChannel.cd( "/var/www/html" );
        }
        catch ( SftpException e ) {
            sftpChannel.mkdir( "/var/www/html" );
            sftpChannel.cd( "/var/www/html" );
        }
        sftpChannel.get(source, destination);
        sftpChannel.exit();
        session.disconnect();
    }
}