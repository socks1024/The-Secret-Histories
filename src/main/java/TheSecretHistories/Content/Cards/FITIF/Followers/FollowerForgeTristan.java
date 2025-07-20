package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class FollowerForgeTristan extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerForgeTristan.class.getSimpleName());
    private static final String IMG_NAME = "tristan_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    public static CardTags PRINCIPLE_TAG = FORGE;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    public FollowerForgeTristan() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 17;
        this.magicNumber=this.baseMagicNumber=7;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        if (AbstractDungeon.player.gold >= magicNumber) {
            AbstractDungeon.player.loseGold(magicNumber);
        } else {
            return;
        }

        addToBot(new DamageAllEnemiesAction(
                p,
                DamageInfo.createDamageMatrix(damage, true),
                DamageInfo.DamageType.NORMAL,
                AbstractGameAction.AttackEffect.FIRE
        ));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(7);
    }

}
/*private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());

    private static final String IMG_NAME = "elridge";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;*/