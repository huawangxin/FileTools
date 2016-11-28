package 文件统计工具;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 4、 编写程序完成下列要求：
（一）、 随机产生 20 个整数(10以内的)，放入一个ArrayList中， 用迭代器遍历这个ArrayList
（二）、 并删除其中为 5 的数
（三）、 再产生 3 个整数，插入到位置 4 处
（四）、 把所有值为 1 的数都变成 10
 * @author wangxin
 *
 */
public class test4 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		Random random=new Random();
		
		for(int i=0;i<20;i++){
			int a=random.nextInt(10);
			list.add(a);
		}
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()){
			int b=it.next();
			if(b==5){
				it.remove();
			}
		}
		for(int i=0;i<3;i++){
				int a=random.nextInt(10);
				list.add(4, a);
				
		}System.out.println(list);
		System.out.println(it);
		while(it.hasNext()){
			for(int i: list){
			 System.out.print(i);
			}
		}
	}
	
}
