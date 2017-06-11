package org.vox.study.reactor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by cielleech on 2017/5/28.
 */
public class Acceptor implements  Runnable {
    private BlockingDeque<Long> queue = new LinkedBlockingDeque<>();

    private Demultilple demultilple;

    private int port;

    public Acceptor(Demultilple demultilple, int port) {
        this.demultilple = demultilple;
        this.port = port;
    }

    public void newEvent(Long eventKey) {
        queue.offer(eventKey);
    }

    @Override
    public void run() {
        while(true) {
            Long eventKey = null;
            try {
                eventKey = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (eventKey != null) {
                Event event = new Event();
                event.setKey(eventKey);

                demultilple.add(event);
            }
        }
    }
}
