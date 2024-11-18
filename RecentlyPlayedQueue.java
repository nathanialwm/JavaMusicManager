import java.util.LinkedList;
import java.util.Queue;

public class RecentlyPlayedQueue {
	private Queue<Song> recentlyPlayed;
	private int maxSize;

	public RecentlyPlayedQueue(int maxSize) {
		this.maxSize = maxSize;
		recentlyPlayed = new LinkedList<>();
	}

	public void addRecentlyPlayed(Song song) {
		// Adds the song to the queue. If the queue exceeds maxSize, remove the oldest song
		if (recentlyPlayed.size() >= maxSize) {
			recentlyPlayed.poll(); // Remove the oldest song
		}
		recentlyPlayed.offer(song); // Add the new song to the queue
	}

	public void printRecentlyPlayed() {
		// Prints the songs in the recently played queue in order
		if (recentlyPlayed.isEmpty()) {
			System.out.println("No recently played songs.");
		} else {
			System.out.println("Recently Played Songs:");
			int index = 1;
			for (Song song : recentlyPlayed) {
				System.out.printf("%d. %s by %s (%d seconds)", index, song.getTitle(), song.getArtist(), song.getDuration());
				index++;
			}
		}
	}
}
