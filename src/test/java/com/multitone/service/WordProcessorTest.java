package com.multitone.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.multitone.exception.WordProcessorException;
/**
 *  This Junit test class illustrates some sample test cases that could be possible for this utility.
 *  They follow JUnit test case format, but they are not proper JUnit testcases, mocking has not been used.
 *  
 */
@ExtendWith(MockitoExtension.class)
public class WordProcessorTest {

	File directory = new File("./");
	String absolutePath = directory.getAbsolutePath();

	@Test
	public void processFile_singleValidFile_printsResponseToConsole() {
		String singleFilePath = absolutePath.substring(0, absolutePath.length() - 1)
				+ "src\\test\\resources\\Input.txt";
		WordProcessor.processFiles(singleFilePath);
	}

	@Test
	public void processFile_multipleValidFile_printsResponseToConsole() {
		String singleFilePath = absolutePath.substring(0, absolutePath.length() - 1)
				+ "src\\test\\resources\\Input.txt";
		String multipleFiles = new StringBuilder(singleFilePath)
				.append(",")
				.append(absolutePath.substring(0, absolutePath.length() - 1))
				.append("src\\test\\resources\\Input2.txt").toString();
		WordProcessor.processFiles(multipleFiles);
	}
	
	@Test
	public void processFile_invalidFileName_throwsWordProcessorException() {
		String invalidFileName = absolutePath.substring(0, absolutePath.length() - 1)
				+ "src\\test\\resources\\Inputx.txt";
		assertThrows(WordProcessorException.class, () -> WordProcessor.processFiles(invalidFileName));
	}
	
	@Test
	public void processFile_inputFliePathNull_throwsWordProcessorException() {
		assertThrows(WordProcessorException.class, () -> WordProcessor.processFiles(null));
	}
	
	@Test
	public void processFile_inputFliePathEmpty_throwsWordProcessorException() {
		assertThrows(WordProcessorException.class, () -> WordProcessor.processFiles(""));
	}
	
	@Test
	public void processFile_inputFliePathBlank_throwsWordProcessorException() {
		assertThrows(WordProcessorException.class, () -> WordProcessor.processFiles(" "));
	}
}
