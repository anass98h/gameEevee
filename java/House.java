package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int room;
    private List<Level> levels;

    public House() {
        this.levels = new ArrayList<Level>();
        this.room = 0;
        this.levels.add(room_1);
        this.levels.add(room_2);

    }
    public Level getLevel(int level) {
        return levels.get(level);

    }


    public Level nextRoom() {
        room += 1;
        if (room == levels.size()) {
            room -= 1;
        }
        return levels.get(room);
    }

//    public Level previousRoom() {
//        if (room != 0) {
//            room += 1;
//        }
//        return levels.get(room);
//    }

    private static final Level room_1 = new Level(new String[]{
            "#############",
            "#...........#",
            "#...........#",
            "#...........#",
            "#...........#",
            "#############"
    }, 4, 5);
    private static final Level room_2 = new Level(new String[]{
            "#######################################",
            "####...c..........................#####",
            "####...........................p..#####",
            "####..............................#####",
            "####.......................b......#####",
            "####.....h.........w..............#####",
            "####..............................#####",
            "####..............................#####",
            "####..............................#####",
            "####.....k..................d.....#####",
            "####..............................#####",
            "####..............................#####",
            "####..............................#####",
            "####..............................#####",
            "#######################################"
    }, 5, 8);
}
