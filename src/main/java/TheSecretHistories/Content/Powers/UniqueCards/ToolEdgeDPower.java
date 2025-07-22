package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Edge;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolEdgeDPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolEdgeDPower.class.getSimpleName());

    private static final String IMG_NAME = "tooledged";

    public ToolEdgeDPower(AbstractCreature owner) {
        super(POWER_ID, IMG_NAME, owner, -1);

        this.type = PowerType.DEBUFF;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        int edge = owner.getPower(Edge.POWER_ID).amount;

        if (isPlayer) {
            owner.loseBlock(edge);

            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
        }
    }
}
