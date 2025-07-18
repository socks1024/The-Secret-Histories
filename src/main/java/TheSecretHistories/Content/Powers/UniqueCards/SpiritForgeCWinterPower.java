package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Cards.Spirits.Concrete.SpiritForgeMoth;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class SpiritForgeCWinterPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(SpiritForgeCWinterPower.class.getSimpleName());

    private static final String IMG_NAME = "spirit_forgec_winter";
    private int timesUpgraded;
    public SpiritForgeCWinterPower(AbstractCreature owner, int amount, int timesUpgraded) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.amount = amount;
        this.timesUpgraded = timesUpgraded;
    }


    @Override
    public void onExhaust(AbstractCard card) {
        //AbstractCard newCard = new SpiritForgeMoth().makeStatEquivalentCopy();
        AbstractCard newCard = new SpiritForgeMoth();
        if(timesUpgraded>0) {
            newCard.upgrade();
        }
        addToTop(new MakeTempCardInHandAction(newCard, this.amount));
        addToBot(new RemoveSpecificPowerAction(owner, owner, this));
    }

}

