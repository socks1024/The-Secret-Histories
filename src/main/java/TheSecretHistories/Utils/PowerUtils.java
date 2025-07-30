package TheSecretHistories.Utils;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class PowerUtils {

    public static int GetPowerAmount(String powerID, AbstractCreature target) {
        return target.hasPower(powerID) ? target.getPower(powerID).amount : 0;
    }

    public static void ReducePowerAmount(AbstractPower p, int amount, AbstractCreature source) {
        if (p.amount <= amount){
            AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(p.owner, source, p));
        } else {
            p.amount -= amount;
        }
    }
}
