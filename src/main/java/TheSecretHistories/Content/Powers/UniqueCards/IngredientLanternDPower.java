package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class IngredientLanternDPower extends TemplateCustomPower {
    public static final String POWER_ID = StringUtils.MakeID(IngredientLanternDPower.class.getSimpleName());
    private static final String IMG_NAME = "ingredientlanternd";
    public IngredientLanternDPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.type = PowerType.BUFF;
    }
    private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;

    @Override
    public void onAfterUseCard(AbstractCard card, UseCardAction action) {
        this.amount = amount;
        if (card.type == TYPE) {
            addToBot(new DrawCardAction(AbstractDungeon.player,amount));
        }
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        addToTop(new RemoveSpecificPowerAction(owner, owner, POWER_ID));
    }
}

