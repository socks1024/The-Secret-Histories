package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class ToolGrailFAction extends ConsumePrincipleAction {

    private final int principleNeed;

    public ToolGrailFAction(AbstractCreature target, AbstractCreature source, AbstractCard.CardTags principleTag, int principleNeed) {
        super(source, principleTag);
        this.target = target;

        this.principleNeed = principleNeed;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {

        for (int i = 0; i < consumedAmount / principleNeed; i++) {
            addToTop(new ApplyPowerAction(target, source, new StrengthPower(target, -1)));
            addToTop(new ApplyPowerAction(target, source, new WeakPower(target, 1, false)));
            addToTop(new ApplyPowerAction(target, source, new VulnerablePower(target, 1, false)));
        }

        isDone = true;

    }
}
