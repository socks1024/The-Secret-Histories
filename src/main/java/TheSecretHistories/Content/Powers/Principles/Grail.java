package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.ApplyRandomDebuffToRandomEnemyAction;
import TheSecretHistories.Utils.DebugUtils;
import TheSecretHistories.Utils.StringUtils;
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

public class Grail extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Grail.class.getSimpleName());
    private static final String IMG_NAME = "grail";

    public Grail(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();

        addToBot(new ApplyRandomDebuffToRandomEnemyAction(amount / 5, owner));

        this.flash();
    }
}
