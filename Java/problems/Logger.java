package problems;

import java.util.HashMap;
import java.util.Map;

public class Logger {
	Map<String, Integer> map = new HashMap<String, Integer>();

	public boolean shouldPrintMessage(int timestamp, String message) {
		if (map.containsKey(message) && timestamp - map.get(message) < 10) {
			return false;
		}
		map.put(message, timestamp);
		return true;
	}

}