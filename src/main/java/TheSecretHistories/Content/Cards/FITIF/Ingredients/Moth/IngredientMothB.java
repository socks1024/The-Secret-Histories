package TheSecretHistories.Content.Cards.FITIF.Ingredients.Moth;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientEdgeFPrincipleAction;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;


public class IngredientMothB extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientMothB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = MOTH;

    private static final String IMG_NAME = "ingredientmothb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public IngredientMothB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                int mothAmount = PowerUtils.GetPowerAmount(Moth.POWER_ID, p);
                int times = mothAmount / 4;
                if (times > 0) {
                    addToBot(new DrawCardAction(p, times * magicNumber));
                    addToBot(new DiscardAction(p, p, times, false));
                }
                isDone = true;
            }
        });
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }
}
