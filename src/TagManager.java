package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import java.util.Map.Entry;

public class TagManager {
	
	 ArrayList<Folder> foldersList = new ArrayList<Folder>();
	 HashMap<String, Integer> specialTags = new HashMap<String, Integer>() {

		{
			put("A", 10);
			put("B", 20);
			put("C", 30);
			put("D", 40);
			put("E", 50);
			put("F", 60);
			put("G", 70);
		}
	};
	
	int number_of_folders = 100;
	
	void initializeApp() {
		System.out.println("how many folders you want to apply a tag on?");
		Scanner sc = new Scanner(System.in);
		int folders = sc.nextInt();

		if (folders <= number_of_folders) {

			System.out.println("folders the tag should be applied on: " + folders);
			System.out.println("Select a tag from the following: "+ "A,B,C,D,E,F,G");
			String selectedTag = sc.next();
			int availableTags = specialTags.get(selectedTag);
			System.out.println("available tags for the selected option: " + availableTags);

			if (availableTags >= folders) {
				applyTagsOnFolders(folders, availableTags, selectedTag);

			} else {
				System.out.println("not enough tags to perform this operation...Searching for next available tag");
				System.out.println("-----------------processing request-------------------");
				
				if (specialTags.get(selectedTag) == 0 || availableTags < folders) {
					int maxAvailableTags = Collections.max(specialTags.values());
					String keyOfHighest = "";
					for (Entry<String, Integer> entry : specialTags.entrySet()) {
						if (entry.getValue() == maxAvailableTags) {
							keyOfHighest = entry.getKey();
							System.out.println("next available tag: " + keyOfHighest);
							applyTagsOnFolders(folders, maxAvailableTags, keyOfHighest);
					 
						}	
					}
				}
			}
		} else {
			System.out.println("folder limit reached");
		}
	}
	
	void applyTagsOnFolders(int numOfFolders, int availableTags, String selectedTag) {
		System.out.println("-----------------applying tags now-------------------");
		for (int j = 1; j <= numOfFolders; j++) {
			int updateTagsValue = availableTags - numOfFolders;
			Folder folder = new Folder();
			UUID randomUid = UUID.randomUUID();

			folder.setFolderId(randomUid.toString());
			folder.setTagApplied(true);
			folder.setTagValue(selectedTag + j);

			foldersList.add(folder);
			specialTags.put(selectedTag, updateTagsValue);
		}
		System.out.println(specialTags);
		foldersList.forEach((element) -> {
			System.out.println(element.getTagValue());
		});

		System.out.println("remaining tags available after operation: " + specialTags.get(selectedTag));
	}

}
