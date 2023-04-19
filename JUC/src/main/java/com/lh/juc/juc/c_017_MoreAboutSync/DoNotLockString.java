/**
 * ��Ҫ���ַ���������Ϊ��������
 * ������������У�m1��m2��ʵ��������ͬһ������
 * ����������ᷢ���ȽϹ�������󣬱������õ���һ����⣬�ڸ�����д����������ַ�����Hello����
 * �����������Դ�룬���������Լ��Ĵ�����Ҳ������"Hello",��ʱ����п��ܷ����ǳ����������������
 * ��Ϊ��ĳ�������õ�����ⲻ�����ʹ����ͬһ����
 * 
 * @author lh
 */
package com.lh.juc.juc.c_017_MoreAboutSync;

/**
 * The type Do not lock string.
 */
public class DoNotLockString {

	/**
	 * The S 1.
	 */
	String s1 = "Hello";
	/**
	 * The S 2.
	 */
	String s2 = "Hello";

	/**
	 * M 1.
	 */
	void m1() {
		synchronized(s1) {

		}
	}

	/**
	 * M 2.
	 */
	void m2() {
		synchronized(s2) {

		}
	}


}
