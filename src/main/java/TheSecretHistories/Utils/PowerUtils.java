package TheSecretHistories.Utils;

import com.megacrit.cardcrawl.core.AbstractCreature;

public class PowerUtils {

    public static int GetPowerAmount(String powerID, AbstractCreature target) {
        return target.hasPower(powerID) ? target.getPower(powerID).amount : 0;
    }
}
