package TheSecretHistories.Content.Actions.Principle;

import TheSecretHistories.Content.Powers.Principles.*;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.PrincipleUtils;
import basemod.devcommands.power.Power;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GainPrincipleAction extends AbstractGameAction {

    private final AbstractPrinciple principlePower;

    public GainPrincipleAction(AbstractCreature target, AbstractCard.CardTags principleTag, int amount) {
        this.target = target;

        this.principlePower = PrincipleUtils.GetPrinciplePower(principleTag, amount);
    }

    @Override
    public void update() {

        if (principlePower.amount != 0) {
            if (principlePower.stack) {
                AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(target, source, principlePower));
            } else {
                if (principlePower.amount > PowerUtils.GetPowerAmount(principlePower.ID, target)) {
                    principlePower.amount -= PowerUtils.GetPowerAmount(principlePower.ID, target);
                    AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(target, source, principlePower));
                }
            }
        }

        isDone = true;
    }
}
