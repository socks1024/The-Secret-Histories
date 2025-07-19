package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientMothFToWinterAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritWinterMoth extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritWinterMoth.class.getSimpleName());
    private static final String IMG_NAME = "spirit_winterb_heart";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(WINTER, 8),
            new PrincipleUtils.ReducePrincipleInfo(HEART, 2),
    };

    public SpiritWinterMoth() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.hasPower(Moth.POWER_ID)) {
            int currentAmount = p.getPower(Moth.POWER_ID).amount;
            if (currentAmount > 0) {
                addToBot(new IngredientMothFToWinterAction(m, p, MOTH, 1, this.magicNumber));
            }
        }
    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

}
