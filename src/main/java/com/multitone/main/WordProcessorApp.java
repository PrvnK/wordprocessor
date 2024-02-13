package com.multitone.main;

import java.util.Scanner;

import com.multitone.service.WordProcessor;

/**
 * Main class for handling the word processor logic.
 * Process files provided in input and return response in required format.
 */
public class WordProcessorApp {
	public static void main(String[] args) {
		System.out.println("Application supports one or more file path. FilePaths are seperated by a comma");
		System.out.println("Enter the absolute path details:");
		// Reading the file path string with the help of Scanner.
		try (Scanner scanner = new Scanner(System.in)) {
			String filePaths = scanner.next();
			//Takes file paths string as input and prints words and their count in console.
			WordProcessor.processFiles(filePaths);
		} 
	}
}
