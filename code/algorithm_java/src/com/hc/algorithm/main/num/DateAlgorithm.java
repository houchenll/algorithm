package com.hc.algorithm.main.num;

/**
 * 日期相关算法
 */
public class DateAlgorithm {

    /**
     * 闰年判定
     * 地球绕太阳公转一周为365天5时48分46秒（合365.2422天）即一回归年。公历的平年只有365日，比回归年短约0.2422日，
     * 余下的时间约为四年累计一天，故四年于2月加1天，使当年的历年长度为366日，这一年就为闰年。现行公历中每400年有97个
     * 闰年。按照每四年一个闰年计算，平均每年就要多算出0.0078天，这样经过四百年就会多算出大约3天来，因此，每四百年中要
     * 减少三个闰年。所以规定，公历年份是整百数的，必须是400的倍数的才是闰年，不是400的倍数，虽然是4的倍数，也是平年，
     * 即：四年一闰，百年不闰，四百年再闰。
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}
