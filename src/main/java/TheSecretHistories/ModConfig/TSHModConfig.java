package TheSecretHistories.ModConfig;

import TheSecretHistories.Utils.StringUtils;
import basemod.EasyConfigPanel;

public class TSHModConfig extends EasyConfigPanel {

    public static boolean EnableCultistSimulatorMusic = true;

    public TSHModConfig() {
        super("TheSecretHistories", StringUtils.MakeID("TSHModConfig"));
    }
}
