package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class SecretHistories extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(SecretHistories.class.getSimpleName());
    private static final String IMG_NAME = "secrethistories";

    private static final int GOLD = 5;

    public SecretHistories(AbstractCreature owner, int Amount){
        super(POWER_ID, IMG_NAME);

        this.owner = owner;
        this.amount = Amount;

        this.stack = true;
    }

    public void onVictory(){
        super.onVictory();
        AddMoreThingsToReward(this.amount);
    }

    public void AddMoreThingsToReward(int amount){

        for (int i = 0; i < amount; i++){
            AbstractDungeon.getCurrRoom().addGoldToRewards(GOLD);
        }

//        for (int i = 0; i < (amount / 6); i++)
//        {
//            AbstractDungeon.getCurrRoom().addCardToRewards();
//        }
    }
}
