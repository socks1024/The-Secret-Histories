package TheSecretHistories.Content.Cards.FITIF.Ingredients.Heart;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class IngredientHeartB extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientHeartB.class.getSimpleName());
    private static final AbstractCard.CardTags PRINCIPLE_TAG = HEART;
    private static final String IMG_NAME = "ingredientheartb";
    private static final int COST = 1;
    private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = CardRarity.COMMON;
    private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;

    public IngredientHeartB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.block = this.baseBlock = 10;
        this.isInnate = true;
    }
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);
        addToBot(new GainBlockAction(abstractPlayer, abstractPlayer, this.block));
    }
    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBlock(4);
    }
}
