package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class IngredientHeartDPrincipleAction extends ConsumePrincipleAction {

    private final AbstractCreature target;
    private final int block;

    public IngredientHeartDPrincipleAction(
            AbstractCreature target,
            AbstractCreature source,
            AbstractCard.CardTags principleTag,
            int block
    ) {
        super(source, principleTag);
        this.target = target;
        this.source = source;
        this.block = block;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {
        addToTop(new GainBlockAction(target, source, block*2));
        isDone = true;
    }
}
