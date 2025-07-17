package TheSecretHistories.Patch;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.Soul;
import javassist.CtBehavior;

@SpirePatch(clz = Soul.class, method = "obtain")
public class CardOnObtainPatch {

    @SpireInsertPatch(locator = MyLocator.class)
    public static void ObtainPatchMethod(Soul __instance, AbstractCard card) {
        if (card instanceof TemplateCustomCard) ((TemplateCustomCard)card).OnObtain();
    }

    public static class MyLocator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(Soul.class, "setSharedVariables");
            return LineFinder.findInOrder(ctMethodToPatch, methodCallMatcher);
        }
    }
}
