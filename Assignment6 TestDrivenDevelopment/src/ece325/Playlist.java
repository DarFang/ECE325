package ece325;
import java.util.Comparator;
import java.util.Iterator;
/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 */
// @SuppressWarnings("serial")
class TitleCompare implements Comparator<Song>{
	/**
	 * Edits the Sort from collection
	 * compares titles
	 * @param s1 song 1
	 * @param s2 song 2
	 */
	@Override
	public int compare(Song s1 , Song s2) {
		return s1.getTitle().compareTo(s2.getTitle());
	}
}
class ArtistCompare implements Comparator<Song>{
	/**
	 * Edits the Sort from collection
	 * compares artist
	 * @param s1 song 1
	 * @param s2 song 2
	 */
	
	@Override
	public int compare(Song s1 , Song s2) {
		return s1.getArtist().compareTo(s2.getArtist());
	}
}

public class Playlist<E extends Song> extends java.util.ArrayList<E> {
	/**
	 * Constructor
	 * @param String pListTitle the title of the playlist
	 * @param Arraylist list of songs
	 */
    Iterator<E> itr = this.iterator();       // Generic Iterator; Use it whenever you need it!
    private String T;
    /**
     * Gets the list title
     * @param pListTitle Title of playlist
     */
    Playlist(String pListTitle){
    	this.T = pListTitle;
    }
    /**
     * Add song to playlist
     * @param newSong
     * @return true if the song is added, false if the input is null or the song is already added
     */
    public Boolean addtoPlist(E newSong){
    	if (newSong == null) {
    		return false;
    	}
    	if (!(contains(newSong))){
    		return add(newSong);
    	}
    	return false;
    }
    /**
     * Gets the title of the playlist
     * @return String Title
     */
    public String getTitle() {
    	return T;
    }
    /**
     * Removes the song from the playlist
     * @param String song to delete
     * @return true if it removes the song, false otherwise
     */
    public Boolean removeFromPlist(Song song) {
    	return remove(song);
    }
    /**
     * gets the song of the index
     * @param num index 
     * @return String song
     */
    public Song getSong(int num) {
    	return get(num);
    }
    /**
     * Returns if the title is in the playlist
     * @param String title to compare
     * @return true if the playlist contains the title 
     */
    public Boolean hasTitle(String title) {
    	return T.equals(title);
    }
    /**
     * Returns if the artist is in the playlist
     * @param String artist to compare
     * @return true if the playlist contains the artist 
     */
    public Boolean hasArtist(String artist) {
    	itr = this.iterator();
    	while (itr.hasNext()){
    		Song temp = itr.next();
    		if (temp.isArtist(artist)){
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * returns the number of unique songs
     * @return int num 
     */
	public int numberOfSongs() {
		int num = 0;
		itr = this.iterator();
		java.util.ArrayList<Song> list1 = new java.util.ArrayList<Song>();
		while(itr.hasNext()){
			Song temp = itr.next();
			if (!(list1.contains(temp))){
				num++;
				list1.add(temp);
			}
		}
		return num;
	}
    /**
     * returns the number of unique Artist
     * @return int num 
     */
    public int numberOfArtists() {
    	int num = 0;
    	itr = this.iterator();
    	java.util.ArrayList<String> ArtistList = new java.util.ArrayList<String>();
    	while(itr.hasNext()){
    		Song temp = itr.next();
    		if (!(ArtistList.contains(temp.getArtist().toLowerCase()))){
    			num++;
    			ArtistList.add(temp.getArtist().toLowerCase());
    		}
    	}
    	return num;
    }
    /**
     * returns the number of unique Titles
     * @return int num 
     */
    public int numberOfTitles() {
    	int num = 0;
    	itr = this.iterator();
    	java.util.ArrayList<String> TitleList = new java.util.ArrayList<String>();
    	while(itr.hasNext()){
    		Song temp = itr.next();
    		if (!(TitleList.contains(temp.getTitle().toLowerCase()))){
    			num++;
    			TitleList.add(temp.getTitle().toLowerCase());
    		}
    	}
    	return num;
    }
    /**
     * returns the title playlist length
     * @return int length
     */
    public double playTime() {
    	double length = 0;
    	itr = this.iterator();
    	while(itr.hasNext()) {
    		Song temp = itr.next();
    		length += temp.getLength();
    	}
    	return length;
    }
    public int findSong(Song song) {
    	if (contains(song)) {
    		return indexOf(song);
    	}
    	return -1;
    }
}
