package src.main.java;

public class Eevee extends Athing{
    private int health;
    private boolean key;
    private Direction direction;
    private boolean potion;
    private int offSetX;
    private int offSetY;

    public Eevee(int positionInX, int PositionInY,String name) {
        super(positionInX, PositionInY,name);
        this.potion = false;
        this.health = 100;
        this.key = false;
    }

    public void usePotion() {
        if (this.potion) {
            this.health += 50;
            this.potion = false;
        }else {
            ///print massage "you dont have a potion to use
        }
    }
    public boolean useKey() {
        if (this.key) {
            this.key = false;
            return true;
            //open the door
        }else {
            return false;
            ///print massage "you dont have a potion to use
        }
    }

    public void pickUPpotion() {
        this.potion = true;
        //print massage "you picked up a potion
    }

    public void pickUPkey() {
        this.key = true;
        //print massage you
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction Direction) {
        this.direction = Direction;
    }

    public int getOffSetX() {
        return offSetX;
    }

    public int getOffSetY() {
        return offSetY;
    }

    public void setOffSet(int x, int offSetY) {
        this.offSetX = x;
        this.offSetY = offSetY;
    }

    public void setPostion(int x, int y) {
        if (x > mappositionX) {
            offSetX = 32;
        } else if (x < mappositionX) {
            offSetX = -32;
        } else if (y < mapPositionY) {
            mapPositionY = -32;
        }else if (y > mapPositionY) {
            mapPositionY = 32;
        }
    }
    public void decreaseMotionOffset() {
        if(offSetX > 0)
            offSetX-=2;
        else if(offSetX < 0)
            offSetX+=2;

        if(offSetY > 0)
            offSetY-=2;
        else if(offSetY < 0)
            offSetY+=2;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int damage) {
        this.health -= damage;
    }
    public void heal(int heal) {
        this.health += heal;
    }

}
