package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Actions.Principle.GainPrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Winter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class GiveWinterToAllEnemyAction extends AbstractGameAction {

    private final int winterAmount;

    public GiveWinterToAllEnemyAction(AbstractCreature source, int winterAmount) {
        this.source = source;
        this.winterAmount = winterAmount;
    }

    @Override
    public void update() {
        ArrayList<AbstractMonster> monsters = (AbstractDungeon.getCurrRoom()).monsters.monsters;
        for (AbstractMonster monster : monsters) {
            if (!monster.isDeadOrEscaped()) {
                addToTop(new ApplyPowerAction(monster, source, new Winter(monster, winterAmount)));
            }
        }

        this.isDone = true;
    }

}
