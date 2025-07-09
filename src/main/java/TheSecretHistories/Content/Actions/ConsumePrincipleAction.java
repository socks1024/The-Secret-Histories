package TheSecretHistories.Content.Actions;

import TheSecretHistories.Content.Powers.Principles.AbstractPrinciple;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ConsumePrincipleAction extends AbstractGameAction {

    private AbstractPrinciple[] requestedPrinciples;

    private AbstractGameAction actionOnConsumed;

    public ConsumePrincipleAction(AbstractCreature target, AbstractPrinciple[] requestedPrinciples, AbstractGameAction actionOnConsumed){
        this.target = target;

        this.requestedPrinciples = requestedPrinciples;
        this.actionOnConsumed = actionOnConsumed;
    }

    @Override
    public void update() {

        boolean hasEnoughPrinciple = true;

        for (AbstractPrinciple principle : requestedPrinciples){
            if (!target.hasPower(principle.ID) || target.getPower(principle.ID).amount < principle.amount){
                hasEnoughPrinciple = false;
            }
        }

        if (hasEnoughPrinciple) {
            for (AbstractPrinciple principle : requestedPrinciples) {
                target.getPower(principle.ID).amount -= principle.amount;
            }

            if (actionOnConsumed != null) AbstractDungeon.actionManager.addToTop(actionOnConsumed);
        }

        isDone = true;
    }
}
