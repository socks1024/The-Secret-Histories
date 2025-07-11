package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.EntanglePower;

public class SuperEntangle extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(SuperEntangle.class.getSimpleName());

    private static final String IMG_NAME = "toolwinterf";

    public SuperEntangle(AbstractCreature owner) {
        super(POWER_ID, IMG_NAME, owner, -1);

        this.type = PowerType.DEBUFF;
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();

        addToBot(new ApplyPowerAction(owner, owner, new EntanglePower(owner)));
    }
}
