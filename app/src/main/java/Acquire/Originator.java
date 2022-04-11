package Acquire;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Originator {

    public void gameSave(File file, Board game) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(game.getState(), writer);
        }
    }

    public Board gameRestore(File file) throws IOException {
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Board.class);
        }
    }
}
