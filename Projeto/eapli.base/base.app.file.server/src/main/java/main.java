import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public class main {
    public static void main(String[] args) throws JSchException, SftpException {
        SFTPClient server = new SFTPClient();
        System.out.println(server.choseAndUploadImage("image2"));
    }
}
