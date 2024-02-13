package com.multitone.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.multitone.exception.WordProcessorException;
import com.multitone.util.WordProcessorUtil;

/**
 * This class contains stand alone methods which process file and perform some
 * operation on File data
 */

public class WordProcessor {

	// Java Util Logger
	public static Logger logger = Logger.getLogger(WordProcessor.class.getName());

	/**
	 * This method takes filenames string from input, splits them into array of File
	 * names and sends it over to countWords method for processing. Sorts the
	 * response from 'countWords' method and prints it to the console.
	 * 
	 * @param filePaths
	 */
	public static void processFiles(String filePaths) throws WordProcessorException {
		
		logger.log(Level.INFO, "Input fliepaths:" + filePaths);
		
		if(StringUtils.isNotBlank(filePaths)) {
			// String array containing one or more file path
			String[] filePathArray = filePaths.split(",");

			// Calling the core method that process files and performs word count
			Map<String, Integer> wordCountMap = WordProcessor.countWords(filePathArray);

			// Calling utility method to sort based on word count
			wordCountMap = WordProcessorUtil.sortByWordCount(wordCountMap);

			// Printing the output to the console
			wordCountMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
		} else {
			logger.log(Level.WARNING, "Validation error. Input file paths:" + filePaths + " is not valid.");
			throw new WordProcessorException("Input file path is not valid.");
		}
		
	}

	/**
	 * This method takes one or more file path in input, processes all the data of
	 * the files and returns a map with key=words, value=count
	 * 
	 * @param filePathArr
	 * @return
	 * @throws IOException
	 */

	private static Map<String, Integer> countWords(String[] filePathArr) throws WordProcessorException {

		logger.log(Level.INFO, "File paths after split:" + Arrays.toString(filePathArr));
		Map<String, Integer> wordCountMap = new HashMap<>();

		// Streaming file by file from input
		Arrays.stream(filePathArr).forEach(filePath -> {
			try {
				// Reading the lines from the file as a stream
				Files.lines(Path.of(filePath))
						// Processing each line and splitting words from them
						.flatMap(line -> Arrays.stream(line.split("\\s+")))
						// processing each word from the file
						.forEach(word -> {
							// trimming commonly used punctuation from the words
							String processedWord = word.replaceAll("[.,;]", "");
							if (wordCountMap.keySet().contains(processedWord)) {
								int existingCount = wordCountMap.get(processedWord);
								// add the word to the map
								wordCountMap.put(processedWord, existingCount + 1);
							} else {
								// updates(overrides) the existing word entry in the map
								wordCountMap.put(processedWord, 1);
							}
						});
			} catch (IOException e) {
				// Using Java util (internal logger) and it doesn't have ERROR, hence logging WARNING
				logger.log(Level.WARNING,
						"IOException occured while processing words from the file. Exception message: " + e);
				throw new WordProcessorException(
						"Exception occured while processing words from the file. Exception message: " + e.getMessage());
			}
		});
		return wordCountMap;
	}
}
