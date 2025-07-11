package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Edge;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolGrailDPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolGrailDPower.class.getSimpleName());

    private static final String IMG_NAME = "toolgraild";

    public ToolGrailDPower(AbstractCreature owner) {
        super(POWER_ID, IMG_NAME, owner, -1);

        this.type = PowerType.DEBUFF;
    }

    @Override
    public void onGainedBlock(float blockAmount) {
        super.onGainedBlock(blockAmount);

        owner.loseBlock((int) blockAmount);
    }
}
