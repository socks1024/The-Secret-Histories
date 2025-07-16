package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Forge;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.DebugUtils;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolForgeBPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolForgeBPower.class.getSimpleName());

    private static final String IMG_NAME = "toolforgeb";

    public ToolForgeBPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if(card.type == AbstractCard.CardType.STATUS && PowerUtils.GetPowerAmount(Forge.POWER_ID, owner) >= this.amount){
            this.flash();
            card.exhaust = true;
            action.exhaustCard = true;
        }
    }

    @Override
    public void stackPower(int stackAmount) {
        if (stackAmount < amount) reducePower(amount - stackAmount);
    }
}
