package TheSecretHistories.Content.Cards.Rites.NormalRites;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Rites.AbstractNormalRite;
import TheSecretHistories.Content.Powers.UniqueCards.GainEnergyAtStartOfTurnPower;
import TheSecretHistories.Utils.PrincipleUtils.ReducePrincipleInfo;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class RiteToolConsumeIngredient extends AbstractNormalRite {

    public static final String ID = StringUtils.MakeID(RiteToolConsumeIngredient.class.getSimpleName());

    private static final String IMG_NAME = "ritetoolconsumeingredient";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    private static final ReducePrincipleInfo[] INFOS = new ReducePrincipleInfo[]{
            new ReducePrincipleInfo(MOTH, 12),
            new ReducePrincipleInfo(EDGE, 8)
    };

    public RiteToolConsumeIngredient() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);

        this.baseMagicNumber = 99;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.target = CardTarget.ALL_ENEMY;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ConsumePrincipleAction(p, INFOS) {
            @Override
            protected void OnConsumedEnough(int consumedAmount) {

                if (!upgraded) {
                    applydebuff(p, m);
                } else {
                    for (AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
                        applydebuff(p, mo);
                    }
                }
            }
        });
    }

    private void applydebuff(AbstractCreature source, AbstractCreature target) {
        AbstractDungeon.actionManager.addToBottom(
            new ApplyPowerAction(target, AbstractDungeon.player, new VulnerablePower(target, 99, false), 99)
    );
        AbstractDungeon.actionManager.addToBottom(
                new ApplyPowerAction(target, AbstractDungeon.player, new WeakPower(target, 99, false), 99)
        );
    }
}
