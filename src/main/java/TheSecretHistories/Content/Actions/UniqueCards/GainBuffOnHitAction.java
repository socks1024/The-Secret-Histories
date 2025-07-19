package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class GainBuffOnHitAction  extends AbstractGameAction {
    private final AbstractCreature source;
    private final DamageInfo info;

    public GainBuffOnHitAction(AbstractCreature target, AbstractCreature source, DamageInfo info) {
        this.setValues(target, source, info.base);
        this.source = source;
        this.info = info;
        this.actionType = ActionType.DAMAGE;
    }

    @Override
    public void update() {
        if (target instanceof AbstractMonster && !target.isDeadOrEscaped()) {
            target.damage(info);

            int actualDamage = ((AbstractMonster) target).lastDamageTaken;
            if (actualDamage > 0) {
                addToTop(new ApplyPowerAction(source, source, new StrengthPower(source, actualDamage)));
                addToTop(new ApplyPowerAction(source, source, new DexterityPower(source, actualDamage)));
            }
        }

        isDone = true;
    }
}
