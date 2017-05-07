package org.vox.study.javacore;

import java.util.GregorianCalendar;

/**
 * 
 * @author cielleech
 *
 */
public class Chapter3 {
    private String name;
    
    {
        name = "12345";
        System.out.println(name);
    }
    
    @Override
    public void finalize() {
        
    }
    
    public Chapter3() {
        name = "1234";
    }
    
    public void testOperate() {
        Integer a = -8;
        System.out.println(a);
        System.out.println(a >>> 2);
    }
    
    public void testCodePoint() {
        String text = "A" + "\uD835\uDD0A" + "B" + "C";
        
        char[] chars = Character.toChars(104000);
        
        String a = new String(chars);
        
        System.out.println(text.length());
        System.out.println(text.codePointCount(0, text.length()));
        System.out.println(text);
        System.out.println("chars length is: " + chars.length);
        System.out.println("a length is: " + a.length());
        System.out.println(chars);
    }
    
    public void testDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        
        System.out.println(name);
        System.out.println(calendar.toString());
    }
}
