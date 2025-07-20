package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.DexterityPower;

public class HeartPrincipleAction extends ConsumePrincipleAction {
    private final AbstractCreature target;
    private final int principleNeed;
    private final int damagePerTrigger;

    public HeartPrincipleAction(
            AbstractCreature target,
            AbstractCreature source,
            AbstractCard.CardTags principleTag,
            int principleNeed,
            int damagePerTrigger
    ) {
        super(source, principleTag);
        this.target = target;
        this.source = source;
        this.principleNeed = principleNeed;
        this.damagePerTrigger = damagePerTrigger;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {
        int times = consumedAmount / principleNeed;
        for (int i = 0; i < times; i++) {
            addToBot(new ApplyPowerAction(source, source, new DexterityPower(source, 1), 1));

        }
        isDone = true;
    }
}
