package com.trojan.constant;

import java.util.ArrayList;
import java.util.List;

public class FileTypeConstant {
	public static List<String> picList = null;
	public static List<String> movieList = null;
	public static List<String> docList = null;
	public static List<String> musicList = null;
	public static List<String> zipList = null;

	public static final int PIC = 1;
	public static final int MOVIE = 2;
	public static final int DOC = 3;
	public static final int MUSIC = 4;
	public static final int ZIP = 5;
	public static final int OTHER = 6;
	static {

		picList = new ArrayList<String>();
		picList.add(".GIF");
		picList.add(".PNG");
		picList.add(".JPG");
		picList.add(".JPEG");
		picList.add(".BMP");
		picList.add(".TIF");
		picList.add(".PIC");

		movieList = new ArrayList<String>();
		movieList.add(".WMV");
		movieList.add(".ASF");
		movieList.add(".ASX");
		movieList.add(".RM");
		movieList.add(".RMVB");
		movieList.add(".MP4");
		movieList.add(".3GP");
		movieList.add(".MOV");
		movieList.add(".M4V");
		movieList.add(".AVI");
		movieList.add(".FLV");
		movieList.add(".VOB");
		movieList.add(".MPG");

		docList = new ArrayList<String>();
		docList.add(".TXT");
		docList.add(".PDF");
		docList.add(".DOC");
		docList.add(".XLS");
		docList.add(".XLSX");
		docList.add(".CSV");
		docList.add(".DOCX");
		docList.add(".PPT");
		docList.add(".PPTX");

		musicList = new ArrayList<String>();
		musicList.add(".WAV");
		musicList.add(".AIF");
		musicList.add(".AU");
		musicList.add(".MP3");
		musicList.add(".RAM");
		musicList.add(".WMA");
		musicList.add(".MMF");
		musicList.add(".AMR");
		musicList.add(".AAC");
		musicList.add(".FLAC");

		zipList = new ArrayList<String>();
		zipList.add(".RAR");
		zipList.add(".ZIP");
		zipList.add(".ARJ");
		zipList.add(".GZ");
		zipList.add(".Z");
	}

	public static int getFileType(String suffix) {
		suffix = suffix.toUpperCase();
		if (picList.contains(suffix)) {
			return PIC;
		} else if (movieList.contains(suffix)) {
			return MOVIE;
		} else if (docList.contains(suffix)) {
			return DOC;
		} else if (musicList.contains(suffix)) {
			return MUSIC;
		} else if (zipList.contains(suffix)) {
			return ZIP;
		} else {
			return OTHER;
		}
	}
}
