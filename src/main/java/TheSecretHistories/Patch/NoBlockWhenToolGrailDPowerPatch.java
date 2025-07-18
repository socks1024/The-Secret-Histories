package TheSecretHistories.Patch;

import TheSecretHistories.Content.Powers.UniqueCards.ToolGrailDPower;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.core.AbstractCreature;

@SpirePatch(
        clz = AbstractCreature.class,
        method = "addBlock",
        paramtypez = { int.class }
)
public class NoBlockWhenToolGrailDPowerPatch {
    @SpirePrefixPatch
    public static SpireReturn<Void> prefix(AbstractCreature __instance, int blockAmount) {
        if (__instance.hasPower(ToolGrailDPower.POWER_ID)) {
            return SpireReturn.Return();
        }
        return SpireReturn.Continue();
    }
}
