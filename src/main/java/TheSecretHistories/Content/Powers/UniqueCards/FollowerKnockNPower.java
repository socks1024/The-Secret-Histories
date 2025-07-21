package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class FollowerKnockNPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(FollowerKnockNPower.class.getSimpleName());

    private static final String IMG_NAME = "neville_a";

    public FollowerKnockNPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        addToTop(new RemoveSpecificPowerAction(owner, owner, this));
    }
}
