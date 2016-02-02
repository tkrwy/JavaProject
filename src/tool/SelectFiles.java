package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

public class SelectFiles {
	public static void main(String[] args){
		readTxtFile("E:/网站开发/资源/database/drug_pic.csv");
	}
	public static void readTxtFile(String filePath){
		String encoding = "UTF-8";
		File file = new File(filePath);
		if(file.isFile() && file.exists()){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),encoding));
				String lineTxt = null;
				while((lineTxt = br.readLine()) != null){
					System.out.println(lineTxt);
					File s = new File("E:/网站开发/资源/img/常用药品保健品查询图/" + lineTxt);
					File t = new File("E:/网站开发/资源/img/有效药品图片/" + lineTxt);
					fileChannelCopy(s,t);
				}
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void fileChannelCopy(File s, File t) {

        FileInputStream fi = null;

        FileOutputStream fo = null;

        FileChannel in = null;

        FileChannel out = null;

        try {

            fi = new FileInputStream(s);

            fo = new FileOutputStream(t);

            in = fi.getChannel();//得到对应的文件通道

            out = fo.getChannel();//得到对应的文件通道

            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                fi.close();

                in.close();

                fo.close();

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }
}
