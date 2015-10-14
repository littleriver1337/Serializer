import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by MattBrown on 10/14/15.
 */
public class Questions {
    static Album album;

    public static void main(String[] args) {
        System.out.println("Welcome to your album creator!");
        album = loadAlbum();

        if(album == null) {
            survey();
        }else {
            String s = "";
            while (!s.equals("n")) {
                System.out.println(album.artist);
                System.out.println(album.releaseDate);
                System.out.println(album.collaborator);
                System.out.println(album.numTrack);
                System.out.println(album.albumLength);
                System.out.println("Would you like to update your album?[y/n]!");
                Scanner scanner = new Scanner(System.in);
                s = scanner.nextLine();
                if (s.equals("y")) {
                    System.out.println("What value would you like to change?");
                    String c = scanner.nextLine();
                    if (c.equals("artist")) {
                        System.out.println("What would you like to change it to?");
                        String newAnswer = scanner.nextLine();
                        album.artist = newAnswer;
                    } else if (c.equals("release")) {
                        System.out.println("What would you like to change it to?");
                        String newAnswer = scanner.nextLine();
                        album.releaseDate = Integer.valueOf(newAnswer);
                    } else if (c.equals("collaborator")) {
                        System.out.println("What would you like to change it to?");
                        String newAnswer = scanner.nextLine();
                        album.collaborator = newAnswer;
                    } else if (c.equals("track number")) {
                        System.out.println("What would you like to change it to?");
                        String newAnswer = scanner.nextLine();
                        album.numTrack = Integer.valueOf(newAnswer);
                    } else if (c.equals("album length")) {
                        System.out.println("What would you like to change it to?");
                        String newAnswer = scanner.nextLine();
                        album.albumLength = Integer.valueOf(newAnswer);
                    }
                    saveAlbum(album);
                }
                else {

                }
            }
        }
    }

    static void survey(){
        System.out.println("What is the name of your Artist?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("What is the release year of your Album?");
        String date = scanner.nextLine();
        int dateNum = Integer.valueOf(date);

        System.out.println("What is the name of the collaborator?");
        String collabName = scanner.nextLine();

        System.out.println("How many of tracks does this album have?");
        String track = scanner.nextLine();
        int trackNum = Integer.valueOf(track);

        System.out.println("How long is the full album?");
        String album = scanner.nextLine();
        int albumLength = Integer.valueOf(album);

        System.out.println("Thank you for creating an album in the database!");

        Album object = new Album(name, dateNum, collabName, trackNum, albumLength);
        saveAlbum(object);

    }


    static void saveAlbum(Album object) {
        File f = new File("save.json");
        JsonSerializer serializer = new JsonSerializer();
        String contentToSave = serializer.serialize(object);

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentToSave);
            fw.close();
        } catch (Exception RektNerd) {
        }
    }

    static Album loadAlbum() {
        try {
            File f = new File("save.json");
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();//(int) is casting f.length to an int
            char[] contents = new char[fileSize];
            fr.read(contents);
            String fileContents = new String(contents);
            JsonParser parser = new JsonParser();
            return parser.parse(fileContents, Album.class);
        } catch (Exception RektNerd) {
            return null;
        }
    }
}

