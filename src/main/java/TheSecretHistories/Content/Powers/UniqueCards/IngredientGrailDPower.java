package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class IngredientGrailDPower extends TemplateCustomPower {
    public static final String POWER_ID = StringUtils.MakeID(IngredientGrailDPower.class.getSimpleName());
    private static final String IMG_NAME = "ingredientgrailb";

    private static final float REDUCTION_PER_STACK = 0.20f;

    public IngredientGrailDPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.type = PowerType.BUFF;
    }

    @Override
    public float atDamageFinalReceive(float damage, DamageInfo.DamageType type) {
        float totalReduction = REDUCTION_PER_STACK * this.amount;
        if (totalReduction > 1f) {
            totalReduction = 1f;
        }
        return damage * (1f - totalReduction);
    }
}
