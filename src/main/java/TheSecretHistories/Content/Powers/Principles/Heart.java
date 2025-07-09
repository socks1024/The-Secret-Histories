package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Heart extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Heart.class.getSimpleName());
    private static final String IMG_NAME = "heart";

    public Heart(AbstractCreature owner, int Amount){
        super(POWER_ID, IMG_NAME);

        this.owner = owner;
        this.amount = Amount;
    }
}
