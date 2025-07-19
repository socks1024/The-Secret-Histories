package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Cards.Spirits.GrailEdge.SpiritForgeMoth;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Spirit_GrailC_MothPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(IngredientWinterBPower.class.getSimpleName());

    private static final String IMG_NAME = "spirit_forgee_edge";
    public Spirit_GrailC_MothPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.amount = amount;
    }


    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        flash();
        addToBot(new LoseHPAction(this.owner, null, this.amount));
    }

}

