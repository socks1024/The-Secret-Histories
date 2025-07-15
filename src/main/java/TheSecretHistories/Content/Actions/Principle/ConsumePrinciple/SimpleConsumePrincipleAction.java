package TheSecretHistories.Content.Actions.Principle.ConsumePrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class SimpleConsumePrincipleAction extends ConsumePrincipleAction {

    public SimpleConsumePrincipleAction(AbstractCreature source, AbstractCard.CardTags principleTag) {
        super(source, principleTag);
    }

    public SimpleConsumePrincipleAction(AbstractCreature source, AbstractCard.CardTags principleTag, int amount) {
        super(source, principleTag, amount);
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {

        isDone = true;

    }
}
