package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import basemod.BaseMod;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class IngredientLanternFPower extends TemplateCustomPower {
    public static final String POWER_ID = StringUtils.MakeID(IngredientLanternFPower.class.getSimpleName());
    private static final String IMG_NAME = "ingredientlanternf";

    public IngredientLanternFPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.type = PowerType.BUFF;
    }
    public void onInitialApplication() {
        BaseMod.MAX_HAND_SIZE = 999;
    }

    @Override
    public void onRemove() {
        super.onRemove();
        BaseMod.MAX_HAND_SIZE = 10;
    }
}
