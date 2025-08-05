package TheSecretHistories.ModConfig;

import TheSecretHistories.Utils.StringUtils;
import TheSecretHistories.Utils.TextureLoader;
import basemod.BaseMod;
import basemod.EasyConfigPanel;
import com.badlogic.gdx.graphics.Texture;

public class TSHModConfig extends EasyConfigPanel {

    public static boolean EnableCultistSimulatorMusic = true;

    public TSHModConfig() {
        super("TheSecretHistories", StringUtils.MakeID("TSHModConfig"));
    }

    public static void SetUpModConfig(){
        Texture badgeTexture = TextureLoader.getTexture("TheSecretHistories/img/UI/splendid.png");
        BaseMod.registerModBadge(badgeTexture, "The Secret Histories", "Socks & Rabbit & Idiot Hog", "A STS mod of Cultist Simulator.", new TSHModConfig());
    }
}
