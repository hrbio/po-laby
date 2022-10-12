package agh.ics.oop;

public class Vector2d {
    public int x;
    public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d that = (Vector2d) other;
        if (this.x != that.x) return false;
        if (this.y != that.y) return false;
        return true;
    }

    public int hashCode(){
        return this.toString().hashCode();
    }

    public String toString(){
        return String.format("(%s,%s)", this.x, this.y);
    }

    public boolean precedes(Vector2d other){
        if (this.x > other.x) return false;
        if (this.y > other.y) return false;
        return true;
    }

    public boolean follows(Vector2d other){
        if (this.x < other.x) return false;
        if (this.y < other.y) return false;
        return true;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x,this.y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(other.x-this.x,other.y-this.y);
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Integer.max(this.x, other.x), Integer.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Integer.min(this.x, other.x), Integer.min(this.y, other.y));
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

}
