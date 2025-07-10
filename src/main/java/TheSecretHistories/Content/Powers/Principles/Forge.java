package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Forge extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Forge.class.getSimpleName());
    private static final String IMG_NAME = "forge";

    public Forge(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
