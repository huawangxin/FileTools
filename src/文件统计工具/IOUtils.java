package 文件统计工具;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class IOUtils {
	private static void Copys(InputStream a){
		try {
			InputStreamReader isr=new InputStreamReader(a);
			FileOutputStream fos=new FileOutputStream("acopy.txt");
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			int d=-1;
			while((d=isr.read())!=-1){
				osw.write(d);
			}
			osw.close();
			System.out.println("文件复制完毕！谢谢使用");
		} catch (FileNotFoundException e) {
			System.out.println("输入的文件名不合法！");			
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("文件格式不正确！！！");			
			e.printStackTrace();
		}
	}
	private static void Creates(){
		try {
			FileOutputStream fos=new FileOutputStream("b.txt");
			System.out.println("文件创建成功，O(∩_∩)O谢谢使用");
		} catch (FileNotFoundException e) {
			System.out.println("文件创建失败！");
			e.printStackTrace();
		}
	}
	private static void Reads(RandomAccessFile a){
		while(true){
			try {
			Scanner scanner=new Scanner(System.in);
			a.seek(a.length());
			String ss=scanner.nextLine();
			a.write(ss.getBytes());
			System.out.println("文件写入完成");
			a.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件写入失败");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件写入失败");
			e.printStackTrace();
		}}
	}
	private static void Writes(FileInputStream a){
		try {
			byte[] buf=new byte[32];
			int len=a.read(buf);
			String str=new String(buf);
			System.out.println(str);
			a.close();
			System.out.println("文件正确读入");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void Translates(){
		Calendar c3=Calendar.getInstance();
		Date d3=c3.getTime();
		SimpleDateFormat s3=new SimpleDateFormat("yyyy-MM-dd");
		String str3=s3.format(d3);
		System.out.println("当前日期:"+str3);
	}
	private static void Deletes(File a){
		try {
			FileUtils.deleteDirectory(a);
			System.out.println("文件删除成功！");
		} catch (IOException e) {
			System.out.println("文件删除失败！");			
			e.printStackTrace();
		}
	}
	private static void Divides(){
		
	}
	public static void main(String[] args) {
		//1
//		try {
//			FileInputStream a;
//			a = new FileInputStream("a.txt");
//			new IOUtils().Copys(a);
//		} catch (FileNotFoundException e) {
//			System.out.println("文件格式错误");
//			e.printStackTrace();
//		}
		//2
//		new IOUtils().Creates();
		//3
//		try {
//			RandomAccessFile raf= new RandomAccessFile("c.txt", "rw");
//			new IOUtils().Reads(raf);
//		} catch (FileNotFoundException e) {
//			System.out.println("文件写入正确");
//			e.printStackTrace();
//		}
		//4
//		try {
//			FileInputStream fis=new FileInputStream(".txt");
//			new IOUtils().Writes(fis);
//		} catch (FileNotFoundException e) {
//			System.out.println("文本读取失败");			
//			e.printStackTrace();
//		}
		//5
//		new IOUtils().Translates();
		//6
//		File dir=new File("姚利宗");
//		new IOUtils().Deletes(dir);
		//7
		
		
		
	}
}
