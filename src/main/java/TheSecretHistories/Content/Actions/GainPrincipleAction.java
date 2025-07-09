package TheSecretHistories.Content.Actions;

import TheSecretHistories.Content.Powers.Principles.AbstractPrinciple;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Content.Powers.Principles.SecretHistories;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.Objects;

public class GainPrincipleAction extends AbstractGameAction {

    private AbstractPrinciple principle;

    public GainPrincipleAction(AbstractCreature target, AbstractPrinciple principle){
        this.target = target;

        this.principle = principle;
    }

    @Override
    public void update() {

        if (!target.hasPower(principle.ID) || principle.stack) {

            AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(target, source, principle));

        } else {

            AbstractPrinciple currPrinciple = (AbstractPrinciple)target.getPower(principle.ID);

            if (currPrinciple.amount < principle.amount){
                currPrinciple.amount = principle.amount;
            }

        }

        isDone = true;
    }
}
