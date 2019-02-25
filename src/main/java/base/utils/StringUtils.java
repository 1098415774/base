package base.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

public class StringUtils {

    public static boolean isEmpty(String s){
        if (s==null || s.length()<=0)
            return true;
        else
            return false;
    }

    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }

    public static Object ISO88591ToUTF8(Object obj) throws IllegalAccessException, UnsupportedEncodingException {
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            Object fieldobj = field.get(obj);
            if (fieldobj instanceof String){
                String str = new String(((String) fieldobj).getBytes("iso-8859-1"),"utf-8");
                field.set(obj,str);
            }
        }
        return obj;
    }

    public static String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        String string = "abcdefghijklmnopqrstuvwxyz";
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt((int) Math.round(Math.random() * (len-1))));
        }
        return sb.toString();
    }
}
