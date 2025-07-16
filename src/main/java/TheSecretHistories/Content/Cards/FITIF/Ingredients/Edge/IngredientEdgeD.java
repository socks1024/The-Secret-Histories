package TheSecretHistories.Content.Cards.FITIF.Ingredients.Edge;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.UniqueCards.IngredientEdgeDPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class IngredientEdgeD extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientEdgeD.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = EDGE;
    private static final String IMG_NAME = "ingredientedged";
    private static final int COST = 1;
    private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
    private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;

    public IngredientEdgeD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.exhaust = true;
        this.baseMagicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new ApplyPowerAction(p, p, new IngredientEdgeDPower(p, 1)));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.exhaust = false;
    }

}
