package com.alevel;

import java.util.Random;

public class Tamagochi implements Runnable {

    private int play_level = 100;
    private int feed_level = 100;
    private int sleep_level = 100;
    private int poop_level = 100;

    private final static int MAX_LEVEL = 100;
    private final static int COMPLAIN_LEVEL = 60;

    public void play(){
        if(play_level <= COMPLAIN_LEVEL){
            play_level = MAX_LEVEL;
        }
    }

    public void feed(){
        if(feed_level <= COMPLAIN_LEVEL){
            feed_level = MAX_LEVEL;
        }
    }

    public void clean(){
        if(poop_level <= COMPLAIN_LEVEL){
            poop_level = MAX_LEVEL;
        }
    }

    public void sleep(){
        if(sleep_level <= COMPLAIN_LEVEL){
            sleep_level = MAX_LEVEL;
        }
    }

    public boolean isRip() {
        if((sleep_level <= 0) ||
                (feed_level <= 0) ||
                (poop_level <= 0)||
                (play_level <= 0)) {
            return true;
        }
        return false;
    }

    private void decreaseParams(){
        Random random = new Random();
        play_level -= (random.nextInt(30) + 10);
        feed_level -= (random.nextInt(30) + 10);
        poop_level -= (random.nextInt(30) + 10);
        sleep_level -= (random.nextInt(30) + 10);
    }

    @Override
    public void run() {
        while (!isRip()){
            try {
                decreaseParams();
                showsProblem();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("R.I.P.");
    }

    private void showsProblem() {
        if(sleep_level <= COMPLAIN_LEVEL){
            System.out.println("I want to sleep");
        }
        if(poop_level <= COMPLAIN_LEVEL){
            System.out.println("I want to toilet");
        }
        if(feed_level <= COMPLAIN_LEVEL){
            System.out.println("I want to eat");
        }
        if(play_level <= COMPLAIN_LEVEL){
            System.out.println("I want to play");
        }
    }

}
