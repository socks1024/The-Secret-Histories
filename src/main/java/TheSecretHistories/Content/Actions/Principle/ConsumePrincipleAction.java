package TheSecretHistories.Content.Actions.Principle;

import TheSecretHistories.Content.Powers.Principles.AbstractPrinciple;
import TheSecretHistories.Utils.PrincipleUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public abstract class ConsumePrincipleAction extends AbstractGameAction {

    private AbstractCard.CardTags principleTag;

    private String principleID;

    private int amount = 0;

    private boolean consumeAll = false;

    public ConsumePrincipleAction(AbstractCreature target, AbstractCard.CardTags principleTag, int amount) {
        this.target = target;
        this.principleTag = principleTag;
        this.amount = amount;
        this.principleID = PrincipleUtils.GetPrincipleIDByTag(principleTag);
    }

    public ConsumePrincipleAction(AbstractCreature target, AbstractCard.CardTags principleTag) {
        this(target, principleTag, 0);
        this.consumeAll = true;
    }

    @Override
    public void update() {

        boolean hasEnoughPrinciple = target.hasPower(principleID) || (target.getPower(principleID).amount >= this.amount);

        if (hasEnoughPrinciple) {

            AbstractPrinciple p = (AbstractPrinciple) target.getPower(principleID);

            if (consumeAll) this.amount = p.amount;

            p.amount -= this.amount;

            OnConsumedEnough(this.amount);
        }

        isDone = true;
    }

    protected abstract void OnConsumedEnough(int consumedAmount);
}
