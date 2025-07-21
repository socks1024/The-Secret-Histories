package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
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
            new PrincipleUtils.ReducePrincipleInfo(FORGE, 14),
            new PrincipleUtils.ReducePrincipleInfo(LANTERN, 6),
    };

    public SpiritForgeEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.exhaust = true;

        this.magicNumber = this.baseMagicNumber = 4;
        this.damage = this.baseDamage = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int energy = AbstractDungeon.actionManager.cardQueue.get(0).energyOnUse;

        baseDamage = (int)Math.pow(magicNumber, energy);

        calculateDamageDisplay(m);

        addToBot(new DamageAllEnemiesAction(p, damage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

}
