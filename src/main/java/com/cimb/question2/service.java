package com.cimb.question2;

import com.cimb.question1.models.Price;
import com.google.gson.Gson;

import java.util.ArrayList;

import static com.cimb.question2.util.*;

public class service {

    public static void Question2() {
        int result = VersionUpdateOrNot("1.2.0","1.0.0");
        System.out.println(result);
    }

    public static int VersionUpdateOrNot(String version1, String version2) {
        if (version1.isEmpty() || version2.isEmpty()) {
            return -1;
        }
        int typeVer1 = checkTheFormat(version1);
        int typeVer2 = checkTheFormat(version2);
        if (typeVer1 == -1 || typeVer2 == -1) {
            return -1;
        }
        ArrayList<Integer> result1 = truncateVersion(version1);
        ArrayList<Integer> result2 = truncateVersion(version2);
        assert result1 != null;
        int firstPosV1 = result1.get(1);
        int secondPosV1 = result1.get(2);
        assert result2 != null;
        int firstPosV2 = result2.get(1);
        int secondPosV2 = result2.get(2);
        int firstPosDifference = compareVersion(firstPosV1, firstPosV2);
        if (firstPosDifference != 0) {
            return firstPosDifference;
        }
        int secondPosDifference = compareVersion(secondPosV1, secondPosV2);
        if (secondPosDifference != 0) {
            return secondPosDifference;
        }
        return 0;
    }

    public static int compareVersion(int v1, int v2) {
        if (v1 > v2) {
            return v1 - v2;
        } else if (v1 < v2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int checkTheFormat(String input) {
        if (input.isEmpty()) {
            return -1;
        }
        boolean IsFirstFormat = IsFirstRevisionFormat(input);
        boolean IsSecondFormat = IsSecondRevisionFormat(input);
        if (IsFirstFormat) {
            return 1;
        }
        if (IsSecondFormat) {
            return 2;
        }
        return -1;
    }


}
