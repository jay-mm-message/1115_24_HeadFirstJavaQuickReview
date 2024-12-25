package ch16.Jukebox2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jukebox2 {

    //ArrayList<Song> songList = new ArrayList<Song>();
    List<Song> songList = new ArrayList<Song>();
    
    public static void main(String [] args) {
        Jukebox2 Jukebox2 = new Jukebox2();
        Jukebox2.go();
    }

    void go() {
        System.out.println();
        getSongs();
        showSongList();
        //goCollections(songList);
        showSongList();
    }

    void getSongs() {
        //"ch16/Jukebox2/SongList.txt"
        File f = new File("ch16/Jukebox2/SongList.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = null;
            try {
                while(null != (line = reader.readLine())) {
                    addSong(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    void addSong(String lineString) {
        String [] tokens = lineString.split("/");
        songList.add(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));
    }

    void showSongList() {
        System.out.println(songList);
    }

    void goCollections(ArrayList<Song> list) {
        //Collections.sort(list.toString());
    }
}