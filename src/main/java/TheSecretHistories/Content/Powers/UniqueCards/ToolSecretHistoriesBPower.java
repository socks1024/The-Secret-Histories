package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ToolSecretHistoriesBPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolSecretHistoriesBPower.class.getSimpleName());

    private static final String IMG_NAME = "secrethistories";

    public ToolSecretHistoriesBPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);

        this.amount = amount;

        this.type = PowerType.BUFF;
    }

    @Override
    public void onVictory() {
        super.onVictory();

        for (int i = 0; i < amount; i++) {
            AbstractDungeon.getCurrRoom().addCardToRewards();
        }
    }
}
