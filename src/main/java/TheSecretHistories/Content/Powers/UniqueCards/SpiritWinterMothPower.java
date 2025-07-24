package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class SpiritWinterMothPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(SpiritWinterMothPower.class.getSimpleName());

    private static final String IMG_NAME = "spirit_winterb_heart";

    public SpiritWinterMothPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
