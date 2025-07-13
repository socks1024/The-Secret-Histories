package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Actions.Principle.GainPrincipleAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
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
        for (int i = 0; i < monsters.size(); i++) {
            if (!monsters.get(i).isDeadOrEscaped()) {
                addToTop(new GainPrincipleAction((monsters.get(i)), WINTER, winterAmount));
            }
        }

        this.isDone = true;
    }

}
