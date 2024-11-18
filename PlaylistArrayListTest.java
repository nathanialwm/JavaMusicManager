import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PlaylistArrayListTest {

    @Test
    public void testAddSong() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song = new Song("Imagine", "John Lennon", 183);
        playlist.addSong(song);

        assertEquals(song, playlist.getSong(0));
    }

    @Test
    public void testInsertSong() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song1 = new Song("Hey Jude", "The Beatles", 431);
        Song song2 = new Song("Bohemian Rhapsody", "Queen", 354);
        playlist.addSong(song1);
        playlist.insertSong(0, song2);

        assertEquals(song2, playlist.getSong(0));
        assertEquals(song1, playlist.getSong(1));
    }

    @Test
    public void testRemoveSong() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song = new Song("Stairway to Heaven", "Led Zeppelin", 482);
        playlist.addSong(song);
        playlist.removeSong(0);

    }

    @Test
    public void testGetSong() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song = new Song("Hotel California", "Eagles", 391);
        playlist.addSong(song);

        assertEquals(song, playlist.getSong(0));
        assertNull(playlist.getSong(1)); // Invalid index
    }

    @Test
    public void testSortByTitle() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song1 = new Song("Hotel California", "Eagles", 200);
        Song song2 = new Song("Hey Jude", "The Beatles", 210);
        Song song3 = new Song("Bohemian Rhapsody", "Queen", 220);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.sortByTitle();

        assertEquals("Bohemian Rhapsody", playlist.getSong(0).getTitle());
        assertEquals("Hey Jude", playlist.getSong(1).getTitle());
        assertEquals("Hotel California", playlist.getSong(2).getTitle());
    }

    @Test
    public void testSortByArtist() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song1 = new Song("Song A", "Queen", 200);
        Song song2 = new Song("Song B", "Rob Zombie", 180);
        Song song3 = new Song("Song C", "Eminem", 220);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.sortByArtist();

        assertEquals("Eminem", playlist.getSong(0).getArtist());
        assertEquals("Queen", playlist.getSong(1).getArtist());
        assertEquals("Rob Zombie", playlist.getSong(2).getArtist());
    }

    @Test
    public void testSortByDuration() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song1 = new Song("Song A", "Artist A", 155);
        Song song2 = new Song("Song B", "Artist B", 200);
        Song song3 = new Song("Song C", "Artist C", 210);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.sortByDuration();

        assertEquals(155, playlist.getSong(0).getDuration());
        assertEquals(200, playlist.getSong(1).getDuration());
        assertEquals(210, playlist.getSong(2).getDuration());
    }

    @Test
    public void testSearchByTitle() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song = new Song("Darkness", "Eminem", 200);
        playlist.addSong(song);

        int index = playlist.searchByTitle("Darkness");
        assertEquals(0, index);

        index = playlist.searchByTitle("Nonexistent Title");
        assertEquals(-1, index);
    }

    @Test
    public void testSearchByArtist() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song = new Song("Song Title", "Unique Artist", 200);
        playlist.addSong(song);

        int index = playlist.searchByArtist("Unique Artist");
        assertEquals(0, index);

        index = playlist.searchByArtist("Unknown Artist");
        assertEquals(-1, index);
    }

    @Test
    public void testPrintPlaylist() {
        PlaylistArrayList playlist = new PlaylistArrayList();
        playlist.printPlaylist();
    }
}
