package TheSecretHistories.Content.Cards.FITIF.Ingredients.Grail;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.UniqueCards.IngredientGrailDPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class IngredientGrailF extends AbstractIngredient {

    public static final String ID = StringUtils.MakeID(IngredientGrailF.class.getSimpleName());
    private static final CardTags PRINCIPLE_TAG = GRAIL;
    private static final String IMG_NAME = "ingredientgrailf";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public IngredientGrailF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = 99;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        if (!this.upgraded) {
            applyLoseStrength(p, m);
        } else {
            for (AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
                applyLoseStrength(p, mo);
            }
        }
    }

    private void applyLoseStrength(AbstractCreature source, AbstractCreature target) {
        addToBot(new ApplyPowerAction(target, source, new StrengthPower(target, -this.magicNumber)));

        addToBot(new ApplyPowerAction(target, source, new GainStrengthPower(target, this.magicNumber)));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
            this.target = CardTarget.ALL_ENEMY;
        super.OnUpgrade(timesUpgraded);
    }
}