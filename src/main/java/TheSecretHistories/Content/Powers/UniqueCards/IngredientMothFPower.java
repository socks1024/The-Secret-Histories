package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.INGREDIENT;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.TOOL;

public class IngredientMothFPower extends TemplateCustomPower {
    public static final String POWER_ID = StringUtils.MakeID(IngredientMothFPower.class.getSimpleName());
    private static final String IMG_NAME = "ingredientmothf";
    public IngredientMothFPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        this.type = PowerType.BUFF;
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.purgeOnUse) {
            return;
        }
        if (amount > 0 && (card.hasTag(TOOL) || card.hasTag(INGREDIENT))) {
            flash();
            AbstractMonster m = action.target instanceof AbstractMonster ? (AbstractMonster)action.target : null;
            AbstractCard copy = card.makeSameInstanceOf();
            copy.purgeOnUse = true;
            AbstractDungeon.player.limbo.addToBottom(copy);
            copy.current_x = card.current_x;
            copy.current_y = card.current_y;
            copy.target_x = Settings.WIDTH / 2f - 300f * Settings.scale;
            copy.target_y = Settings.HEIGHT / 2f;
            if (m != null) copy.calculateCardDamage(m);
            AbstractDungeon.actionManager.addCardQueueItem(
                    new CardQueueItem(copy, m, card.energyOnUse, true, true), true
            );

            amount--;
            if (amount <= 0) {
                addToTop(new RemoveSpecificPowerAction(owner, owner, POWER_ID));
            } else {
                updateDescription();
            }
        }
    }
}

