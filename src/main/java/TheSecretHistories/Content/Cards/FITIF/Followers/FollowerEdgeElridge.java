package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.BetterDrawPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.HandCheckAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class FollowerEdgeElridge extends AbstractFollower{
    private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());

    private static final String IMG_NAME = "elridge_a";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;

    public FollowerEdgeElridge() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 8;
        this.magicNumber = this.baseMagicNumber=1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new DamageAction(m, new DamageInfo(p, damage)));
        addToBot(new BetterDrawPileToHandAction(this.magicNumber));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeDamage(3);
    }
}



/*private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());

    private static final String IMG_NAME = "elridge";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;*/