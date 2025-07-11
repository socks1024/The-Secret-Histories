package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Actions.UniqueCards.GainBlockBasedOnEnemyWinterAction;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolWinterFPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolWinterFPower.class.getSimpleName());

    private static final String IMG_NAME = "toolwinterf";

    public ToolWinterFPower(AbstractCreature owner) {
        super(POWER_ID, IMG_NAME, owner, -1);
    }

    @Override
    public void atEndOfRound() {
        super.atEndOfRound();

        addToBot(new GainBlockBasedOnEnemyWinterAction(owner));
    }
}
