package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class SecretHistories extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(SecretHistories.class.getSimpleName());
    private static final String IMG_NAME = "secrethistories";

    public SecretHistories(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
