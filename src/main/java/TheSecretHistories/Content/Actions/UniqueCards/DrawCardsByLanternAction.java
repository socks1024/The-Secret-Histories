package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.UniqueCards.ToolLanternFPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DrawCardsByLanternAction extends AbstractGameAction {

    private int principleNeed;

    public DrawCardsByLanternAction(AbstractCreature source, int principleNeed) {
        this.source = source;
        this.principleNeed = principleNeed;
    }

    @Override
    public void update() {

        int drawAmount = AbstractDungeon.player.getPower(ToolLanternFPower.POWER_ID).amount / principleNeed;
        for (int i = 0; i < drawAmount; i++) {
            addToTop(new DrawCardAction(source, drawAmount));
        }

        isDone = true;
    }
}
