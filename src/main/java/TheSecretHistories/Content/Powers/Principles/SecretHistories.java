package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class SecretHistories extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(SecretHistories.class.getSimpleName());
    private static final String IMG_NAME = "secrethistories";

    public SecretHistories(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void onVictory(){
        super.onVictory();
        addMoreThingsToRewards(this.amount);
    }

    public static void addMoreThingsToRewards(int amount){
        for (int i = 0;i<amount;i++){
            AbstractDungeon.getCurrRoom().addGoldToRewards(3);
        }
    }
}
