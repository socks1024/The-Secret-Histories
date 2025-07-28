package TheSecretHistories.Content.Cards.FITIF.Ingredients.Knock;

import TheSecretHistories.Content.Actions.UniqueCards.ReduceHandCostAction;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class IngredientKnockF extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientKnockF.class.getSimpleName());
    private static final CardTags PRINCIPLE_TAG = KNOCK;
    private static final String IMG_NAME = "ingredientknockf";
    private static final int COST = 4;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public IngredientKnockF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.exhaust = true;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new ReduceHandCostAction());
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.selfRetain = true;
        super.OnUpgrade(timesUpgraded);
    }
}
