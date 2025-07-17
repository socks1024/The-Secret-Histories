package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ReduceHandCostAction extends AbstractGameAction {
    @Override
    public void update() {
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            c.updateCost(-1);
        }
        this.isDone = true;
    }
}

