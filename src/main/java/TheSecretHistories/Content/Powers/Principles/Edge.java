package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Edge extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Edge.class.getSimpleName());
    private static final String IMG_NAME = "edge";

    public Edge(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();

        addToBot(new ApplyPowerAction(owner, owner, new StrengthPower(owner, amount / 3)));
        addToBot(new ApplyPowerAction(owner, owner, new LoseStrengthPower(owner, amount / 3)));
    }
}
