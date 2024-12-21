package ch16.Jukebox1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1 {

    ArrayList<String> songList = new ArrayList<String>();
    public static void main(String [] args) {
        Jukebox1 jukebox1 = new Jukebox1();
        jukebox1.go();
    }

    void go() {
        System.out.println();
        getSongs();
        showSongList();
        goCollections(songList);
        showSongList();
    }

    void getSongs() {
        //"ch16/Jukebox1/SongList.txt"
        File f = new File("ch16/Jukebox1/SongList.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = null;
            try {
                while(null != (line = reader.readLine())) {
                    addSong(line);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    void addSong(String lineString) {
        String [] tokens = lineString.split("/");
        songList.add(tokens[0]);
    }

    void showSongList() {
        System.out.println(songList);
    }

    void goCollections(ArrayList<String> list) {
        Collections.sort(list);
    }
}