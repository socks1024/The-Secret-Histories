package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Content.Powers.UniqueCards.FollowerKnockNPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class FollowerKnockNeville extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerKnockNeville.class.getSimpleName());
    private static final String IMG_NAME = "neville_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    public static CardTags PRINCIPLE_TAG = KNOCK;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public FollowerKnockNeville() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseDamage = this.damage = 7;
        this.baseMagicNumber = this.magicNumber = 2;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        addToBot(new DamageAction(m, new DamageInfo(p, damage), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new ApplyPowerAction(p, p, new FollowerKnockNPower(p, magicNumber)));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(3);
        upgradeMagicNumber(1);
    }
}
//TODO 1