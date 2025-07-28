package TheSecretHistories.Content.Cards.FITIF.Ingredients.Heart;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Moth.IngredientMothB;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Moth.IngredientMothD;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Moth.IngredientMothF;
import TheSecretHistories.Content.Cards.Others.Mental.Fascination;
import TheSecretHistories.Content.Cards.Others.Mental.Restlessness;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.powers.IntangiblePower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class IngredientHeartF extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientHeartF.class.getSimpleName());
    private static final CardTags PRINCIPLE_TAG = HEART;
    private static final String IMG_NAME = "ingredientheartf";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public IngredientHeartF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 2;
        this.exhaust = true;
        this.cardsToPreview = new Restlessness();
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        super.use(p, m);
        addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, this.magicNumber), this.magicNumber));

        addToBot(new MakeTempCardInHandAction(new Restlessness(), 2));
    }
    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
        super.OnUpgrade(timesUpgraded);
    }
}
