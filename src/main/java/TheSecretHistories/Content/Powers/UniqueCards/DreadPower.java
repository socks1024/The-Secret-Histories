package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class DreadPower extends TemplateCustomPower {

    public static final String ID = StringUtils.MakeID(DreadPower.class.getSimpleName());

    private static final String IMG_NAME = "edge";

    public DreadPower(AbstractCreature owner, int amount) {
        super(ID, IMG_NAME, owner, amount);

        if (owner.hasPower(FascinationPower.ID)) {
            addToTop(new RemoveSpecificPowerAction(owner, owner, this));
            addToTop(new RemoveSpecificPowerAction(owner, owner, FascinationPower.ID));
        }
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();

        addToBot(new ApplyPowerAction(owner, owner, new StrengthPower(owner, -this.amount), -this.amount, true, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(owner, owner, new GainStrengthPower(owner, this.amount), this.amount, true, AbstractGameAction.AttackEffect.NONE));
    }
}
