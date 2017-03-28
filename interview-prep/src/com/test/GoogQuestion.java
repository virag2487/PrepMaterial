package com.test;

public class GoogQuestion {

	//	Filename: MyFile.java
	//	match: MF
	//	match: yil
	//	no match: iM
	//	match: ava

	/*
	public boolean isNonContiguousMatch(String fileName, String pattern, int index) {

		boolean isMatch = false;
		if(StringUtils.isBlank(fileName) || StringUtils.isBlank(pattern)) {
			return isMatch;
		}

		if(index > pattern.length()) {
			return false;
		}

		int j = 0;
		if(patternMatcher.get(pattern) != null && patternMatcherMap.get(pattern).get(fileName) != null) {

			j = patternMatcherMap.get(pattern).get(fileName);
		}
		else {
			index = 0;
		}

		for(int i = j; i < fileName.length(); i++) {
			char ch = fileName.charAt(i);

			if(ch == pattern.charAt(index)) {
				index++;
			}

			if(index == pattern.length()) {
				isMatch = true;

				if(patternMatcherMap.containsKey(pattern) {
					patternMatcherMap.get(pattern).put(fileName, index);
				}
				else {
					Map<String, Integer> tempMap = new HashMap<String, Integer>();
					tempMap.put(fileName, i);
					patternMatcher.put(pattern, tempMap);
				}

				break;		
			}
		}

		return isMatch;
	}

	yi<pause>l<pause>
	1st call: yi
	2nd call: yil

	yi -> List<files>
	yil -> 

	Map<String, List<String>> map = new HashMap<String, List<String>>();
	Map<String, Map<String, Integer>> patternMatcherMap = new HashMap<String, HashMap<String, Integer>>();

	// utility method
	public List<String> getMatchedFilesForAPattern(String pattern) {
		return list;
	}

	public List<String> matchedFiles(String pattern) {
		List<String> matchedFiles = new ArrayList<String>();

		if(StringUtils.isBlank(pattern)) {
			return matchedFiles;
		}

		List<String> fileNames = getMatchedFilesForAPattern(pattern);

		if(fileNames == null) {
			fileNames = obj.getAllFilesInSystem();
		}

		for(String fileName : fileNames) {
			if(obj.isNonContiguousMatch(fileName, pattern)) {
				matchedFiles.add(fileName);
			}
		}

		map.put(pattern, matchedFiles);

		return matchedFiles;
	}

	 */
}
