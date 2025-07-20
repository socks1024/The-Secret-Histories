package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class GrailFAction2 extends ConsumePrincipleAction {

    private final int principleNeed;

    public GrailFAction2(AbstractCreature target, AbstractCreature source, AbstractCard.CardTags principleTag, int principleNeed) {
        super(source, principleTag);
        this.target = target;

        this.principleNeed = principleNeed;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {

        for (int i = 0; i < consumedAmount / principleNeed; i++) {
            int roll = AbstractDungeon.miscRng.random(2);
            switch (roll) {
                case 0:
                    addToTop(new ApplyPowerAction(target, source, new StrengthPower(target, -1)));
                    break;
                case 1:
                    addToTop(new ApplyPowerAction(target, source, new WeakPower(target, 1, false)));
                    break;
                case 2:
                    addToTop(new ApplyPowerAction(target, source, new VulnerablePower(target, 1, false)));
                    break;
            }
        }


        isDone = true;

    }
}
