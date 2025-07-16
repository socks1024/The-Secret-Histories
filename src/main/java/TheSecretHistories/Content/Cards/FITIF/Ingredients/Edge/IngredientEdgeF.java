package TheSecretHistories.Content.Cards.FITIF.Ingredients.Edge;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientEdgeFPrincipleAction;
import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.ToolGrailFAction;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Lantern.IngredientLanternB;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;


public class IngredientEdgeF extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientEdgeF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = EDGE;

    private static final String IMG_NAME = "ingredientedgef";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public IngredientEdgeF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.damage = this.baseDamage = 10;
        this.baseMagicNumber = 3;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(4);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new IngredientEdgeFPrincipleAction(m, p, PRINCIPLE_TAG, 3, damage));
    }

}
