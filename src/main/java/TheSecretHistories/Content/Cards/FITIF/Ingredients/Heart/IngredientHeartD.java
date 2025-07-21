package TheSecretHistories.Content.Cards.FITIF.Ingredients.Heart;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientHeartDPrincipleAction;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class IngredientHeartD extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientHeartD.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = HEART;
    private static final String IMG_NAME = "ingredientheartd";
    private static final int COST = 1;
    private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = CardRarity.UNCOMMON;
    private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;

    public IngredientHeartD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.exhaust = true;

        this.baseBlock = this.block = 0;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.exhaust = false;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        super.use(p, m);

        baseBlock = Math.max(principleCount, PrincipleUtils.GetPlayerPrincipleAmount(HEART));

        calculateDamageDisplay(m);

        addToBot(new IngredientHeartDPrincipleAction(p, p, HEART, block));
    }

    @Override
    protected void PreApplyPowers() {
        super.PreApplyPowers();

        baseBlock = PrincipleUtils.GetPlayerPrincipleAmount(HEART);
    }
}
