package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        return (int)(this.distance*2 + this.quality*100000 - o.distance*2 - o.quality*100000);
    }

    public static void main(String[] args) {
//        Beach first = new Beach("Papa", 22.0f, 3);
//        Beach second = new Beach("mutnoe", 6.0f, 5);
//        System.out.println(first.compareTo(second));
//        System.out.println(second.compareTo(first));

    }
}
