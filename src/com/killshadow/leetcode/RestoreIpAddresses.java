package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: killshadow
 * Date: 2021/11/5 0005
 * Description:
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses ipAddresses = new RestoreIpAddresses();
        System.out.println(ipAddresses.restoreIpAddresses("25525511135"));
        System.out.println(ipAddresses.restoreIpAddresses("0000"));
    }

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> ans = new ArrayList<>();
        if (len < 4 || len > 12) {
            return ans;
        }
        
        return ans;
    }
}
