package TheSecretHistories.Content.Cards.FITIF.Ingredients.Lantern;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;


public class IngredientLanternB extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientLanternB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = LANTERN;

    private static final String IMG_NAME = "ingredientlanternb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public IngredientLanternB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);
        addToBot(new DrawCardAction(abstractPlayer, this.magicNumber));
        addToBot(new DiscardAction(abstractPlayer, abstractPlayer, 1, false));
    }
}
