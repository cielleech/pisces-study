package org.vox.study.reactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by cielleech on 2017/5/28.
 */
public class EventDispather {
    private Boolean stop;

    private Demultilple demultilple;

    private Map<Long, List<EventHandler>> map = new HashMap<>();

    public void handleEvents() {
    }

    public void registerEvent(Long eventKey, EventHandler handler) {
        if (map.containsKey(eventKey)) {
            List<EventHandler> handlers = map.get(eventKey);
            handlers.add(handler);
        } else {
            List<EventHandler> handlers = new ArrayList<>();
            handlers.add(handler);
            map.put(eventKey, handlers);
        }
    }

    public void removeEvent(Long eventKey, EventHandler handler) {
        if (map.containsKey(eventKey) && map.get(eventKey).contains(handler)) {
            map.get(eventKey).remove(handler);
        }
    }

    public void init() {
        while (true) {
            if (stop)
                break;
            List<Event> events = demultilple.selet(1000);

            for (Event event : events) {
                for (EventHandler handler : map.get(event.getKey())) {
                    handler.handle(event);
                }
            }
        }
    }

}

class Event {
    private Long key;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }
}

class EventHandler {
    public void handle(Event event) {
    }
}

class Demultilple {
    private BlockingDeque<Event> queue = new LinkedBlockingDeque<>();

    private Object lock = new Object();

    public List<Event> selet(long timeout) {
        if (timeout > 0) {
            if (queue.isEmpty()) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
            }
        }

        List<Event> events = new ArrayList<>();
        queue.drainTo(events);
        return events;
    }

    public void add(Event event) {
        boolean success = queue.offer(event);

        if (success) {
            synchronized (lock) {
                lock.notify();
            }
        }
    }
}
