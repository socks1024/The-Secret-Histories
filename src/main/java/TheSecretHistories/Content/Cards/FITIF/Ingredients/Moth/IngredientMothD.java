package TheSecretHistories.Content.Cards.FITIF.Ingredients.Moth;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;


public class IngredientMothD extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientMothD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = MOTH;

    private static final String IMG_NAME = "ingredientmothd";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.NONE;

    public IngredientMothD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                addToTop(new ApplyPowerAction(p, p, new Moth(p, PrincipleUtils.GetPlayerPrincipleAmount(MOTH))));
                isDone = true;
            }
        });
    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        this.exhaust = false;
        super.OnUpgrade(timesUpgraded);
    }
}
