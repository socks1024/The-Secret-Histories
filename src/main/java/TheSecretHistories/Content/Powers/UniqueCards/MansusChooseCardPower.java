package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class MansusChooseCardPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(MansusChooseCardPower.class.getSimpleName());

    private static final String IMG_NAME = "influenceknockg";

    public MansusChooseCardPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        addToBot(new RemoveSpecificPowerAction(owner, owner, this));
    }
}
