package TheSecretHistories.Content.Cards.FITIF.Ingredients.Knock;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;
public class IngredientKnockB extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientKnockB.class.getSimpleName());
    private static final CardTags PRINCIPLE_TAG = KNOCK;
    private static final String IMG_NAME = "ingredientknockb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    public IngredientKnockB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseDamage = this.damage=12;
        this.isMultiDamage = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        int actualDamage = this.damage - PowerUtils.GetPowerAmount(Knock.POWER_ID, p);
        if (actualDamage < 0) actualDamage = 0;

        for (AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
            if (!mo.isDeadOrEscaped()) {
                addToBot(new DamageAction(mo,
                        new DamageInfo(p, actualDamage, this.damageTypeForTurn),
                        AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            }
        }
    }

    public void  OnUpgrade(int timesUpgraded){
            upgradeDamage(3);
            //upgradeMagicNumber(1);
    }

}
