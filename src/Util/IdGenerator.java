package Util;

import java.util.Random;


public class IdGenerator {

    private static final char[] characters = {
       'a','b','c','d','e','f','g','h','i','j','k','l',
       'm','n','o','p','q','r','s','t','u','v','w','x',
       'y','z','1','2','3','4','5','6','7','8','9','0'
    };

    private static Random r = new Random();

    /**
     * 根据给定长度生成随机字符串
     * @param length 长度
     * @return
     */
    public static String generateId(int length){
        StringBuilder sb = new StringBuilder("uid");
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(characters.length);
            sb.append(characters[index]);
        }
        return sb.toString();
    }
}
