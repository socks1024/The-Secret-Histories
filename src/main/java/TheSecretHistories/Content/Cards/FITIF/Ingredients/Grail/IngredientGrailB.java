package TheSecretHistories.Content.Cards.FITIF.Ingredients.Grail;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class IngredientGrailB  extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientGrailB.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = GRAIL;
    private static final String IMG_NAME = "ingredientgrailb";
    private static final int COST = 1;
    private static final AbstractCard.CardType TYPE = CardType.ATTACK;
    private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
    private static final AbstractCard.CardTarget TARGET = CardTarget.ENEMY;

    public IngredientGrailB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.damage = this.baseDamage = 6;
        this.baseMagicNumber = this.magicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
        addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber));
    }


    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.upgradeDamage(2);
        this.upgradeMagicNumber(1);
        super.OnUpgrade(timesUpgraded);
    }
}