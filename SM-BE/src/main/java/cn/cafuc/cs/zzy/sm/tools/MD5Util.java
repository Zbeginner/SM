package cn.cafuc.cs.zzy.sm.tools;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Util {
    private static final String SALT = "cafuc";

    public static String md5(String password) {
        String hashAlgorithmName="MD5";
        ByteSource byteSalt=ByteSource.Util.bytes(SALT);
        Object source=password;
        int hashIterations=2;
        SimpleHash result=new SimpleHash(hashAlgorithmName,source,byteSalt,hashIterations);
        return result.toString();
    }

}
