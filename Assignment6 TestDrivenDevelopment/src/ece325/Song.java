package ece325;
/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 */
public class Song {
    /**
     * Song consists of the artist, the title, the length
     * Constructor:
     * String Artist the artist of the song
     * String Title the title of the song
     * double Length the length of the song
     */
	private String Artist, Title;
	private double Length;
	Song(String Artist, String Title, double Length){
		this.Artist = Artist;
		this.Title = Title;
		this.Length = Length;
	}
	/**
	 * Gets the artist of the song
	 * @return String Artist 
	 */
	public String getArtist() {
		return Artist;
	}
	/**
	 * Gets the Title of the song
	 * @return String Title 
	 */
	public String getTitle() {
		return Title;
	}
	public Boolean isArtist(String input) {
		if (Artist.toLowerCase().equals(input.toLowerCase())){
			return true;
		}
		return false;
	}
	/**
	 * Return true of the input is the title (NONCASE SENSITIVE)
	 * @param input String to compare of song title
	 * @return true if is equal
	 */
	public Boolean isTitle(String input) {
		if (Title.toLowerCase().equals(input.toLowerCase())){
			return true;
		}
		return false;
	}
	/**
	 * Gets the length of the song
	 * @return Double Length
	 */
	public double getLength() {
		return Length;
	}
	@Override
	/**
	 * Equals when input is the song
	 * @return true if it equals
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(!(obj instanceof Song)) {
			return false;
		}
		Song song = (Song) obj;
		return Title.toLowerCase().equals(song.getTitle().toLowerCase())
				&& Artist.toLowerCase().equals(song.getArtist().toLowerCase())
				&& Length == song.getLength();
	}
}
