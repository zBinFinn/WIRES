package me.zbinfinn.firstplugin.util;

import java.util.Random;

public class TextUtil {
    private static Random random = new Random();
    public static String uwuIfy(String message) {
        String[] uwus = new String[]{">_<",">-<","(°ｏ°)","(●´⌓`●)","(◡ w ◡)","(⁄˘⁄ ⁄ ω⁄ ⁄ ˘⁄)♡"};
        String output = "";
        char[] msg = message.toCharArray();
        String add = "";
        for (char c : msg) {
            add = "" + c;

            if (c == 'u' && random.nextInt(3) == 1) {
                add = add + "wu";
            }
            if (c == 'o' && random.nextInt(3) == 1) {
                add = add + "wo";
            }

            if (c == 'l' || c == 'r') {
                add = "w";
            }

            if (c != ' ' && random.nextInt(8) == 1) {
                add = c + "-" + add;
            }

            if (c == ' ' && random.nextInt(4) == 1) {
                add = add + uwus[random.nextInt(uwus.length)-1] + " ";
            }


            output = output + add;
        }

        return output;


    }
}
