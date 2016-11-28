package 文件统计工具;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class charCount implements Comparable {
	  public int count=0;
	  public String charN = null;
	  public int compareTo(Object o) {
	    if(o instanceof charCount) {
	      charCount charN2 = (charCount)o;
	      return charN2.count - this.count;
	    }
	    return -1;
	  }
	  
	}

	public class test1 {
	  public static void main(String[] args) {
	    HashMap hm = new HashMap();
	    String aaa = "Welcome to our company Software Engineer Recruitment Examination";
	    for(int i=0; i<aaa.length(); i++) {
	      String charN = String.valueOf(aaa.charAt(i));
	      if(hm.containsKey(charN)) {
	        charCount charC = (charCount)hm.get(charN);
	        charC.count = charC.count + 1;
	      } else {
	        charCount charC = new charCount();
	        charC.charN = charN;
	        charC.count = 1;
	        hm.put(charN, charC);
	      }
	    }
	    Object[] c = hm.values().toArray();
	    Arrays.sort(c);
	    System.out.print(((charCount)c[0]).charN+":"+((charCount)c[0]).count);
	  }
	}