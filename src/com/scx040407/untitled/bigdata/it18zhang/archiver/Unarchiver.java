package com.scx040407.untitled.bigdata.it18zhang.archiver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * �⵵����
 */
public class Unarchiver {
	public static void main(String[] args) throws Exception {
		
		List<FileBean> files = new ArrayList<FileBean>();
		//
		FileInputStream fis = new FileInputStream("d:/arch/x.xar");
		
		FileBean fileBean = null ;
		//
		while((fileBean = readNextFile(fis)) != null){
			files.add(fileBean);
		}
		//�ر���
		fis.close();
		
		FileOutputStream fos = null ;
		//
		for(FileBean fb : files){
			fos = new FileOutputStream("d:/arch/unarch/" + fb.getFileName());
			fos.write(fb.getFileContent());
			fos.close();
		}
	}
	
	/**
	 * �����ж�ȡ��һ���ļ�
	 */
	public static FileBean readNextFile(FileInputStream fis) throws Exception{
		//
		byte[] bytes4 = new byte[4];
		//��ȡ�ĸ��ֽ�
		int res = fis.read(bytes4);
		if(res == -1){
			return null ;
		}
		//�ļ�������
		int fnameLen = Util.bytes2Int(bytes4);
		
		//�ļ�������
		byte[] fileNameBytes = new byte[fnameLen];
		fis.read(fileNameBytes);
		
		//�õ��ļ���
		String fname = new String(fileNameBytes);
		
		//�ٶ�ȡ4���ֽڣ���Ϊ�ļ����ݵĳ���
		fis.read(bytes4);
		int fileContLen = Util.bytes2Int(bytes4);
		
		//��ȡ�ļ�����
		byte[] fileContBytes = new byte[fileContLen];
		fis.read(fileContBytes);
		return new FileBean(fname,fileContBytes);
	}
}
