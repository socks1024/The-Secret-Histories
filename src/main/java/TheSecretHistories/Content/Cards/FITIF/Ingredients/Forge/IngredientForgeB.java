package TheSecretHistories.Content.Cards.FITIF.Ingredients.Forge;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class IngredientForgeB extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientForgeB.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = FORGE;
    private static final String IMG_NAME = "ingredientforgeb";
    private static final int COST = 1;
    private static final AbstractCard.CardType TYPE = CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
    private static final AbstractCard.CardTarget TARGET = CardTarget.SELF;

    public IngredientForgeB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.block = this.baseBlock = 8;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBlock(3);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);
        addToBot(new GainBlockAction(abstractPlayer, abstractPlayer, this.block));
        addToBot(new ExhaustAction(1, false));
    }
}
