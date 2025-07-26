package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class FollowerHeartLeo extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerHeartLeo.class.getSimpleName());
    private static final String IMG_NAME = "leo_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    public static CardTags PRINCIPLE_TAG = HEART;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public FollowerHeartLeo() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseDamage = 0;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        this.baseDamage = p.currentBlock;
        calculateDamageDisplay(m);
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }

    @Override
    protected void PreApplyPowers() {
        super.PreApplyPowers();
        this.baseDamage = AbstractDungeon.player.currentBlock;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        this.selfRetain = true;
    }
}