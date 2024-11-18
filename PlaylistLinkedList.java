import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class PlaylistLinkedList {
	private LinkedList<Song> playlist;

	public PlaylistLinkedList() {
		playlist = new LinkedList<>();
	}

	public void addSong(Song song) {
		// Adds a song to the end of the playlist
		playlist.add(song);
	}

	public void insertSong(int index, Song song) {
		// Inserts a song at the specified index in the playlist
		if (index >= 0 && index <= playlist.size()) {
			playlist.add(index, song);
		} else {
			System.out.println("Invalid index. Cannot insert song.");
		}
	}

	public void removeSong(int index) {
		// Removes the song at the specified index from the playlist
		if (index >= 0 && index < playlist.size()) {
			playlist.remove(index);
		} else {
			System.out.println("Invalid index. Cannot remove song.");
		}
	}

	public Song getSong(int index) {
		// Returns the song at the specified index, or null if the index is invalid
		if (index >= 0 && index < playlist.size()) {
			return playlist.get(index);
		} else {
			System.out.println("Invalid index. Cannot get song.");
			return null;
		}
	}

	public void shuffle() {
		// Shuffles the playlist
		Collections.shuffle(playlist);
	}

	public void sortByTitle() {
		// Sorts the playlist by song title
		playlist.sort((song1, song2) -> song1.getTitle().compareToIgnoreCase(song2.getTitle()));
	}

	public void sortByArtist() {
		// Sorts the playlist by artist name
		playlist.sort((song1, song2) -> song1.getArtist().compareToIgnoreCase(song2.getArtist()));
	}

	public void sortByDuration() {
		// Sorts the playlist by duration
		playlist.sort((song1, song2) -> Integer.compare(song1.getDuration(), song2.getDuration()));
	}

	public int searchByTitle(String title) {
		// Searches for a song by title and returns its index, or -1 if not found
		int index = 0;
		for (Song song : playlist) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public int searchByArtist(String artist) {
		// Searches for a song by artist and returns its index
		int index = 0;
		for (Song song : playlist) {
			if (song.getArtist().equalsIgnoreCase(artist)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public void printPlaylist() {
		// Prints all songs in the playlist
		if (playlist.isEmpty()) {
			System.out.println("The playlist is empty.");
		} else {
			int index = 1;
			for (Song song : playlist) {
				System.out.printf("%d. %s by %s (%d seconds)", index, song.getTitle(), song.getArtist(), song.getDuration());
				index++;
			}
		}
	}
}
