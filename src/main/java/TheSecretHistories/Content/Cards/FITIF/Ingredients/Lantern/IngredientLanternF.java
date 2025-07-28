package TheSecretHistories.Content.Cards.FITIF.Ingredients.Lantern;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.UniqueCards.IngredientLanternFPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class IngredientLanternF extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientLanternF.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = LANTERN;
    private static final String IMG_NAME = "ingredientlanternf";
    private static final int COST = 3;
    private static final AbstractCard.CardType TYPE = CardType.POWER;
    private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
    private static final AbstractCard.CardTarget TARGET = CardTarget.SELF;
    public IngredientLanternF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        //this.baseMagicNumber = this.magicNumber = 99;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isInnate = true;
        super.OnUpgrade(timesUpgraded);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer,new IngredientLanternFPower(abstractPlayer, magicNumber), magicNumber));
    }
}
