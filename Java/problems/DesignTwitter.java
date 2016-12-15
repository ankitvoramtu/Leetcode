package problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
	private static class Tweet {
		int tweetId;
		int timePosted;

		public Tweet(int tId, int time) {
			tweetId = tId;
			timePosted = time;
		}
	}

	static int timeStamp;
	int feedMaxNum;
	Map<Integer, Set<Integer>> followees;
	Map<Integer, List<Tweet>> tweets;

	/** Initialize your data structure here. */
	public Twitter() {
		timeStamp = 0;
		feedMaxNum = 10;
		followees = new HashMap<Integer, Set<Integer>>();
		tweets = new HashMap<Integer, List<Tweet>>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!tweets.containsKey(userId)) {
			tweets.put(userId, new LinkedList<Tweet>());
			follow(userId, userId); // follow itself
		}
		tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++)); // add new
																	// tweet on
																	// the first
																	// place
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		// min heap that the earliest tweet is on the top
		PriorityQueue<Tweet> feedHeap = new PriorityQueue<Tweet>(10,
				new Comparator<Tweet>() {
					public int compare(Tweet t1, Tweet t2) {
						return t1.timePosted - t2.timePosted;
					}
				});

		// add tweets of the followees
		Set<Integer> myFollowees = followees.get(userId);
		if (myFollowees != null) {
			for (int followeeId : myFollowees) {
				List<Tweet> followeeTweets = tweets.get(followeeId);
				if (followeeTweets == null)
					continue;
				for (Tweet t : followeeTweets) {
					if (feedHeap.size() < feedMaxNum)
						feedHeap.add(t);
					else {
						if (t.timePosted <= feedHeap.peek().timePosted)
							break;
						else {
							feedHeap.add(t);
							feedHeap.poll(); // remove the oldest tweet
						}
					}
				}
			}
		}
		List<Integer> myFeed = new LinkedList<Integer>();
		while (!feedHeap.isEmpty()) {
			myFeed.add(0, feedHeap.poll().tweetId);
		}
		return myFeed;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (!followees.containsKey(followerId))
			followees.put(followerId, new HashSet<Integer>());
		followees.get(followerId).add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (!followees.containsKey(followerId) || followerId == followeeId)
			return; // cannot unfollow itself
		followees.get(followerId).remove(followeeId);
	}
}

public class DesignTwitter {

	private static int timeStamp = 0;

	// easy to find if user exist
	private Map<Integer, User> userMap;

	// Tweet link to next Tweet so that we can save a lot of time
	// when we execute getNewsFeed(userId)
	private class Tweet {
		public int id;
		public int time;
		public Tweet next;

		public Tweet(int id) {
			this.id = id;
			time = timeStamp++;
			next = null;
		}
	}

	// OO design so User can follow, unfollow and post itself
	public class User {
		public int id;
		public Set<Integer> followed;
		public Tweet tweet_head;

		public User(int id) {
			this.id = id;
			followed = new HashSet<>();
			follow(id); // first follow itself
			tweet_head = null;
		}

		public void follow(int id) {
			followed.add(id);
		}

		public void unfollow(int id) {
			followed.remove(id);
		}

		// everytime user post a new tweet, add it to the head of tweet list.
		public void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweet_head;
			tweet_head = t;
		}
	}

	/** Initialize your data structure here. */
	public DesignTwitter() {
		userMap = new HashMap<Integer, User>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!userMap.containsKey(userId)) {
			User u = new User(userId);
			userMap.put(userId, u);
		}
		userMap.get(userId).post(tweetId);

	}

	// Best part of this.
	// first get all tweets lists from one user including itself and all people
	// it followed.
	// Second add all heads into a max heap. Every time we poll a tweet with
	// largest time stamp from the heap, then we add its next tweet into the
	// heap.
	// So after adding all heads we only need to add 9 tweets at most into this
	// heap before we get the 10 most recent tweet.
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new LinkedList<>();

		if (!userMap.containsKey(userId))
			return res;

		Set<Integer> users = userMap.get(userId).followed;
		Comparator<Tweet> comp = new Comparator<Tweet>() {
			@Override
			public int compare(Tweet a, Tweet b) {
				return b.time - a.time;
			}
		};

		PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(10, comp);
		for (int user : users) {
			Tweet t = userMap.get(user).tweet_head;
			// very imporant! If we add null to the head we are screwed.
			if (t != null) {
				q.add(t);
			}
		}
		int n = 0;
		while (!q.isEmpty() && n < 10) {
			Tweet t = q.poll();
			res.add(t.id);
			n++;
			if (t.next != null)
				q.add(t.next);
		}

		return res;

	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (!userMap.containsKey(followerId)) {
			User u = new User(followerId);
			userMap.put(followerId, u);
		}
		if (!userMap.containsKey(followeeId)) {
			User u = new User(followeeId);
			userMap.put(followeeId, u);
		}
		userMap.get(followerId).follow(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (!userMap.containsKey(followerId) || followerId == followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
