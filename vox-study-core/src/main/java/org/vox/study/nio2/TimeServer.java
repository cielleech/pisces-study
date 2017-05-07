package org.vox.study.nio2;

/**
 * Created by cielleech on 2016/4/9.
 */
public class TimeServer {
    public    static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (RuntimeException e) {

            }

        }
    }
}
