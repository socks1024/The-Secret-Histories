package TheSecretHistories.Content.Cards.FITIF.Ingredients.Forge;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.unique.ArmamentsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class IngredientForgeF extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientForgeF.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = FORGE;
    private static final String IMG_NAME = "ingredientforgef";
    private static final int COST = 0;
    private static final AbstractCard.CardType TYPE = CardType.ATTACK;
    private static final AbstractCard.CardRarity RARITY = CardRarity.SPECIAL;
    private static final AbstractCard.CardTarget TARGET = CardTarget.SELF;

    public IngredientForgeF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.exhaust = true;
        this.principleCount = this.basePrincipleCount = 12;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new ArmamentsAction(this.upgraded));
    }
    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}
