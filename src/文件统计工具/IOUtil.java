package �ļ�ͳ�ƹ���;


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
     * �����ļ� 
     *  @param in 
     *  @param out 
     *���ã�Utils.CopyFile(new File("C:\\xx.sql"), new File("C:\\copy.sql")); 
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
     * �����ļ� 
     * @param filePath:�ļ�·�� 
     * @param directoryPath���ļ������ļ���·�� 
     * ���ã�Utils.createFile("D:\\data\\Putaway_Tasks.dat", "D:\\data"); 
     */  
    public static File createFile(String filePath, String directoryPath) {  
        File file = new File(directoryPath);  
        if (!file.exists()) {  
            System.out.println(directoryPath + "Ŀ¼�����ڣ�������Ŀ¼");  
            file.mkdir();// ����Ŀ¼  
        }  
        file = new File(filePath);  
          
        if(file.exists()){  
            file.delete();  
        }  
        if (!file.exists()) {  
            try {  
                if (file.createNewFile())  
                    System.out.println(directoryPath + "���ļ��ɹ�����");  
            } catch (IOException e) {  
            }  
        }  
        return file;  
    }  
  
    /** 
     * �ļ�����д�� 
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
     * ��ȡ�ļ����� 
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
     * �ַ���ת�������� 
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
     * �ļ�ɾ�� 
     * @param file
     */
    public static void delete(File file){
		File[] fs = file.listFiles();
		if(fs.length==0){
			file.delete();
		}else{
			for(int i=0;i<fs.length;i++){
				if(!fs[i].isDirectory()){//�ļ��Ƿ���Ŀ¼
					fs[i].delete();
					
				}else{
					delete(fs[i]);
				}
			}
		}
	}
    /**
     * �ļ��ָ�ɼ���
     * @param file=�ļ���
     * @param i=Ҫ�ָ��
     */
    public static void copy(File file,int i){
    	try {
			FileInputStream in = new FileInputStream(file);
			System.out.println(file.getName());
			String[] str = (file.getName()).split("\\.");//���ļ������׺���и
			int n =0;
			if((int)file.length()%i!=0){//
				n = (int)file.length()/(i-1);
			}else{
				n =(int)file.length()/i;
			}
			byte[] buf = new byte[n];//����ÿ���ļ���ռ�Ĵ�С
			int count=1;
			
			while(in.read(buf)!=-1){
				new FileOutputStream(new File(str[0]+count+"."+str[1])).write(buf);//���ÿ�ݷָ���ļ�
				count++;
			}
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}  