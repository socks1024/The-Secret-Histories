package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Powers.UniqueCards.ToolLanternFPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class ToolEdgeBAction extends AbstractGameAction {

    private DamageInfo info;

    private int str;

    public ToolEdgeBAction(AbstractCreature target, AbstractCreature source, DamageInfo damageInfo, int str) {
        this.target = target;
        this.source = source;
        this.info = damageInfo;
        this.str = str;
    }

    @Override
    public void update() {

        AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AttackEffect.SMASH));
        this.target.damage(this.info);
        if ((((AbstractMonster)this.target).isDying || this.target.currentHealth <= 0) && !this.target.halfDead && !this.target.hasPower("Minion")) {
            addToTop(new ApplyPowerAction(source, source, new StrengthPower(source, str)));
        }

        if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead()) AbstractDungeon.actionManager.clearPostCombatActions();

        tickDuration();

        isDone = true;
    }
}
