package TheSecretHistories.Content.Cards.Rites.NormalRites;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Rites.AbstractNormalRite;
import TheSecretHistories.Utils.PrincipleUtils.ReducePrincipleInfo;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;

import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class RiteToolConsumeFollower extends AbstractNormalRite {

    public static final String ID = StringUtils.MakeID(RiteToolConsumeFollower.class.getSimpleName());

    private static final String IMG_NAME = "ritetoolconsumefollower";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.NONE;

    private static final ReducePrincipleInfo[] INFOS = new ReducePrincipleInfo[]{
            new ReducePrincipleInfo(FORGE, 12),
            new ReducePrincipleInfo(GRAIL, 8)

    };

    public RiteToolConsumeFollower() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.magicNumber = this.baseMagicNumber = 4;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ConsumePrincipleAction(p, INFOS) {
            @Override
            protected void OnConsumedEnough(int consumedAmount) {
                AbstractDungeon.player.increaseMaxHp(baseMagicNumber, true);
                isDone=true;
            }
        });
    }
    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.selfRetain = true;
        upgradeMagicNumber(2);
    }


}
