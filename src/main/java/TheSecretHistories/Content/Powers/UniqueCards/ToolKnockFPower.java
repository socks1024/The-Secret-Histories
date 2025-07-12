package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolKnockFPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolKnockFPower.class.getSimpleName());

    private static final String IMG_NAME = "toolknockf";

    public ToolKnockFPower(AbstractCreature owner) {
        super(POWER_ID, IMG_NAME, owner, -1);

        this.type = PowerType.BUFF;
    }
}
