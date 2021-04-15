import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * @Auther: Maple
 * @Date: 2021/4/15
 */
public class downLoad {
    public static void main(String[] args) throws IOException {
        System.out.println("输入URL（下载链接）");
        Scanner scanner = new Scanner(System.in);
        String urlStr = scanner.next();
        URL url = new URL(urlStr);
        String path = urlStr.substring(urlStr.lastIndexOf('/')+1,urlStr.length());
        /* 字节流 */
        InputStream is = url.openStream();
        int len;
        byte[] bytes = new byte[8192];
        BufferedInputStream bis = new BufferedInputStream(is);
        long start = System.currentTimeMillis();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));

        while((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println(path+"已经下载完成");
        System.out.println("用时"+(end - start)/1000.0+"秒");
    }
}
