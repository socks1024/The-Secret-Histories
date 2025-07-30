package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientLartenPrincipleAction;
import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientWinterPrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Content.Powers.UniqueCards.SimpleDrawReductionPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawReductionPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FollowerLanternClifton extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerLanternClifton.class.getSimpleName());
    private static final String IMG_NAME = "clifton_a";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.ATTACK;
    public static CardTags PRINCIPLE_TAG = LANTERN;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

   // private static final int REDUCE = 2;

    public FollowerLanternClifton() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 2;
        this.baseDamage=this.damage=23;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new DamageAction(m, new DamageInfo(p, damage)));
        //addToBot(new IngredientLartenPrincipleAction(m, p, PRINCIPLE_TAG, magicNumber, 1));
        addToBot(new ApplyPowerAction(
                p,
                p,
                new SimpleDrawReductionPower(p, magicNumber),
                1
        ));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeDamage(8);
    }

}
//降费，稀有度拉高