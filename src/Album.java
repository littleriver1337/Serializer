/**
 * Created by MattBrown on 10/14/15.
 */
public class Album {
    String artist;
    int releaseDate;
    String collaborator;
    int numTrack;
    int albumLength;

    public Album(){

    }

    public Album(String artist, int releaseDate, String collaborator, int numTrack, int albumLength){
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.collaborator = collaborator;
        this.numTrack = numTrack;
        this.albumLength = albumLength;
    }

    public String getArtist() {
        return artist;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getCollaborator() {
        return collaborator;
    }

    public int getNumTrack() {
        return numTrack;
    }

    public int getAlbumLength() {
        return albumLength;
    }
}
