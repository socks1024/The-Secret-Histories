package TheSecretHistories.Utils;

import com.megacrit.cardcrawl.core.Settings;

import static com.megacrit.cardcrawl.core.Settings.language;

public class StringUtils {

    public static String lang;

    static {

        if (language == Settings.GameLanguage.ZHS) {
            lang = "ZHS";
        } else {
            lang = "ENG";
        }
    }

    public static String MakeID(String  ID){
        return "TheSecretHistories:" + ID;
    }

    public static String MakeDebug(String origin){
        return "The Secret Histories Debug Log Info : " + origin;
    }

    public static String MakeLocalizationPath(String path) {
        return "TheSecretHistories/Localization/" + lang + "/" + path;
    }
}
