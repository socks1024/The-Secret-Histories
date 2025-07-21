package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.GrailFAction2;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class FollowerGrailRenira extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerGrailRenira.class.getSimpleName());
    private static final String IMG_NAME = "renira_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = GRAIL;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public FollowerGrailRenira() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 4;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new GrailFAction2(m, p, PRINCIPLE_TAG, magicNumber));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeMagicNumber(-1);
    }
}
/*private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());

    private static final String IMG_NAME = "elridge";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;*/