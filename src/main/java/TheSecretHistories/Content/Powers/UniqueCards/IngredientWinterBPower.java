package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class IngredientWinterBPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(IngredientWinterBPower.class.getSimpleName());

    private static final String IMG_NAME = "toolwinterb";

    public IngredientWinterBPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
