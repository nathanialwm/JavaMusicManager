# Java Music Manager

A console-only music manager program. Allows for adding, inserting and shuffling songs into a playlist.
Can swap between data type of array or linked list

## Table of Contents

- [Tech Stack](#tech-stack)
- [Preview](#preview)
- [How It Works](#how-it-works)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)
- [Contact](#contact)

## Tech Stack

 - **Java**: Scripting Language

## Preview

```java
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
```

## How It Works

Two custom data classes are created, one for an array of songs, one for a linkedlist of songs, containing searching and sorting

A queue keeps track of recently played songs.

The music manager contains the main logic, taking user input and executing a specified function, including searching, adding and removing songs


## Installation

Clone the repository

```bash
git clone https://github.com/nathanialwm/AutoBattle-RPG.git
```

Make sure you have a compatable jre or jvm

## Usage

Run Main.java in a code editor

## License

Unlicensed

## Contact

Nathanial Martin @ [Linkedin](https://www.linkedin.com/in/nathanialm/)
