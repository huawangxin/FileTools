package �ļ�ͳ�ƹ���;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 4�� ��д�����������Ҫ��
��һ���� ������� 20 ������(10���ڵ�)������һ��ArrayList�У� �õ������������ArrayList
�������� ��ɾ������Ϊ 5 ����
�������� �ٲ��� 3 �����������뵽λ�� 4 ��
���ģ��� ������ֵΪ 1 ��������� 10
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
