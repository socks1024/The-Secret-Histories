package TheSecretHistories.Content.Cards.FITIF.Ingredients.Edge;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Lantern.IngredientLanternB;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class IngredientEdgeB extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientEdgeB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = EDGE;

    private static final String IMG_NAME = "ingredientedgeb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public IngredientEdgeB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
        //addToBot(new ApplyPowerAction(p, p, new LoseStrengthPower(p, this.magicNumber), this.magicNumber));
    }
}
