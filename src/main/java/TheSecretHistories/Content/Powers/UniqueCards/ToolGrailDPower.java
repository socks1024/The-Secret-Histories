package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;


public class ToolGrailDPower extends TemplateCustomPower {
    public static final String POWER_ID = StringUtils.MakeID(ToolGrailDPower.class.getSimpleName());

    public ToolGrailDPower(AbstractCreature owner) {
        super(POWER_ID, "toolgraild", owner, -1);
        this.type = PowerType.DEBUFF;
    }
}
