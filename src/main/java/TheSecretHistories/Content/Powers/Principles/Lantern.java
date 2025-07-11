package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Lantern extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Lantern.class.getSimpleName());
    private static final String IMG_NAME = "lantern";

    public Lantern(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
