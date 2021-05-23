import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public class main {
    public static void main(String[] args) throws JSchException, SftpException {
        SFTPClient server = new SFTPClient();
        server.chooseFile();
        server.connect();
        server.upload("C:/Users/jpcg8/Desktop/ended.png","image");
    }
}
