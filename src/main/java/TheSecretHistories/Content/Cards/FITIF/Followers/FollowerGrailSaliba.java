package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.unique.VampireDamageAction;
import com.megacrit.cardcrawl.actions.unique.VampireDamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class FollowerGrailSaliba extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerGrailSaliba.class.getSimpleName());
    private static final String IMG_NAME = "saliba_a";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.ATTACK;
    public static CardTags PRINCIPLE_TAG = GRAIL;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public FollowerGrailSaliba() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.damage = this.baseDamage = 6;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new VampireDamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.NONE));
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