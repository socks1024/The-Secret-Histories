package TheSecretHistories.Data;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.megacrit.cardcrawl.core.Settings;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.megacrit.cardcrawl.core.Settings.language;

public class MultiLevelCardStrings {
    public String[] NAMES;
    public String[] IMG_PATHS;
    public String[] DESCRIPTIONS;

    public static MultiLevelCardStrings GetMultiLevelCardString(String id){

        String lang = "ENG";
        if (language == Settings.GameLanguage.ZHS){
            lang = "ZHS";
        }

        String json = Gdx.files.internal("TheSecretHistories/Localization/" + lang + "/multi_level_cards.json").readString(String.valueOf(StandardCharsets.UTF_8));

        Type stringsMapType = (new TypeToken<Map<String, MultiLevelCardStrings>>() {}).getType();

        Gson gson = new Gson();
        Map<String, MultiLevelCardStrings> stringsMap = gson.fromJson(json, stringsMapType);

        return stringsMap.get(id);

    }
}
