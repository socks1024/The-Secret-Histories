package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class EdgeAction2 extends ConsumePrincipleAction {

    private final int principleNeed;

    public EdgeAction2(AbstractCreature target, AbstractCreature source, AbstractCard.CardTags principleTag, int principleNeed) {
        super(source, principleTag);
        this.target = target;

        this.principleNeed = principleNeed;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {

        for (int i = 0; i < consumedAmount / principleNeed; i++) {
            addToBot(new ApplyPowerAction(source, source, new StrengthPower(source, 1), 1));
        }


        isDone = true;

    }
}
