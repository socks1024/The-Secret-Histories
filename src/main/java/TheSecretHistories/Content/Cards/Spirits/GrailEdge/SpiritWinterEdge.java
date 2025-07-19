package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Actions.UniqueCards.MirrorStrikeAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.UniqueCards.Spirit_ForgeC_WinterPower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritWinterEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritWinterEdge.class.getSimpleName());
    private static final String IMG_NAME = "spirit_winterd_edge";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(EDGE, 6),
            new PrincipleUtils.ReducePrincipleInfo(WINTER, 14),
    };

    public SpiritWinterEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MirrorStrikeAction(m, this, timesUpgraded));

    }


    @Override
    public void OnUpgrade(int timesUpgraded) {
        upgradeDamage(3);
    }

}
