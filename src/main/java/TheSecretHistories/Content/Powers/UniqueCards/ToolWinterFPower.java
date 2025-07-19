package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ToolWinterFPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolWinterFPower.class.getSimpleName());

    private static final String IMG_NAME = "toolwinterf";

    public ToolWinterFPower(AbstractCreature owner) {
        super(POWER_ID, IMG_NAME, owner, -1);
    }

    @Override
    public void atStartOfTurn() {
        addToBot(new GainBlockAction(AbstractDungeon.player, PowerUtils.GetPowerAmount(Winter.POWER_ID, owner)));
    }
}
