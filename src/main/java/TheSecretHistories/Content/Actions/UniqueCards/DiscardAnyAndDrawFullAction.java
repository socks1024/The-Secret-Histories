package TheSecretHistories.Content.Actions.UniqueCards;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.ExpertiseAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;

import java.util.Iterator;

public class DiscardAnyAndDrawFullAction extends AbstractGameAction {
    private static final UIStrings uiStrings;
    public static final String[] TEXT;

    public DiscardAnyAndDrawFullAction(AbstractCreature source) {
        this.setValues(AbstractDungeon.player, source, -1);
        this.actionType = ActionType.CARD_MANIPULATION;
    }

    public void update() {
        if (this.duration == 0.5F) {
            AbstractDungeon.handCardSelectScreen.open(TEXT[1], 99, true, true);

            this.addToBot(new WaitAction(0.25F));
            this.tickDuration();
        } else {
            if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
                if (!AbstractDungeon.handCardSelectScreen.selectedCards.group.isEmpty()) {

                    this.addToTop(new ExpertiseAction(source, BaseMod.MAX_HAND_SIZE));

                    for (AbstractCard c : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
                        AbstractDungeon.player.hand.moveToDiscardPile(c);
                        GameActionManager.incrementDiscard(false);
                        c.triggerOnManualDiscard();
                    }
                }

                AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            }

            this.tickDuration();
        }

        this.isDone = true;
    }

    static {
        uiStrings = CardCrawlGame.languagePack.getUIString("GamblingChipAction");
        TEXT = uiStrings.TEXT;
    }
}
