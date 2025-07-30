package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Heart extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Heart.class.getSimpleName());
    private static final String IMG_NAME = "heart";

    public Heart(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();

        addToBot(new ApplyPowerAction(owner, owner, new DexterityPower(owner, amount / 3)));
        addToBot(new ApplyPowerAction(owner, owner, new LoseDexterityPower(owner, amount / 3)));

        this.flash();
    }
}
