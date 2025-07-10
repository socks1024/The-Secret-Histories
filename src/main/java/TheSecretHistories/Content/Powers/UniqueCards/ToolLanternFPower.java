package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Actions.UniqueCards.ToolLanternFAction;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolLanternFPower extends TemplateCustomPower {

    public static final String ID = StringUtils.MakeID(ToolLanternFPower.class.getSimpleName());

    private static final String IMG_NAME = "toollanternf";

    public ToolLanternFPower(AbstractCreature owner, int amount) {
        super(ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();
        addToBot(new ToolLanternFAction(owner, amount));
    }

    @Override
    public void stackPower(int stackAmount) {
        if (stackAmount < amount) reducePower(amount - stackAmount);
    }
}
