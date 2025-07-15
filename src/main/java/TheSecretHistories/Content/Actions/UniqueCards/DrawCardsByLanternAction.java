package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Content.Powers.UniqueCards.ToolLanternFPower;
import TheSecretHistories.Utils.PowerUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DrawCardsByLanternAction extends AbstractGameAction {

    private final int principleNeed;

    public DrawCardsByLanternAction(AbstractCreature source, int principleNeed) {
        this.source = source;
        this.principleNeed = principleNeed;
    }

    @Override
    public void update() {

        addToTop(new DrawCardAction(source, PowerUtils.GetPowerAmount(Lantern.POWER_ID, source) / principleNeed));

        isDone = true;
    }
}
