package com.wx.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class SaltMD5 {
	public static String md5(String password,String salt) {
		//���ܷ�ʽ
		String hashAlgorithmName = "MD5";
		//�Σ���ʹ����ͬ�����룬�Ӳ�ͬ���κ�Ҳ�����ɲ�ͬ����
		ByteSource byteSalt = ByteSource.Util.bytes(salt);//����ط�����ֵֻ����String���͵Ĳ��ܽ���ת��
		//����
		Object source = password;
		//���ܴ���
		int hashIteration = 1024;
		SimpleHash result = new SimpleHash(hashAlgorithmName,source,byteSalt,hashIteration);
		return result.toString();
		
	}
	
	
	
	  public static void main(String[] args) {  String a =SaltMD5.md5("123",
	  "0.4763713365172716"); System.out.println(a); }
	 
	 
	 
	
	/*
	 * public static void main(String[] args) { Double a = Math.random();
	 * 
	 * System.out.println(Double.toString(a)); }
	 */

}
