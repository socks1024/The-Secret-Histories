package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class IngredientHeartFPrincipleAction extends ConsumePrincipleAction {

    private final AbstractCreature target;
    private final int principleNeed;
    private final int blockPerTrigger;

    public IngredientHeartFPrincipleAction(
            AbstractCreature target,
            AbstractCreature source,
            AbstractCard.CardTags principleTag,
            int principleNeed,
            int blockPerTrigger
    ) {
        super(source, principleTag);
        this.target = target;
        this.source = source;
        this.principleNeed = principleNeed;
        this.blockPerTrigger = blockPerTrigger;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {
        int times = consumedAmount / principleNeed;
        for (int i = 0; i < times; i++) {
            addToTop(new GainBlockAction(target, source, blockPerTrigger));
        }
        isDone = true;
    }
}
