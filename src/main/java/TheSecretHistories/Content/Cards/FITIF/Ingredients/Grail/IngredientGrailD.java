package TheSecretHistories.Content.Cards.FITIF.Ingredients.Grail;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.UniqueCards.IngredientGrailDPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class IngredientGrailD extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientGrailD.class.getSimpleName());
    private static final CardTags PRINCIPLE_TAG = GRAIL;
    private static final String IMG_NAME = "ingredientgraild";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.SELF;

    public IngredientGrailD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.principleCount = this.basePrincipleCount = 8;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new ApplyPowerAction(p, p, new IngredientGrailDPower(p, magicNumber)));

    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
        super.OnUpgrade(timesUpgraded);
    }
}