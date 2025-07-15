package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Actions.Principle.GainPrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class ToolWinterDPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolWinterDPower.class.getSimpleName());

    private static final String IMG_NAME = "toolwinterd";

    public ToolWinterDPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);

        this.type = PowerType.DEBUFF;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {

        addToBot(new ApplyPowerAction(owner, owner, new Winter(owner, this.amount)));
    }
}
