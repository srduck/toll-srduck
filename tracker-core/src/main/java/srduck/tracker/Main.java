package srduck.tracker;

import srduck.dto.PointDTO;

/**
 * Created by igor on 06.07.2017.
 */
public class Main {
    public static void main(String... args) throws Exception {
        for (int i=0; i<5; i++) {
            System.out.println("Main.main say Hello!!!!");
            PointDTO point = new PointDTO();
            point.setLat(45);
            System.out.println(point.toJson());
            Thread.sleep(1000);
        }
    }
}
