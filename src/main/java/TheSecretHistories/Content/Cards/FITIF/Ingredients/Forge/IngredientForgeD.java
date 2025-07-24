package TheSecretHistories.Content.Cards.FITIF.Ingredients.Forge;

import TheSecretHistories.Content.Actions.UniqueCards.ExhaustByTagGainBlockAction;
import TheSecretHistories.Content.Actions.UniqueCards.IngredientForgeDAction;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class IngredientForgeD extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientForgeD.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = FORGE;
    private static final String IMG_NAME = "ingredientforged";
    private static final int COST = 0;
    private static final AbstractCard.CardType TYPE = CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
    private static final AbstractCard.CardTarget TARGET = CardTarget.SELF;

    public IngredientForgeD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.exhaust = true;
//        this.block = this.baseBlock = 7;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.exhaust = false;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        addToBot(new IngredientForgeDAction(p, upgraded));
//        addToBot(new ExhaustByTagGainBlockAction(p, INGREDIENT, this.block));
//        addToBot(new ExhaustByTagGainBlockAction(p, TOOL, this.block));
    }

}
