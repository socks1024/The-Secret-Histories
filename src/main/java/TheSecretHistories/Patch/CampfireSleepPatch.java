package TheSecretHistories.Patch;

import TheSecretHistories.Content.Cards.Mansus.Mansus;
import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.DeckUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.UpgradeShineEffect;
import com.megacrit.cardcrawl.vfx.campfire.CampfireSleepEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect;

@SpirePatch(clz = CampfireSleepEffect.class, method = "update")
public class CampfireSleepPatch {

    @SpireInsertPatch(loc = 82)
    public static void CampfireSleepPatchMethod(CampfireSleepEffect __instance){
        if (DeckUtils.HasMansus()) {
            TemplateCustomCard c = (TemplateCustomCard) AbstractDungeon.player.masterDeck.findCardById(Mansus.ID);
            AbstractDungeon.effectsQueue.add(new UpgradeShineEffect(Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F));
            c.upgrade();
            AbstractDungeon.player.bottledCardUpgradeCheck(c);
            AbstractDungeon.effectsQueue.add(new ShowCardBrieflyEffect(c.makeStatEquivalentCopy()));
        }
    }
}
