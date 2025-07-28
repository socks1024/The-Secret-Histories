package TheSecretHistories.Content.Cards.FITIF.Ingredients.Winter;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.Lantern.IngredientLanternB;
import TheSecretHistories.Content.Powers.UniqueCards.IngredientLanternFPower;
import TheSecretHistories.Content.Powers.UniqueCards.IngredientWinterBPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;


public class IngredientWinterB extends AbstractIngredient  {

    public static final String ID = StringUtils.MakeID(IngredientWinterB.class.getSimpleName());

    private static final AbstractCard.CardTags PRINCIPLE_TAG = WINTER;

    private static final String IMG_NAME = "ingredientwinterb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    public IngredientWinterB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer,new IngredientWinterBPower(abstractPlayer, magicNumber), magicNumber));
    }
    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBaseCost(0);
        super.OnUpgrade(timesUpgraded);
    }
}

