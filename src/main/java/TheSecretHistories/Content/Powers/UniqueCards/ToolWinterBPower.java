package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Forge;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolWinterBPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolWinterBPower.class.getSimpleName());

    private static final String IMG_NAME = "toolwinterb";

    public ToolWinterBPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
