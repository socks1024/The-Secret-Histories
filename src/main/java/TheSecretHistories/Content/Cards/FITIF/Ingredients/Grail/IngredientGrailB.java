package TheSecretHistories.Content.Cards.FITIF.Ingredients.Grail;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Forge.IngredientForgeB;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class IngredientGrailB  extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientGrailB.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = GRAIL;
    private static final String IMG_NAME = "ingredientgrailb";
    private static final int COST = 1;
    private static final AbstractCard.CardType TYPE = CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
    private static final AbstractCard.CardTarget TARGET = CardTarget.SELF;

    public IngredientGrailB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseBlock = 0;
        this.block = this.baseBlock;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new GainBlockAction(p, p, this.block));
    }

    @Override
    public void applyPowers() {
        this.baseBlock = AbstractDungeon.player.discardPile.size();
        if (this.upgraded) {
            this.baseBlock += 4;
        }
        super.applyPowers();
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeName();
    }
}