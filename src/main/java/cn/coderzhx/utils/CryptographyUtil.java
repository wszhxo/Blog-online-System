package cn.coderzhx.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author zhx
 * @create 2019-07-27-20
 */
public class CryptographyUtil {
    public static void main(String[] args) throws Exception {
        System.out.println(md5("java", "java"));
    }

    /**
     * Md5加密
     *
     * @param str
     *            加密的内容
     * @param salt
     *            盐值
     */
    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }
}
