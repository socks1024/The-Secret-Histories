package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Moth;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class DamageByMothAction extends AbstractGameAction {

    private int extraDamage;

    public DamageByMothAction(AbstractCreature target, AbstractCreature source, int extraDamage) {
        this.target = target;
        this.source = source;

        this.extraDamage = extraDamage;
    }

    @Override
    public void update() {
        int mothAmount = source.hasPower(Moth.POWER_ID) ? source.getPower(Moth.POWER_ID).amount : 0;

        addToTop(new DamageAction(target, new DamageInfo(source, mothAmount + extraDamage)));

        isDone = true;
    }
}
