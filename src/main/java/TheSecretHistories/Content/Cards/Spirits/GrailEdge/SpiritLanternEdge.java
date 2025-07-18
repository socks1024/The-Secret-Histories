package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Actions.UniqueCards.DrawFullAndDamageAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.unique.ExpertiseAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritLanternEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritLanternEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_lanternc_edge";
    private static final int COST = 3;
    private static final CardType TYPE = CardType.POWER;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(LANTERN, 12),
            new PrincipleUtils.ReducePrincipleInfo(EDGE, 4),
    };

    public SpiritLanternEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.baseMagicNumber = this.magicNumber = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            addToBot(new DrawFullAndDamageAction(p, this.magicNumber));
    }
}
