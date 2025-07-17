package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritGrailEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritGrailEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_graile_edge";
    private static final int COST = 3;
    private static final CardType TYPE = CardType.POWER;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(GRAIL, 15),
            new PrincipleUtils.ReducePrincipleInfo(FORGE, 8),
    };

    public SpiritGrailEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new GainBlockAction(abstractPlayer, 999));
    }
}
