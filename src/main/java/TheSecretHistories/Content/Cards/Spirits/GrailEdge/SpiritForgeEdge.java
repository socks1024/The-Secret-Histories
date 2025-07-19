package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Actions.UniqueCards.MirrorStrikeAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritForgeEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritForgeEdge.class.getSimpleName());
    private static final String IMG_NAME = "spirit_forgee_edge";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(EDGE, 6),
            new PrincipleUtils.ReducePrincipleInfo(WINTER, 14),
    };

    public SpiritForgeEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.exhaust = true;
        this.baseDamage = 15;
        this.isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int enemyCount = 0;

        for (AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
            if (!mo.isDeadOrEscaped()) {
                enemyCount++;
            }
        }

        addToBot(new DamageAllEnemiesAction(p, this.multiDamage,
                this.damageTypeForTurn, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        if (enemyCount > 0) {
            addToBot(new GainEnergyAction(enemyCount));
        }
    }



    @Override
    public void OnUpgrade(int timesUpgraded) {
        upgradeDamage(10);
    }

}
