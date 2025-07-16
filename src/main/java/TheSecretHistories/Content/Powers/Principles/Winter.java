package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Powers.UniqueCards.ToolWinterBPower;
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

        if (!owner.hasPower(ToolWinterBPower.POWER_ID)) addToBot(new DamageAction(owner, new DamageInfo(owner, amount)));
    }

    // TODO 敌人无法受到冬伤害
}
