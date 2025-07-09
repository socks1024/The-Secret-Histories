package TheSecretHistories.Content.Actions;

import TheSecretHistories.Content.Powers.Principles.*;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class GainPrincipleAction extends AbstractGameAction {

    private AbstractPrinciple principlePower;

    public GainPrincipleAction(AbstractCreature target, AbstractPrinciple principlePower){
        this.target = target;

        this.principlePower = principlePower;
    }

    public GainPrincipleAction(AbstractCreature target, AbstractCard.CardTags principleTag, int amount) {
        this.target = target;

        this.principlePower = GetPrinciplePowerByTag(principleTag, amount);
    }

    @Override
    public void update() {

        if (!target.hasPower(principlePower.ID) || principlePower.stack) {

            AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(target, source, principlePower));

        } else {

            AbstractPrinciple currPrinciple = (AbstractPrinciple)target.getPower(principlePower.ID);

            if (currPrinciple.amount < principlePower.amount){
                currPrinciple.amount = principlePower.amount;
            }

        }

        isDone = true;
    }

    private AbstractPrinciple GetPrinciplePowerByTag(AbstractCard.CardTags tags, int principle) {

        if(tags.equals(LANTERN)){return new Lantern(AbstractDungeon.player, principle);}
        if(tags.equals(FORGE)){return new Forge(AbstractDungeon.player, principle);}
        if(tags.equals(EDGE)){return new Edge(AbstractDungeon.player, principle);}
        if(tags.equals(WINTER)){return new Winter(AbstractDungeon.player, principle);}
        if(tags.equals(HEART)){return new Heart(AbstractDungeon.player, principle);}
        if(tags.equals(GRAIL)){return new Grail(AbstractDungeon.player, principle);}
        if(tags.equals(MOTH)){return new Moth(AbstractDungeon.player, principle);}
        if(tags.equals(KNOCK)){return new Knock(AbstractDungeon.player, principle);}
        if(tags.equals(SECRET_HISTORIES)){return new SecretHistories(AbstractDungeon.player, principle);}

        return new Knock(AbstractDungeon.player, 1);
    }
}
