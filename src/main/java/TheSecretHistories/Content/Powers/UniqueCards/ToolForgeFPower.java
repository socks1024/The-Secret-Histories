package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolForgeFPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolForgeFPower.class.getSimpleName());

    public static final String IMG_NAME = "toolforgef";

    public ToolForgeFPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
