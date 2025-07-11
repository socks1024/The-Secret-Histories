package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Winter extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Winter.class.getSimpleName());
    private static final String IMG_NAME = "winter";

    public Winter(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        addToBot(new DamageAction(owner, new DamageInfo(owner, amount)));
    }
}
