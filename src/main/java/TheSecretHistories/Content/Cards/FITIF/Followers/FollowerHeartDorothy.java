package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class FollowerHeartDorothy extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerHeartDorothy.class.getSimpleName());
    private static final String IMG_NAME = "dorothy_a";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = HEART;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    public FollowerHeartDorothy() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int blockAmount = p.currentBlock;
        addToBot(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, blockAmount), blockAmount));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
            upgradeBaseCost(0);
    }

}
/*private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());

    private static final String IMG_NAME = "elridge";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;*/