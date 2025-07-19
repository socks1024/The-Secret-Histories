package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Spirit_GrailE_EdgePower extends TemplateCustomPower {
    public static final String POWER_ID = StringUtils.MakeID(Spirit_GrailE_EdgePower.class.getSimpleName());
    private static final String IMG_NAME = "spirit_graile_edge";

    private static final float REDUCTION_PER_STACK = 0.20f;

    public Spirit_GrailE_EdgePower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.type = PowerType.DEBUFF;
    }

    @Override
    public float atDamageReceive(float damage, DamageInfo.DamageType type) {
        return damage * (1.0f + 0.5f * amount);
    }
}
