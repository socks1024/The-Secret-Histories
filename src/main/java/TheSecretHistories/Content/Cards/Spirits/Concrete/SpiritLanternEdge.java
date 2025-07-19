package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Actions.UniqueCards.DrawFullAndDamageAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritLanternEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritLanternEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_lanternc_edge";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
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
