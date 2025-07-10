package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Grail extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Grail.class.getSimpleName());
    private static final String IMG_NAME = "grail";

    public Grail(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
