//Treemap testing

import java.io.*;
import java.util.TreeMap;
import java.util.Map;
import java.lang.Comparable;

public class TreeMapSort {

	public TreeMapSort(TreeMap<String, Integer> map) {
		System.out.println("Before Sort\n----------");
		printMap(map);
		System.out.println("----------");

		MapObject firstEntry = new MapObject(map.firstEntry());
		MapObject lastEntry = new MapObject(map.lastEntry());

		System.out.println("\n(" + firstEntry.key + " => " + firstEntry.val + ")");
		System.out.println("\n(" + lastEntry.key + " => " + lastEntry.val + ")");

		System.out.println(firstEntry.compareTo(lastEntry));
		System.out.println(lastEntry.compareTo(firstEntry));


	}

	private class MapObject implements Comparable<Integer> {

			String key;
			Integer val;

			public MapObject(Map.Entry<String, Integer> entry) {
				this.key = entry.getKey();
				this.val = entry.getValue();
			}

			//Wrapper
			public int compareTo(MapObject entry) {
				return compareTo(entry.val);
			}

			@Override
			public int compareTo(Integer entryValue) {
				return this.val.compareTo(entryValue);
			}

	}

	public void printMap(TreeMap<String, Integer> map) {
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("\n(" + entry.getKey() + " => " + entry.getValue() + ")");
		}
	}


	public static void main(String[] args) {

		TreeMap<String, Integer> countOccurrences = new TreeMap<String, Integer>();

		countOccurrences.put("A", 2);
		countOccurrences.put("B", 1);
		countOccurrences.put("Z", 12);
		countOccurrences.put("F", 23);
		countOccurrences.put("D", 7);
		countOccurrences.put("E", 100);

		new TreeMapSort(countOccurrences);
	}


}