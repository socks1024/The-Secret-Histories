package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Utils.DebugUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import java.util.ArrayList;
import java.util.Random;

public class ApplyRandomDebuffToRandomEnemyAction extends AbstractGameAction {

    public ApplyRandomDebuffToRandomEnemyAction(int amount, AbstractCreature source) {
        this.amount = amount;
        this.source = source;
    }

    @Override
    public void update() {
        ArrayList<AbstractMonster> monsters = AbstractDungeon.getCurrRoom().monsters.monsters;
        for (int i = 0; i < amount; i++) {
            int roll = AbstractDungeon.miscRng.random(2);
            AbstractMonster rmo = monsters.get(new Random().nextInt(monsters.size()));
            switch (roll) {
                case 0:
                    addToTop(new ApplyPowerAction(rmo, source, new StrengthPower(rmo, -1)));
                    break;
                case 1:
                    addToTop(new ApplyPowerAction(rmo, source, new WeakPower(rmo, 1, false)));
                    break;
                case 2:
                    addToTop(new ApplyPowerAction(rmo, source, new VulnerablePower(rmo, 1, false)));
                    break;
            }
        }
        isDone = true;
    }
}
