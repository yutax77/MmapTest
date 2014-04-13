package com.yutax77;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class DiscardReader {
	private final Path path;
	
	public DiscardReader(Path path){
		this.path = path;
	}
	
	public void discard() throws IOException{
		try(SeekableByteChannel channel = Files.newByteChannel(path)){
			MappedByteBuffer mmap = ((FileChannel)channel).map(MapMode.READ_ONLY, 0, channel.size());
			while(true){
				try{
					mmap.get();
				}catch(BufferUnderflowException e){
					//すべて読んだ
					break;
				}
			}
		}
	}
}
