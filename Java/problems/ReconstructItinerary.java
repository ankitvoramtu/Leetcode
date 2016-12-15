package problems;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public static void main(String[] args) {
		ReconstructItinerary a = new ReconstructItinerary();
		// String[][] tickets = new String[][] { { "MUC", "LHR" },
		// { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };\
		String[][] tickets = new String[][] { { "JFK", "A" }, { "A", "C" },
				{ "C", "D" }, { "C", "JFK" }, { "B", "C" }, { "D", "A" },
				{ "D", "B" }, { "JFK", "D" } };
		List<String> ret = a.findItinerary2(tickets);
		System.out.println(ret);
	}

	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> flights = new HashMap<String, PriorityQueue<String>>();
		LinkedList<String> path = new LinkedList<String>();
		for (String[] ticket : tickets) {
			if (!flights.containsKey(ticket[0])) {
				flights.put(ticket[0], new PriorityQueue<String>());
			}
			flights.get(ticket[0]).add(ticket[1]);
		}
		dfs("JFK", flights, path);
		return path;
	}

	public void dfs(String departure,
			Map<String, PriorityQueue<String>> flights, LinkedList<String> path) {
		PriorityQueue<String> arrivals = flights.get(departure);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), flights, path);
		}
		path.addFirst(departure);
	}

	public List<String> findItinerary2(String[][] tickets) {
		Map<String, PriorityQueue<String>> flights = new HashMap<String, PriorityQueue<String>>();
		for (String[] ticket : tickets) {
			if (!flights.containsKey(ticket[0])) {
				flights.put(ticket[0], new PriorityQueue<String>());
			}
			flights.get(ticket[0]).add(ticket[1]);
		}
		LinkedList<String> path = new LinkedList<String>();
		Deque<String> stack = new LinkedList<String>();
		stack.push("JFK");
		while (!stack.isEmpty()) {
			while (flights.containsKey(stack.peek())
					&& !flights.get(stack.peek()).isEmpty())
				stack.push(flights.get(stack.peek()).poll());
			path.addFirst(stack.pop());
		}
		return path;
	}

}
