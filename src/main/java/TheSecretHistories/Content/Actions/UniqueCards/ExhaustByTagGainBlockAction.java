package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.ArrayList;

public class ExhaustByTagGainBlockAction extends AbstractGameAction {
    private final AbstractCard.CardTags targetTag;
    private final int blockPerCard;

    public ExhaustByTagGainBlockAction(AbstractCreature source, AbstractCard.CardTags tag, int blockPerCard) {
        this.source = source;
        this.targetTag = tag;
        this.blockPerCard = blockPerCard;
        this.actionType = ActionType.EXHAUST;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    @Override
    public void update() {
        ArrayList<AbstractCard> toExhaust = new ArrayList<>();
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c.hasTag(targetTag)) {
                toExhaust.add(c);
            }
        }
        if (toExhaust.isEmpty()) {
            this.isDone = true;
            return;
        }for (AbstractCard c : toExhaust) {
            addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
            addToTop(new GainBlockAction(AbstractDungeon.player, source, blockPerCard));
        }

        this.isDone = true;
    }
}
