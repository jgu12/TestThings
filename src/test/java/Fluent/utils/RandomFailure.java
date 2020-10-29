package Fluent.utils;

import java.util.Random;

// nice quick failure generation
// ref: https://drive.google.com/file/d/1fPTmH2OHHSUsS_7oKO3J9Vleo8_hDSAV/view


public class RandomFailure {

    public void generate(){
        int n = new Random().nextInt(10);
        if(n>2){
            String message = "random exception: "+ n;
            try{
                Thread.sleep(n*500);
            } catch (InterruptedException e){
                throw new RuntimeException("interrupted");
            }
            System.out.println(message);
            throw new RuntimeException(message);
        }
    }
}
