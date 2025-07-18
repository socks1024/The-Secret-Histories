package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Moth;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DrawFullAndDamageAction extends AbstractGameAction {

    private final int damagePerDraw;

    public DrawFullAndDamageAction(AbstractCreature source, int damagePerDraw) {
        this.source = source;
        this.damagePerDraw = damagePerDraw;
    }

    @Override
    public void update() {
        int handSize = AbstractDungeon.player.hand.size();
        int maxHandSize = BaseMod.MAX_HAND_SIZE;

        int remainingDraw = AbstractDungeon.player.drawPile.size() + AbstractDungeon.player.discardPile.size();
        int handRoom = maxHandSize - handSize;

        int actualDraw = Math.min(handRoom, remainingDraw);

        if (actualDraw > 0) {
            for (int i = 0; i < actualDraw; i++) {
                addToBot(new DrawCardAction(source, 1));
                addToBot(new DamageAllEnemiesAction(
                        source,
                        DamageInfo.createDamageMatrix(damagePerDraw, true),
                        DamageInfo.DamageType.NORMAL,
                        AttackEffect.SLASH_HORIZONTAL
                ));
                addToBot(new WaitAction(0.05F)); // 可以微调
            }
        }

        this.isDone = true;
    }
}