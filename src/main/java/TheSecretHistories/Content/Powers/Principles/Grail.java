package TheSecretHistories.Content.Powers.Principles;

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

        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                ArrayList<AbstractMonster> monsters = AbstractDungeon.getCurrRoom().monsters.monsters;
                for (int i = 0; i < amount / 5; i++) {
                    int roll = AbstractDungeon.miscRng.random(2);
                    AbstractMonster rmo = monsters.get(new Random().nextInt(monsters.size()));
                    switch (roll) {
                        case 0:
                            addToTop(new ApplyPowerAction(rmo, owner, new StrengthPower(rmo, -1)));
                            break;
                        case 1:
                            addToTop(new ApplyPowerAction(rmo, owner, new WeakPower(rmo, 1, false)));
                            break;
                        case 2:
                            addToTop(new ApplyPowerAction(rmo, owner, new VulnerablePower(rmo, 1, false)));
                            break;
                    }
                }
                isDone = true;
            }
        });

        this.flash();
    }
}
