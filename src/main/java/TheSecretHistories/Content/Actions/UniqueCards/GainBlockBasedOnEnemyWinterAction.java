package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Winter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class GainBlockBasedOnEnemyWinterAction extends AbstractGameAction {

    public GainBlockBasedOnEnemyWinterAction(AbstractCreature source) {
        this.source = source;
    }

    @Override
    public void update() {

        int totalWinter = 0;

        int temp = (AbstractDungeon.getCurrRoom()).monsters.monsters.size();
        for (int i = 0; i < temp; i++) {
            AbstractMonster m = (AbstractDungeon.getCurrRoom()).monsters.monsters.get(i);
            if (!m.isDeadOrEscaped()) {
                totalWinter += m.hasPower(Winter.POWER_ID) ? m.getPower(Winter.POWER_ID).amount : 0;
            }
        }

        addToTop(new GainBlockAction(source, totalWinter));

        this.isDone = true;
    }

}
