package TheSecretHistories.Content.Cards.FITIF.Ingredients.Knock;

import TheSecretHistories.Content.Cards.FITIF.Ingredients.AbstractIngredient;
import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class IngredientKnockB extends AbstractIngredient {
    public static final String ID = StringUtils.MakeID(IngredientKnockB.class.getSimpleName());
    private static final CardTags PRINCIPLE_TAG = KNOCK;
    private static final String IMG_NAME = "ingredientknockb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final int BASE_DAMAGE = 12;
    private static final int UPGRADE_PLUS_DMG = 3;
    public IngredientKnockB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseDamage = BASE_DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int enlightenment = m.hasPower(Knock.POWER_ID) ?
                m.getPower(Knock.POWER_ID).amount : 0;

        int actualDamage = this.baseDamage - enlightenment;
        if (actualDamage < 0) actualDamage = 0;
        addToBot(new DamageAction(m,
                new DamageInfo(p, actualDamage, this.damageTypeForTurn),
                AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }

    public void  OnUpgrade(int timesUpgraded){
            upgradeDamage(1);
            upgradeMagicNumber(1);
    }

}
