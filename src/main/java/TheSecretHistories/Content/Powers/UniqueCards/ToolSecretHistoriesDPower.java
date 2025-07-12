package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ToolSecretHistoriesDPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolSecretHistoriesDPower.class.getSimpleName());

    private static final String IMG_NAME = "toolsecrethistoriesd";

    public ToolSecretHistoriesDPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);

        this.amount = amount;

        this.type = PowerType.BUFF;
    }
}
