package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Powers.UniqueCards.IngredientWinterBPower;
import TheSecretHistories.Content.Powers.UniqueCards.SpiritWinterMothPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Winter extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Winter.class.getSimpleName());
    private static final String IMG_NAME = "winter";

    public Winter(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);

        if (owner.hasPower(SpiritWinterMothPower.POWER_ID)) {
            int count = owner.getPower(SpiritWinterMothPower.POWER_ID).amount;
            addToTop(new GainBlockAction(owner, (int) (this.amount * count * 0.5)));
            this.amount = 0;
        }
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (!owner.hasPower(IngredientWinterBPower.POWER_ID)) addToBot(new DamageAction(owner, new DamageInfo(owner, amount)));
    }
}
