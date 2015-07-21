package com.navid.gamemanager.ext;

import com.navid.gamemanager.domain.Game;
import org.zeromq.ZMQ;

/**
 * Created by alberto on 7/19/15.
 */
public class GameRepresentation {

    private final Game game;

    private ZMQ.Context context;

    public GameRepresentation(Game game) {
        this.game = game;

        context = ZMQ.context(1);

        //  Socket to talk to clients
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.setLinger(5000);
        // In 0MQ 3.x pub socket could drop messages if sub can follow the generation of pub messages
        publisher.setSndHWM(0);
        publisher.bind("tcp://*:5561");

        //  Socket to receive signals
        ZMQ.Socket syncservice = context.socket(ZMQ.REP);
        syncservice.bind("tcp://*:5562");

        System.out.println("Waiting subscribers");
        //  Get synchronization from subscribers
        int subscribers = 0;
        while (subscribers < 1) {
            //  - wait for synchronization request
            syncservice.recv(0);

            //  - send synchronization reply
            syncservice.send("", 0);
            subscribers++;
        }
        //  Now broadcast exactly 1M updates followed by END
        System.out.println ("Broadcasting messages");

        int update_nbr;
        for (update_nbr = 0; update_nbr < 1000000; update_nbr++){
            publisher.send("Rhubarb", 0);
        }

        publisher.send("END", 0);

        // clean up
        publisher.close();
        syncservice.close();
        context.term();
    }



}
