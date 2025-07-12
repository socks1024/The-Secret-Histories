package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DecreaseMaxHpAction extends AbstractGameAction {

    private int amount;

    public DecreaseMaxHpAction(AbstractCreature target, int amount) {
        this.target = target;
        this.amount = amount;
    }

    @Override
    public void update() {
        target.decreaseMaxHealth(amount);

        isDone = true;
    }
}
