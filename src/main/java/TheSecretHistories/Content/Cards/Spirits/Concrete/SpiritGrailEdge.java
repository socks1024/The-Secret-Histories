package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.UniqueCards.Spirit_GrailE_EdgePower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritGrailEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritGrailEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_graile_edge";
    private static final int COST = -1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(GRAIL, 14),
            new PrincipleUtils.ReducePrincipleInfo(FORGE, 6),
    };

    public SpiritGrailEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.exhaust = true;
        this.baseMagicNumber = this.magicNumber = 0;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        //addToBot(new UseXAction(p, this.freeToPlayOnce));
        int energy = AbstractDungeon.actionManager.cardQueue.get(0).energyOnUse;
        if (this.upgraded) energy += 1;
        if (p.hasRelic("Chemical X")) {
            energy += 2;
            p.getRelic("Chemical X").flash();
        }
        if (energy > 0) {

            addToBot(new ApplyPowerAction(m, p, new Spirit_GrailE_EdgePower(m, energy), energy));
        }
        p.energy.use(EnergyPanel.totalCount);
    }

    public void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(3);
    }
}
