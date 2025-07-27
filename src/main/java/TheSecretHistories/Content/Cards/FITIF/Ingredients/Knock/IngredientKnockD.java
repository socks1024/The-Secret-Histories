package TheSecretHistories.Content.Cards.FITIF.Ingredients.Knock;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class IngredientKnockD extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientKnockD.class.getSimpleName());
    private static final CardTags PRINCIPLE_TAG = KNOCK;
    private static final String IMG_NAME = "ingredientknockd";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public IngredientKnockD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.exhaust = true;

        this.magicNumber = this.baseMagicNumber = 3;
        this.damage = this.baseDamage = 0;
    }
    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        super.use(p, m);

        this.baseDamage = DeckUtils.GetMansusLevel();

        this.calculateDamageDisplay(m);

        for (int i = 0; i < magicNumber; i++) {
            addToBot(new DamageAction(m, new DamageInfo(p,this.damage)));
        }
    }

    @Override
    protected void PreApplyPowers() {
        super.PreApplyPowers();

        this.baseDamage = DeckUtils.GetMansusLevel();
    }
}
