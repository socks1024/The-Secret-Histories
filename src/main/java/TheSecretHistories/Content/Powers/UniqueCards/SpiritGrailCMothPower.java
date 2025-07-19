package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class SpiritGrailCMothPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(SpiritGrailCMothPower.class.getSimpleName());

    private static final String IMG_NAME = "spirit_grailc_moth";
    public SpiritGrailCMothPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.amount = amount;
    }


    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        flash();
        addToBot(new LoseHPAction(this.owner, null, this.amount));
    }

}

