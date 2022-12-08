package ms.gradems.util;

//加密
public class EncryptUtils {

    public static String byte2hex(byte[] b) {
        return getString(b);
    }

    public static String getString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String st = "";
        for (byte value : b) {
            st = (Integer.toHexString(value & 0XFF));
            if (st.length() == 1) {
                hs.append("0").append(st);
            } else {
                hs.append(st);
            }
        }
        return hs.toString();
    }
}
