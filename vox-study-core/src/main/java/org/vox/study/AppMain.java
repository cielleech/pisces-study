package org.vox.study;

import java.math.BigDecimal;

/**
 * Created by cielleech on 2016/4/9.
 */
public class AppMain {
    public static void main(String[] args) {
    	    BigDecimal a = new BigDecimal("0.3").subtract(new BigDecimal("0.2"));
    	    BigDecimal b = new BigDecimal("0.2").subtract(new BigDecimal("0.1"));
    	    System.out.println((0.3 - 0.2) == (0.2 - 0.1));
    	    System.out.println(a.compareTo(b));
    }
}
