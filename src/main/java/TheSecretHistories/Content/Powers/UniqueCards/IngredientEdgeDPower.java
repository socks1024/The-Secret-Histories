package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Edge;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class IngredientEdgeDPower extends TemplateCustomPower {
    public static final String POWER_ID = StringUtils.MakeID(IngredientEdgeDPower.class.getSimpleName());
    private static final String IMG_NAME = "ingredientedged";
    private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;

    public IngredientEdgeDPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.type = PowerType.BUFF;
    }

    @Override
    public void onAfterUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == TYPE) {
            flash();
            addToBot(new ApplyPowerAction(owner, owner,new Edge(owner, amount)));
        }
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);
        addToTop(new RemoveSpecificPowerAction(owner, owner, POWER_ID));
    }
}

