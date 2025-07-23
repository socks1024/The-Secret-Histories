package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class FollowerMothYPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(FollowerMothYPower.class.getSimpleName());

    private static final String IMG_NAME = "ysabet_a";

    public FollowerMothYPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
