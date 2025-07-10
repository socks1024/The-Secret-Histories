package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Edge;
import TheSecretHistories.Content.Powers.Principles.Forge;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolEdgeDPower extends TemplateCustomPower {

    public static final String ID = StringUtils.MakeID(ToolEdgeDPower.class.getSimpleName());

    private static final String IMG_NAME = "tooledged";

    public ToolEdgeDPower(AbstractCreature owner, int amount) {
        super(ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        int edge = owner.getPower(Edge.POWER_ID).amount;

        if (isPlayer) {
            owner.loseBlock(edge);
            this.amount = 0;
        }
    }
}
