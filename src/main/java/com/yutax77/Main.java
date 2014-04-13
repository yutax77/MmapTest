package com.yutax77;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {
		//フォルダを指定して、当該フォルダ配下の全ファイルの内容をMMAPで読み捨てる。
		String path = args[0];
		Files.walkFileTree(Paths.get(path), new ReadFileVisitor());
	}

}
