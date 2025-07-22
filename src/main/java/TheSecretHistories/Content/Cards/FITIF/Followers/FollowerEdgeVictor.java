package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class FollowerEdgeVictor extends AbstractFollower{
    public static CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeVictor.class.getSimpleName());

    private static final String IMG_NAME = "victor_a";

    private static final int COST = 2;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;
    public FollowerEdgeVictor() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 20;
        this.magicNumber=this.baseMagicNumber=2;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, -magicNumber), -magicNumber));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
            upgradeDamage(8);
    }
}
/*private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());

    private static final String IMG_NAME = "elridge";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;*/