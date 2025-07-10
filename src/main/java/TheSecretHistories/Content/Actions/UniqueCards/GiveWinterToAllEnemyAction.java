package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GiveWinterToAllEnemyAction extends AbstractGameAction {

    private int basedamage;

    public GiveWinterToAllEnemyAction(AbstractCreature source, int baseDamage, DamageInfo.DamageType type, AbstractGameAction.AttackEffect effect) {
        this.source = source;
        this.basedamage = baseDamage;
    }

    @Override
    public void update() {
        int temp = (AbstractDungeon.getCurrRoom()).monsters.monsters.size();
        for (int i = 0; i < temp; i++) {
            if (!(AbstractDungeon.getCurrRoom().monsters.monsters.get(i)).isDeadOrEscaped()) {
                ((AbstractDungeon.getCurrRoom()).monsters.monsters.get(i)).damage(new DamageInfo(this.source, this.basedamage, this.damageType));
            }
        }

        this.isDone = true;
    }

}
