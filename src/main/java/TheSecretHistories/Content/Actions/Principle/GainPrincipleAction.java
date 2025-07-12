package TheSecretHistories.Content.Actions.Principle;

import TheSecretHistories.Content.Powers.Principles.*;
import TheSecretHistories.Utils.PrincipleUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GainPrincipleAction extends AbstractGameAction {

    private final AbstractPrinciple principlePower;

    public GainPrincipleAction(AbstractCreature target, AbstractCard.CardTags principleTag, int amount) {
        this.target = target;

        this.principlePower = PrincipleUtils.GetPrinciplePowerByTag(principleTag, amount);
    }

    @Override
    public void update() {

        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(target, source, principlePower));

        isDone = true;
    }
}
