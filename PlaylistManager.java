import java.util.Scanner;

public class PlaylistManager {
	// Declaration of the playlists and recently played queue
	private PlaylistArrayList arrayListPlaylist = new PlaylistArrayList();
	private PlaylistLinkedList linkedListPlaylist = new PlaylistLinkedList();
	private RecentlyPlayedQueue recentlyPlayedQueue = new RecentlyPlayedQueue(5);
	private boolean useArrayList = true;

    public void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("\nPlaylist Manager Menu:\n" +
					"1. Add Song\n" +
					"2. Insert Song at Position\n" +
					"3. Remove Song\n" +
					"4. View Song\n" +
					"5. Shuffle Playlist\n" +
					"6. Print Playlist\n" +
					"7. Sort Playlist\n" +
					"8. Search for Song\n" +
					"9. View Recently Played Songs\n" +
					"10. Switch Playlist Type\n" +
					"11. Exit\n" +
					"Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					addSong(scanner);
					break;
				case 2:
					insertSong(scanner);
					break;
				case 3:
					removeSong(scanner);
					break;
				case 4:
					viewSong(scanner);
					break;
				case 5:
					shufflePlaylist();
					break;
				case 6:
					printPlaylist();
					break;
				case 7:
					sortPlaylist(scanner);
					break;
				case 8:
					searchSong(scanner);
					break;
				case 9:
					recentlyPlayedQueue.printRecentlyPlayed();
					break;
				case 10:
					switchPlaylistType();
					break;
				case 11:
					scanner.close();
					return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}


	private void addSong(Scanner scanner) {
		// Prompt for song details
		Song song = createSong(scanner);
		// Add to the current playlist
		if (useArrayList) {
			arrayListPlaylist.addSong(song);
		} else {
			linkedListPlaylist.addSong(song);
		}
		System.out.println("Song added to the playlist.");
	}


	private void insertSong(Scanner scanner) {
		// Prompt for index and song details
		System.out.print("Enter index to insert the song at: ");
		int index = scanner.nextInt();
		scanner.nextLine();
		Song song = createSong(scanner);
		// Insert into the current playlist
		if (useArrayList) {
			arrayListPlaylist.insertSong(index, song);
		} else {
			linkedListPlaylist.insertSong(index, song);
		}
		System.out.println("Song inserted at position " + index + " in the playlist.");
	}

	private void removeSong(Scanner scanner) {
		// Prompt for the index to remove
		System.out.print("Enter index of the song to remove: ");
		int index = scanner.nextInt();
		scanner.nextLine();
		// Remove from the current playlist
		if (useArrayList) {
			arrayListPlaylist.removeSong(index);
		} else {
			linkedListPlaylist.removeSong(index);
		}
		System.out.println("Song at index " + index + " has been removed from the playlist.");
	}


	private void viewSong(Scanner scanner) {
		// Prompt for the index
		System.out.print("Enter index of the song to view: ");
		int index = scanner.nextInt();
		scanner.nextLine();
		// Retrieve the song from the current playlist
		Song song;
		if (useArrayList) {
			song = arrayListPlaylist.getSong(index);
		} else {
			song = linkedListPlaylist.getSong(index);
		}
		// Display the song and add to recently played queue
		if (song != null) {
			System.out.printf("%o. %s by %s (%d seconds)", index, song.getTitle(), song.getArtist(), song.getDuration());
			recentlyPlayedQueue.addRecentlyPlayed(song);
		} else {
			System.out.println("No song found at index " + index + ".");
		}
	}


	private void shufflePlaylist() {
		// Shuffle the current playlist
		if (useArrayList) {
			arrayListPlaylist.shuffle();
		} else {
			linkedListPlaylist.shuffle();
		}
		System.out.println("Playlist shuffled.");
	}


	private void printPlaylist() {
		// Print songs from the current playlist
		if (useArrayList) {
			arrayListPlaylist.printPlaylist();
		} else {
			linkedListPlaylist.printPlaylist();
		}
	}

	private void sortPlaylist(Scanner scanner) {
		System.out.print("Choose sort type: 1. Title 2. Artist 3. Duration\nEnter your choice: ");
		int sortChoice = scanner.nextInt();
		scanner.nextLine();

		// Sort the playlist based on user's choice
		if (useArrayList) {
			switch (sortChoice) {
				case 1:
					arrayListPlaylist.sortByTitle();
					System.out.println("Playlist sorted by title.");
					break;
				case 2:
					arrayListPlaylist.sortByArtist();
					System.out.println("Playlist sorted by artist.");
					break;
				case 3:
					arrayListPlaylist.sortByDuration();
					System.out.println("Playlist sorted by duration.");
					break;
				default:
					System.out.println("Invalid sort choice.");
			}
		} else {
			switch (sortChoice) {
				case 1:
					linkedListPlaylist.sortByTitle();
					System.out.println("Playlist sorted by title.");
					break;
				case 2:
					linkedListPlaylist.sortByArtist();
					System.out.println("Playlist sorted by artist.");
					break;
				case 3:
					linkedListPlaylist.sortByDuration();
					System.out.println("Playlist sorted by duration.");
					break;
				default:
					System.out.println("Invalid sort choice.");
			}
		}
	}


	private void searchSong(Scanner scanner) {
		System.out.print("Search by: 1. Title 2. Artist\nEnter your choice: ");
		int searchChoice = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter search term: ");
		String term = scanner.nextLine();

		int index = -1;
		// Search in the current playlist
		if (useArrayList) {
			if (searchChoice == 1) {
				index = arrayListPlaylist.searchByTitle(term);
			} else if (searchChoice == 2) {
				index = arrayListPlaylist.searchByArtist(term);
			} else {
				System.out.println("Invalid search choice.");
				return;
			}
		} else {
			if (searchChoice == 1) {
				index = linkedListPlaylist.searchByTitle(term);
			} else if (searchChoice == 2) {
				index = linkedListPlaylist.searchByArtist(term);
			} else {
				System.out.println("Invalid search choice.");
				return;
			}
		}

		// Display search result
		if (index != -1) {
			System.out.println("Song found at index " + index + ".");
		} else {
			System.out.println("Song not found.");
		}
	}

	//Switch from arryaylist to linkedlist playlist style
	private void switchPlaylistType() {
		useArrayList = !useArrayList;
		System.out.println("Switched to " + (useArrayList ? "ArrayList" : "LinkedList") + " playlist.");
	}

	private Song createSong(Scanner scanner) {
		System.out.print("Enter song title: ");
		String title = scanner.nextLine();
		System.out.print("Enter artist name: ");
		String artist = scanner.nextLine();
		System.out.print("Enter duration in seconds: ");
		int duration = scanner.nextInt();
		scanner.nextLine();

		return new Song(title, artist, duration);
	}
}

