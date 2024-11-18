import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlaylistArrayList {
	private ArrayList<Song> playlist;

	public PlaylistArrayList() {
		playlist = new ArrayList<>();
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
		bubbleSort("TITLE");
	}

	public void sortByArtist() {
		// Sorts the playlist by artist name
		bubbleSort("ARTIST");
	}

	public void sortByDuration() {
		// Sorts the playlist by duration
		bubbleSort("DURATION");
	}

	private void bubbleSort(String sortWhat) {
		int n = playlist.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				boolean shouldSwap = false;
				Song song1 = playlist.get(j);
				Song song2 = playlist.get(j + 1);

				//Cases for each type of sort
				switch (sortWhat) {
					case "TITLE":
						if (song1.getTitle().compareToIgnoreCase(song2.getTitle()) > 0) {
							shouldSwap = true;
						}
						break;
					case "ARTIST":
						if (song1.getArtist().compareToIgnoreCase(song2.getArtist()) > 0) {
							shouldSwap = true;
						}
						break;
					case "DURATION":
						if (song1.getDuration() > song2.getDuration()) {
							shouldSwap = true;
						}
						break;
				}

				if (shouldSwap) {
					// Swap songs here
					playlist.set(j, song2);
					playlist.set(j + 1, song1);
				}
			}
		}
	}

	public int searchByTitle(String title) {
		// Searches for a song by title and returns its index, or -1 if not found
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).getTitle().equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1;
	}

	public int searchByArtist(String artist) {
		// Searches for a song by artist and returns its index, or -1 if not found
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).getArtist().equalsIgnoreCase(artist)) {
				return i;
			}
		}
		return -1;
	}

	public void printPlaylist() {
		// Prints all songs in the playlist
		if (playlist.isEmpty()) {
			System.out.println("The playlist is empty.");
		} else {
			for (int i = 0; i < playlist.size(); i++) {
				Song song = playlist.get(i);
				System.out.printf("%d. %s by %s (%d seconds)", i+1, song.getTitle(), song.getArtist(), song.getDuration());
			}
		}
	}
}
