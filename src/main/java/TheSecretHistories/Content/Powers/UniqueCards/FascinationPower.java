package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class FascinationPower extends TemplateCustomPower {

    public static final String ID = StringUtils.MakeID(FascinationPower.class.getSimpleName());

    private static final String IMG_NAME = "moth";

    public FascinationPower(AbstractCreature owner, int amount) {
        super(ID, IMG_NAME, owner, amount);

        if (owner.hasPower(DreadPower.ID)) {
            addToTop(new RemoveSpecificPowerAction(owner, owner, this));
            addToTop(new RemoveSpecificPowerAction(owner, owner, DreadPower.ID));
        }
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();

        addToBot(new ApplyPowerAction(owner, owner, new DexterityPower(owner, -this.amount), -this.amount, true, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(owner, owner, new GainDexterityPower(owner, this.amount), this.amount, true, AbstractGameAction.AttackEffect.NONE));
    }
}
