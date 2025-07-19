package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.lang.reflect.Field;

public class MirrorStrikeAction extends AbstractGameAction {
    private AbstractMonster target;
    private AbstractCard sourceCard;
    private int upgraded;

    public MirrorStrikeAction(AbstractMonster target, AbstractCard sourceCard, int upgraded) {
        this.target = target;
        this.sourceCard = sourceCard;
        this.upgraded = upgraded;
        this.duration = 0.0F;
        this.actionType = ActionType.DAMAGE;
    }

    @Override
    public void update() {
        if (target == null || target.isDeadOrEscaped()) {
            this.isDone = true;
            return;
        }

        int baseDmg = target.getIntentBaseDmg();
        int multiAmt = 1;

        //System.out.println("[MirrorStrike] Intent base damage: " + baseDmg);

        //System.out.println("[MirrorStrike] Intent base damage: " + baseDmg);
        try {
            Field field = AbstractMonster.class.getDeclaredField("intentMultiAmt");
            field.setAccessible(true);
            multiAmt = field.getInt(target);

            if (multiAmt < 1) {
                multiAmt = 1;
                //System.out.println("[MirrorStrike] intentMultiAmt < 1, fallback to 1");
            } else {
                //System.out.println("[MirrorStrike] Intent multi amount: " + multiAmt);
            }
        } catch (Exception e) {
            //System.out.println("[MirrorStrike] Failed to reflect intentMultiAmt: " + e.getMessage());
            multiAmt = 1;
        }


        if (baseDmg < 0) {
            this.isDone = true;
            return;
        }

        int totalDamage = baseDmg * multiAmt;
        if (upgraded > 0) {
            totalDamage *= 2;
        }

        AbstractPlayer player = AbstractDungeon.player;

        for (int i = 0; i < multiAmt; i++) {
            DamageInfo info = new DamageInfo(player, baseDmg, DamageInfo.DamageType.NORMAL);
            info.applyPowers(player, target);
            System.out.println("[MirrorStrike] Dealing " + info.output + " damage to " + (target != null ? target.name : "null"));
            addToTop(new DamageAction(target, info, AttackEffect.SLASH_DIAGONAL));
        }

        this.isDone = true;
    }
}
