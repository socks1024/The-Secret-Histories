package TheSecretHistories.Patch;

import TheSecretHistories.Content.Powers.UniqueCards.ToolForgeBPower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class AbstractCardPatch {

    @SpirePatch(clz = AbstractCard.class, method = "canUse")
    public static class CanUsePatch {

        @SpirePrefixPatch
        public static SpireReturn<Boolean> CanUsePatchMethod(AbstractCard __instance, AbstractPlayer p, AbstractMonster m) {

            if (__instance.type == AbstractCard.CardType.STATUS && __instance.costForTurn < -1 && AbstractDungeon.player.hasPower(ToolForgeBPower.POWER_ID)) {
                return SpireReturn.Return(true);
            }

            return SpireReturn.Continue();
        }
    }
}
