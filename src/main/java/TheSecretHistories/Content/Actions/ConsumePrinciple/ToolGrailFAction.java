package TheSecretHistories.Content.Actions.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class ToolGrailFAction extends ConsumePrincipleAction {

    private int principleNeed;


    public ToolGrailFAction(AbstractCreature target, AbstractCard.CardTags principleTag, int principleNeed) {
        super(target, principleTag);

        this.principleNeed = principleNeed;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {

        for (int i = 0; i < consumedAmount / principleNeed; i++) {

        }

    }
}
