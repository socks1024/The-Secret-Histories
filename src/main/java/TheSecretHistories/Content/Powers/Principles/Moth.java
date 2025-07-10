package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Moth extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Moth.class.getSimpleName());
    private static final String IMG_NAME = "moth";

    public Moth(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);

        this.stack = true;
    }
}
