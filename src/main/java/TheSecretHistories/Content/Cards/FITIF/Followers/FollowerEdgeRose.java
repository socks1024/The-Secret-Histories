package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.EdgeAction2;
import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.HeartPrincipleAction;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class FollowerEdgeRose extends AbstractFollower {
    private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeRose.class.getSimpleName());

    private static final String IMG_NAME = "rose_a";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.SKILL;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;

    private static final CardTarget TARGET = CardTarget.SELF;

    public FollowerEdgeRose() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.baseMagicNumber = this.magicNumber = 5;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new EdgeAction2(m, p, PRINCIPLE_TAG, magicNumber));
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