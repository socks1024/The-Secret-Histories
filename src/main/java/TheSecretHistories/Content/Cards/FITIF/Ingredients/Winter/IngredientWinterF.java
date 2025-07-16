package TheSecretHistories.Content.Cards.FITIF.Ingredients.Winter;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class IngredientWinterF extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientWinterF.class.getSimpleName());

    private static final AbstractCard.CardTags PRINCIPLE_TAG = WINTER;

    private static final String IMG_NAME = "ingredientwinterf";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public IngredientWinterF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = 10;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new Winter(m, this.magicNumber)));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {upgradeDamage(3);}

}

