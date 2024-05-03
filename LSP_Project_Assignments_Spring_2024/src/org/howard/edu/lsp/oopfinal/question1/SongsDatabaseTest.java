package org.howard.edu.lsp.oopfinal.question1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;

public class SongsDatabaseTest {

    private SongsDatabase db;

    @Before
    public void setUp() {
        db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Country", "Sweet Alabama");
        db.addSong("Jazz", "Always There");
    }

    /* Add a song title to a genre */
    @Test
    public void testAddSong() {
        String newGenre = "Pop";
        String newSong = "Happy";
        db.addSong(newGenre, newSong);
        assertTrue(db.getSongs(newGenre).contains(newSong));
    }

    /* Return genre, i.e., jazz, given a song title */
    @Test
    public void testGetSongs() {
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("Savage"));
    }

    /* Return the Set that contains all songs for a genre */
    @Test
    public void testGetGenreOfSong() {
        assertEquals("Rap", db.getGenreOfSong("Savage"));
        assertEquals("Country", db.getGenreOfSong("Sweet Alabama"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));
        assertNull(db.getGenreOfSong("Nonexistent Song"));
    }
}
