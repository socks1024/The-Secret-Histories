package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class GainEnergyAtStartOfTurnPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(GainEnergyAtStartOfTurnPower.class.getSimpleName());

    private static final String IMG_NAME = "ritetoolconsumeingredient";

    public GainEnergyAtStartOfTurnPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();

        addToBot(new GainEnergyAction(amount));
    }
}
