package github.zkpgeeker.ad.utils;

import github.zkpgeeker.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/24
 */
public class CommonUtils {

    private static String[] parsePatterns = {
      "yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd"
    };

    public static String md5(String value) {

        return DigestUtils.md5Hex(value).toUpperCase();
    }

    public static Date parseStringData(String dataString) throws AdException {

        try {
            return DateUtils.parseDate(dataString, parsePatterns);
        } catch (Exception ex) {
            throw new AdException(ex.getMessage());
        }
    }
}
