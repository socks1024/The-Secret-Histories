package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Actions.UniqueCards.GainBuffOnHitAction;
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
import static java.awt.SystemColor.info;

public class SpiritHeartEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritHeartEdge.class.getSimpleName());
    private static final String IMG_NAME = "spirit_heartc_edge";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(HEART, 12),
            new PrincipleUtils.ReducePrincipleInfo(EDGE, 4),
    };

    public SpiritHeartEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.damage = this.baseDamage=2;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage)));
        addToBot(new GainBuffOnHitAction(m, p, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        upgradeDamage(1);
    }

}
