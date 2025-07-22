package TheSecretHistories.Patch;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Content.Characters.TheSeeker;
import TheSecretHistories.Utils.DebugUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.screens.SingleCardViewPopup;
import javassist.CtBehavior;

public class SingleCardViewPopupPatch {

    @SpirePatch(clz = SingleCardViewPopup.class, method = "render")
    public static class AddDoubleCardPatch {

        @SpireInsertPatch(locator = Locator.class, localvars = {"card"})
        public static void AddDoubleCardPreview(SingleCardViewPopup instance, SpriteBatch sb, AbstractCard card) {

            if (!(AbstractDungeon.player instanceof TheSeeker)) return;

            TemplateCustomCard customCard = (TemplateCustomCard) card;

            if (customCard.lowerCardToPreview == null) return;
            if (customCard.higherCardToPreview == null) return;

            AbstractCard lowerCardToPreview = customCard.lowerCardToPreview;
            AbstractCard higherCardToPreview = customCard.higherCardToPreview;

            float previewCardHeight = lowerCardToPreview.hb.height;

            float drawScale = 0.75F;
            float xPosition1 = card.current_x + previewCardHeight * 0.7F;
            float yPosition1 = card.current_y + previewCardHeight * 0.65F;
            float yPosition2 = card.current_y + previewCardHeight * 1.8F;

            // 下面一张
            lowerCardToPreview.drawScale = drawScale;
            lowerCardToPreview.current_x = xPosition1;
            lowerCardToPreview.current_y = yPosition1;
            lowerCardToPreview.render(sb);

            // 上面一张
            higherCardToPreview.drawScale = drawScale;
            higherCardToPreview.current_x = xPosition1;
            higherCardToPreview.current_y = yPosition2;
            higherCardToPreview.render(sb);
        }

        private static class Locator extends SpireInsertLocator {
            public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
                Matcher.MethodCallMatcher methodCallMatcher = new Matcher.MethodCallMatcher(SingleCardViewPopup.class, "renderTips");
                int[] lines = LineFinder.findInOrder(ctMethodToPatch, methodCallMatcher);
                lines[0] = lines[0] + 1;
                return lines;
            }
        }
    }
}
