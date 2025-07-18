package TheSecretHistories.Content.Cards.Rites.NormalRites;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Rites.AbstractNormalRite;
import TheSecretHistories.Utils.PrincipleUtils.ReducePrincipleInfo;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class RiteFollowerConsumeInfluence extends AbstractNormalRite {

    public static final String ID = StringUtils.MakeID(RiteFollowerConsumeInfluence.class.getSimpleName());

    private static final String IMG_NAME = "ritefollowerconsumeinfluence";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.NONE;

    private static final ReducePrincipleInfo[] INFOS = new ReducePrincipleInfo[]{
        new ReducePrincipleInfo(WINTER, 12),
        new ReducePrincipleInfo(LANTERN, 8)
    };

    public RiteFollowerConsumeInfluence() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);

        this.damage = this.baseDamage = 50;

        this.magicNumber = this.baseMagicNumber = 5;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(30);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ConsumePrincipleAction(abstractPlayer, INFOS) {
            @Override
            protected void OnConsumedEnough(int consumedAmount) {
                if (new Random().nextFloat() < (float) magicNumber / 100) {
                    addToTop(new DamageAction(abstractPlayer, new DamageInfo(abstractPlayer, damage), AttackEffect.BLUNT_HEAVY));
                } else {
                    addToTop(new DamageRandomEnemyAction(new DamageInfo(abstractPlayer, damage), AttackEffect.BLUNT_HEAVY));
                }
            }
        });
    }
}
