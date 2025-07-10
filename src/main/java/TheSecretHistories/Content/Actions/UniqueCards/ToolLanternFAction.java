package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.UniqueCards.ToolLanternFPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ToolLanternFAction extends AbstractGameAction {

    private int principleNeed;

    public ToolLanternFAction(AbstractCreature source, int principleNeed) {
        this.source = source;
        this.principleNeed = principleNeed;
    }

    @Override
    public void update() {

        int drawAmount = AbstractDungeon.player.getPower(ToolLanternFPower.ID).amount / principleNeed;
        for (int i = 0; i < drawAmount; i++) {
            addToBot(new DrawCardAction(source, drawAmount));
        }
    }
}
