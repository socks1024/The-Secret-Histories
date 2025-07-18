package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class SecretHistories extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(SecretHistories.class.getSimpleName());
    private static final String IMG_NAME = "secrethistories";

    public SecretHistories(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void updateDescription() {
        String newDescription = powerStrings.DESCRIPTIONS[0] + String.format(powerStrings.DESCRIPTIONS[1], 3 * amount);

        if (amount >= 6) newDescription += String.format(powerStrings.DESCRIPTIONS[2], amount / 6);

        if (amount >= 14) newDescription += String.format(powerStrings.DESCRIPTIONS[3], 1);

        this.description = newDescription;
    }

    @Override
    public void onVictory(){
        super.onVictory();
        addMoreThingsToRewards(this.amount);
    }

    public static void addMoreThingsToRewards(int amount){
        AbstractDungeon.getCurrRoom().addGoldToRewards(3 * amount);

        for (int i = 0; i < amount / 6; i++) {
            AbstractDungeon.getCurrRoom().addCardToRewards();
        }

        if (amount >= 14) AbstractDungeon.getCurrRoom().addRelicToRewards(AbstractRelic.RelicTier.COMMON);
    }
}
