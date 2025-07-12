package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Powers.UniqueCards.ToolMothDPower;
import TheSecretHistories.Utils.StringUtils;
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
        super.stackPower(stackAmount);

        if (owner.hasPower(ToolMothDPower.POWER_ID)) {
            amount += owner.getPower(ToolMothDPower.POWER_ID).amount;
        }
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        amount = 0;
    }
}
