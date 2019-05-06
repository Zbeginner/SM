package cn.cafuc.cs.zzy.sm.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsPackage:cn.cafuc.cs.zzy.sm.tools
 * @Author:zzy
 */
public class Tools {
    //处理特殊字符
    private static Pattern handleP = Pattern.compile("\\s*|\t|\r|\n");

    //此正则特定模拟计科学生的学号
    private static Pattern stuNumP = Pattern.compile("^S?20[0-9]{2}0511[0-9]{3}$");

    /**
     * 处理特殊字符
     * @param s
     * @return
     */
    public static String handle(String s) {
        if (s == null) {
            return null;
        }
        Matcher m = handleP.matcher(s);
        s = m.replaceAll("");
        if (s.endsWith("\ufeff")) {
            s = s.replace("\ufeff", "");
        }
        if (s.startsWith("\ufeff")) {
            s = s.replace("\ufeff", "");
        }
        s = s.replaceAll(" ", "").replaceAll(" ", "");
        return s;
    }

    public static Boolean judgeStuNum(String s) {
        s = s.toUpperCase();
        return stuNumP.matcher(s).find();
    }
//    public static void main(String[] a){
//        String num="20160511043";
//        String num2="2016051104a";
//        String num3="S20160511043";
//        System.out.println(judgeStuNum(num));
//        System.out.println(judgeStuNum(num2));
//        System.out.println(judgeStuNum(num3));
//    }
}
