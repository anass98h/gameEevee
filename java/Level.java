package src.main.java;

public class Level {
    private int startPositionX;
    private int startPositionY;
    private Athing[][] level;

    public Level(String[] levle,int posX, int posY) {
        level = new Athing[levle.length][];
        for (int y = 0; y < levle.length; y++) {
            level[y] = new Athing[levle[y].length()];
            for (int x = 0; x<levle[y].length();x++) {
                switch (levle[y].charAt(x)) {
                    case '.':
                        level[y][x] = new Athing(x, y, "floor");
                    case '/':
                        level[y][x] = new Athing(x, y, "stairs");
                    case '#':
                        level[y][x] = new Athing(x, y, "wall");
                    case 'c':
                        level[y][x] = new Athing(x, y, "chocolate");
                    case 'p':
                        level[y][x] = new Athing(x, y, "chips");
                    case 'h':
                        level[y][x] = new Athing(x, y, "health");
                    case 'b':
                        level[y][x] = new Athing(x, y, "bone");
                    case 'k':
                        level[y][x] = new Athing(x, y, "key");
                    case 'd':
                        level[y][x] = new Athing(x, y, "door");
                    case 't':
                        level[y][x] = new Athing(x, y, "table");
                    case 'w':
                        level[y][x] = new Athing(x, y, "water");

                }
            }
        }
        this.startPositionY = posY;
        this.startPositionX = posX;

    }

    public boolean removeconsuble(int PosX, int PosY) {
        switch (level[PosY][PosX].getName()) {
            case"chocolate.png":
            case"chips.png":
            case"health.png":
            case"bone.png":
            case"key.png":
                level[PosY][PosX] = new Athing(PosX, PosY, "floor.png");
                return true;

        }
        return false;
    }

    public boolean openAdoor(int PosX, int PosY) {
        if (level[PosY][PosX].getName() == "door.png") {
            level[PosY][PosX] = new Athing(PosX, PosY, "stairs.png");
            return true;
        }
        return false;
    }

    public Athing getAthing(int AtPostionx, int AtPostionY) {
        return level[AtPostionx][AtPostionY];
    }

    public int getStartPositionX() {
        return startPositionX;
    }
    public int getStartPositionY() {
        return startPositionY;
    }

    public int getlevelX() {
        return level[0].length;
    }
    public int getlevelY() {
        return level.length;
    }

}
