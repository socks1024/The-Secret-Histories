package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Heart;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.PowerUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.DexterityPower;

public class IngredientHeartFPrincipleAction extends ConsumePrincipleAction {

    private final AbstractCreature target;
    private final int principleNeed;
    //private final int blockPerTrigger;

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
        //this.blockPerTrigger = blockPerTrigger;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {
        int times = consumedAmount / principleNeed;
        int rawBlock = times+ PowerUtils.GetPowerAmount(Heart.POWER_ID, source);

        if (source.hasPower("Frail")) {
            rawBlock = (int)(rawBlock * 0.75f);
        }
        addToTop(new GainBlockAction(target, source, rawBlock));
        isDone = true;
    }
}
