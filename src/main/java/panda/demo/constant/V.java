package panda.demo.constant;

import panda.app.constant.VAL;
import panda.lang.time.DateTimes;

/**
 * ValueConstants
 */
public interface V extends VAL {
	public final static String DEFAULT_PWD = "000000";
	
	public static final int PETIMG_CACHE_MAXAGE = 30 * DateTimes.SEC_DAY;
}

