package TheSecretHistories.Content.Cards.FITIF.Ingredients.Winter;

import TheSecretHistories.Content.Actions.UniqueCards.WinterStrikeAction;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;


public class IngredientWinterD extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientWinterD.class.getSimpleName());

    private static final AbstractCard.CardTags PRINCIPLE_TAG = WINTER;

    private static final String IMG_NAME = "ingredientwinterd";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    public IngredientWinterD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.damage = this.baseDamage = 5;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new WinterStrikeAction(p, this.damage, this.damageTypeForTurn));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {upgradeDamage(2);}

}
