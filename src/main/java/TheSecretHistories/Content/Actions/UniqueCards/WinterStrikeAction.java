package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Winter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

public class WinterStrikeAction extends AbstractGameAction {
    private final AbstractCreature source;
    private final int baseDamage;
    private final DamageInfo.DamageType damageType;

    public WinterStrikeAction(AbstractCreature source, int baseDamage, DamageInfo.DamageType damageType) {
        this.source = source;
        this.baseDamage = baseDamage;
        this.damageType = damageType;
        this.actionType = ActionType.DAMAGE;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            int[] damageMatrix = DamageInfo.createDamageMatrix(baseDamage, true);
            ArrayList<AbstractMonster> monsters = AbstractDungeon.getCurrRoom().monsters.monsters;

            for (int i = 0; i < monsters.size(); i++) {
                AbstractMonster m = monsters.get(i);
                if (!m.isDeadOrEscaped()) {
                    int damage = damageMatrix[i];
                    DamageInfo info = new DamageInfo(source, damage, damageType);
                    m.damage(info);

                    int actualDamage = m.lastDamageTaken;
                    if (actualDamage > 0) {
                        addToTop(new ApplyPowerAction(m, source, new Winter(m, actualDamage)));
                    }
                }
            }

            if (!Settings.FAST_MODE) {
                addToTop(new WaitAction(0.1F));
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }

            this.isDone = true;
        }

        tickDuration();
    }

}
