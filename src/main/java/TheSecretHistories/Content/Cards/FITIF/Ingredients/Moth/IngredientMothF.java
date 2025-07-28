package TheSecretHistories.Content.Cards.FITIF.Ingredients.Moth;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.UniqueCards.IngredientMothFPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;


public class IngredientMothF extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientMothF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = MOTH;

    private static final String IMG_NAME = "ingredientmothf";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public IngredientMothF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new ApplyPowerAction(p, p, new IngredientMothFPower(p, this.magicNumber)));
    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
            upgradeMagicNumber(1);
        super.OnUpgrade(timesUpgraded);

    }
}
