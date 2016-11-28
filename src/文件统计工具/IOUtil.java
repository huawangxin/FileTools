package 文件统计工具;


import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.text.DateFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat; 
  
  
public class IOUtil{  
      
    /** 
     * 备份文件 
     *  @param in 
     *  @param out 
     *调用：Utils.CopyFile(new File("C:\\xx.sql"), new File("C:\\copy.sql")); 
     */  
    public static  void   CopyFile(File   in,   File   out)   throws   Exception   {   
        FileInputStream   fis     =   new   FileInputStream(in);   
        FileOutputStream   fos   =   new   FileOutputStream(out);   
        byte[]   buf   =   new   byte[1024];   
        int   i   =   0;   
        while((i=fis.read(buf))!=-1)   {   
            fos.write(buf,   0,   i);   
            }   
        fis.close();   
        fos.close();   
        }   
      
      
    /** 
     * 创建文件 
     * @param filePath:文件路径 
     * @param directoryPath：文件所在文件夹路径 
     * 调用：Utils.createFile("D:\\data\\Putaway_Tasks.dat", "D:\\data"); 
     */  
    public static File createFile(String filePath, String directoryPath) {  
        File file = new File(directoryPath);  
        if (!file.exists()) {  
            System.out.println(directoryPath + "目录不存在，创建该目录");  
            file.mkdir();// 创建目录  
        }  
        file = new File(filePath);  
          
        if(file.exists()){  
            file.delete();  
        }  
        if (!file.exists()) {  
            try {  
                if (file.createNewFile())  
                    System.out.println(directoryPath + "该文件成功创建");  
            } catch (IOException e) {  
            }  
        }  
        return file;  
    }  
  
    /** 
     * 文件内容写入 
     *  
     * @param aFile 
     * @param aContents 
     * @throws FileNotFoundException 
     * @throws IOException 
     */  
    public static void setContents(File aFile, String aContents)  
            throws FileNotFoundException, IOException {  
        if (aFile == null) {  
            throw new IllegalArgumentException("File should not be null.");  
        }  
        if (!aFile.exists()) {  
            throw new FileNotFoundException("File does not exist: " + aFile);  
        }  
        if (!aFile.isFile()) {  
            throw new IllegalArgumentException("Should not be a directory: "  
                    + aFile);  
        }  
        if (!aFile.canWrite()) {  
            throw new IllegalArgumentException("File cannot be written: "  
                    + aFile);  
        }  
        try {  
            OutputStreamWriter writer = new OutputStreamWriter(  
                    new FileOutputStream(aFile, true), "UTF-8");  
            BufferedWriter fbw = new BufferedWriter(writer);  
            fbw.write(aContents);  
            fbw.newLine();  
            fbw.close();  
        } catch (Exception e) {  
            System.out.println("Error: " + e.getMessage());  
        }  
    }  
  
    /** 
     * 读取文件内容 
     *  
     * @param fileName 
     * @return 
     */  
    public static BufferedReader readFile(String fileName) {  
        BufferedReader br;  
        try {  
            br = new BufferedReader(new FileReader(fileName));  
            return br;  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    /** 
     * 字符串转日期类型 
     *  
     * @param strDate 
     * @return java.sql.Date 
     */  
    public static java.sql.Date stringConvertDate(String strDate) {  
        java.util.Date today = new java.util.Date();  
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        try {  
            today = formatter.parse(strDate);  
        } catch (ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        long t = today.getTime();  
        java.sql.Date sqlDate = new java.sql.Date(t);  
        return sqlDate;  
    }  
    /**
     * 文件删除 
     * @param file
     */
    public static void delete(File file){
		File[] fs = file.listFiles();
		if(fs.length==0){
			file.delete();
		}else{
			for(int i=0;i<fs.length;i++){
				if(!fs[i].isDirectory()){//文件是否是目录
					fs[i].delete();
					
				}else{
					delete(fs[i]);
				}
			}
		}
	}
    /**
     * 文件分割成几份
     * @param file=文件名
     * @param i=要分割几份
     */
    public static void copy(File file,int i){
    	try {
			FileInputStream in = new FileInputStream(file);
			System.out.println(file.getName());
			String[] str = (file.getName()).split("\\.");//将文件名割后缀名切割开
			int n =0;
			if((int)file.length()%i!=0){//
				n = (int)file.length()/(i-1);
			}else{
				n =(int)file.length()/i;
			}
			byte[] buf = new byte[n];//分配每份文件所占的大小
			int count=1;
			
			while(in.read(buf)!=-1){
				new FileOutputStream(new File(str[0]+count+"."+str[1])).write(buf);//输出每份分割的文件
				count++;
			}
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}  