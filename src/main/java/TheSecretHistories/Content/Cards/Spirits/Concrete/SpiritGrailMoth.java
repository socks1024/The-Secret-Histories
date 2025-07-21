package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.UniqueCards.SpiritGrailCMothPower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritGrailMoth extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritGrailMoth.class.getSimpleName());
    private static final String IMG_NAME = "spirit_grailc_moth";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(GRAIL, 10),
            new PrincipleUtils.ReducePrincipleInfo(MOTH, 4),
    };

    public SpiritGrailMoth() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.baseMagicNumber = this.magicNumber=5;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(m, p, new SpiritGrailCMothPower(m, magicNumber)));
    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(3);
    }

}
