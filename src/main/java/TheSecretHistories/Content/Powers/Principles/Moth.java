package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Powers.UniqueCards.ToolMothDPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Moth extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Moth.class.getSimpleName());
    private static final String IMG_NAME = "moth";

    public Moth(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);

        this.stack = true;
    }

    @Override
    public void stackPower(int stackAmount) {
        stackAmount += PowerUtils.GetPowerAmount(ToolMothDPower.POWER_ID, owner);

        super.stackPower(stackAmount);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        addToTop(new RemoveSpecificPowerAction(owner, owner, POWER_ID));
    }
}
